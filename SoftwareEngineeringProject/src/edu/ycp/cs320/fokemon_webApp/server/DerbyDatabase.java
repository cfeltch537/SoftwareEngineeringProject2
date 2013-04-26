package edu.ycp.cs320.fokemon_webApp.server;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import com.google.gwt.user.cellview.client.Column;

import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class DerbyDatabase implements IDatabase {
	private static final String DATASTORE = "H:/fokemon";

	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new RuntimeException("Could not load Derby JDBC driver");
		}
	}

	private class DatabaseConnection {
		public Connection conn;
		public int refCount;
	}

	private final ThreadLocal<DatabaseConnection> connHolder = new ThreadLocal<DatabaseConnection>();

	private DatabaseConnection getConnection() throws SQLException {
		DatabaseConnection dbConn = connHolder.get();
		if (dbConn == null) {
			dbConn = new DatabaseConnection();
			dbConn.conn = DriverManager.getConnection("jdbc:derby:" + DATASTORE + ";create=true");
			dbConn.refCount = 0;
			connHolder.set(dbConn);
		}
		dbConn.refCount++;
		return dbConn;
	}

	private void releaseConnection(DatabaseConnection dbConn) throws SQLException {
		dbConn.refCount--;
		if (dbConn.refCount == 0) {
			try {
				dbConn.conn.close();
			} finally {
				connHolder.set(null);
			}
		}
	}

	private<E> E databaseRun(ITransaction<E> transaction) throws SQLException {
		// FIXME: retry if transaction times out due to deadlock

		DatabaseConnection dbConn = getConnection();

		try {
			boolean origAutoCommit = dbConn.conn.getAutoCommit();
			try {
				dbConn.conn.setAutoCommit(false);

				return transaction.run(dbConn.conn);
			} finally {
				dbConn.conn.setAutoCommit(origAutoCommit);
			}
		} finally {
			releaseConnection(dbConn);
		}
	}

	void createTables() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {
			@Override
			public Boolean run(Connection conn) throws SQLException {

				PreparedStatement stmt = null;

				try {
					// TODO: add unique index to username column
					stmt = conn.prepareStatement(
							"create table users (" +
									"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
									"  username VARCHAR(200) NOT NULL, " +
									"  password VARCHAR(200) NOT NULL," +
									"  role VARCHAR(200) NOT NULL," +
									"  playerData BLOB " +
									//LINK THE POKEMON ARRAYLIST"" +
									")"
							);

					stmt.executeUpdate();
				} finally {
					DBUtil.closeQuietly(stmt);
				}

				return true;
			}
		});
	}

	void createInitialData() throws SQLException {
		databaseRun(new ITransaction<Boolean>() {

			@Override
			public Boolean run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;

				try {
					stmt = conn.prepareStatement(
							"insert into users (username, password, role, playerData) values ( ?, ?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);


					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream oos = null;

					Player player2 = new Player(2222,"Jody Faloney",false, new Location(0,0,0));
					
					
					try {
						oos = new ObjectOutputStream(baos);
						oos.writeObject(player2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					byte[] tableAsBytes = baos.toByteArray();
					ByteArrayInputStream bais =
							new ByteArrayInputStream(tableAsBytes);




					stmt.setString(1, "alice");
					stmt.setString(2, "abc");
					stmt.setString(3, "admin");
					stmt.setBinaryStream(4,bais, (long) tableAsBytes.length);
					stmt.addBatch();

					Player player3 = new Player(4321,"Coey Meltch",true, new Location(0,0,0));
					baos = new ByteArrayOutputStream();
					oos = null;

					try {
						oos = new ObjectOutputStream(baos);
						oos.writeObject(player3);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					tableAsBytes = baos.toByteArray();
					bais = new ByteArrayInputStream(tableAsBytes);
					stmt.setString(1, "bob");
					stmt.setString(2, "123");
					stmt.setString(3, "user");
					stmt.setBinaryStream(4,bais, (long) tableAsBytes.length);
					stmt.addBatch();

					stmt.executeBatch();

					return true;
				} finally {
					DBUtil.closeQuietly(stmt);
				}
			}

		});
	}

	@Override
	public Login performLogin(final Login login) throws SQLException {
		return databaseRun(new ITransaction<Login>() {
			@Override
			public Login run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement("select users.* from users where users.username = ?");

					stmt.setString(1, login.getUsername());

					resultSet = stmt.executeQuery();

					if (!resultSet.next()) {
						return null; // no such user
					}

					Login user = new Login();
					loadLoginFromResultSet(user, resultSet);

					if (!login.getPassword().equals(user.getPassword())) {
						return null; // password mismatch
					}

					return user;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}



	private void loadLoginFromResultSet(Login user, ResultSet resultSet)
			throws SQLException {
		user.setId(resultSet.getInt(1));
		user.setUsername(resultSet.getString(2));
		user.setPassword(resultSet.getString(3));
		user.setRole(resultSet.getString(4));
	}

	@Override
	public Player retrieveProfile(final Login login) throws SQLException {
		return databaseRun(new ITransaction<Player>() {
			@Override
			public Player run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement("select users.playerData from users where users.username = ?");

					stmt.setString(1, login.getUsername());

					resultSet = stmt.executeQuery();

					if (!resultSet.next()) {
						return null; // no such user
					}

					Player player1 = new Player();
					return loadProfileFromResultSet(player1, resultSet);


				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}
	
	@Override
	public Player saveProfile(final Login login, final Player player1) throws SQLException {
		return databaseRun(new ITransaction<Player>() {
			@Override
			public Player run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement(
							"update users set playerData = ? where users.username = ?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);


					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream oos = null;


					try {
						oos = new ObjectOutputStream(baos);
						oos.writeObject(player1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					byte[] tableAsBytes = baos.toByteArray();
					ByteArrayInputStream bais =
							new ByteArrayInputStream(tableAsBytes);



					stmt.setBinaryStream(1,bais, (long) tableAsBytes.length);
					stmt.setString(2, login.getUsername());
					
					stmt.addBatch();

					stmt.executeBatch();
					
					return retrieveProfile(login);

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
		
	}
	protected Player loadProfileFromResultSet(Player player1,
			ResultSet resultSet) throws SQLException {


		
			ByteArrayInputStream bos = new 
					ByteArrayInputStream(resultSet.getBytes("playerData")) ;
			ObjectInputStream out = null;
			try {
				out = new ObjectInputStream(bos);
				player1=(Player)out.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return player1;
		
		
	}

	@Override
	public Login createProfile(final Login login, final Player player1) throws SQLException {
		return databaseRun(new ITransaction<Login>() {
			@Override
			public Login run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement(
							"insert into users (username, password, role, playerData) values ( ?, ?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);


					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					ObjectOutputStream oos = null;

					
					
					try {
						oos = new ObjectOutputStream(baos);
						oos.writeObject(player1);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					byte[] tableAsBytes = baos.toByteArray();
					ByteArrayInputStream bais =
							new ByteArrayInputStream(tableAsBytes);




					stmt.setString(1, login.getUsername());
					stmt.setString(2, login.getPassword());
					stmt.setString(3, login.getRole());
					stmt.setBinaryStream(4,bais, (long) tableAsBytes.length);
					stmt.addBatch();
					

					stmt.executeBatch();
					
					stmt = conn.prepareStatement("select users.* from users where users.username = ?");

					stmt.setString(1, login.getUsername());

					resultSet = stmt.executeQuery();

					if (!resultSet.next()) {
						return null; // no such user
					}

					Login user = new Login();
					loadLoginFromResultSet(user, resultSet);

					

					return user;

				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	@Override
	public Login checkUsername(final Login _login) throws SQLException {
		return databaseRun(new ITransaction<Login>() {
			@Override
			public Login run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement("select users.* from users where users.username = ?");

					stmt.setString(1, _login.getUsername());

					resultSet = stmt.executeQuery();

					if (resultSet.next()) {
						return null;	//user exists
					}

					Login user = new Login();
					user.setUsername(_login.getUsername());

					return user;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}


}


