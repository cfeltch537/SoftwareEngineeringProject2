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

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Login.ColumnPlayer;

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
							"create table users12 (" +
									"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
									"  username VARCHAR(200) NOT NULL, " +
									"  password VARCHAR(200) NOT NULL," +
									"  role VARCHAR(200) NOT NULL," +
									"  playerName VARCHAR(200)," +
									"  playerGender BOOLEAN," +
									"  playerLocationIndex INTEGER," +
									"  playerLocationX INTEGER," +
									"  playerLocationY INTEGER," +
									"  playerPlayerID INTEGER," +
									//LINK THE POKEMON ARRAYLIST"" +
									"  playerCurrentPokemonIndex INTEGER," +
									"  playerTurnChoice INTEGER," +
									"  playerMoveItem INTEGER," +
									"  playerItemIndex INTEGER," +
									"  playerTurnOrder INTEGER" +
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
							"insert into users12 (username, password, role, playerName, playerGender, playerLocationIndex, playerLocationX, playerLocationY, playerPlayerID, playerCurrentPokemonIndex, playerTurnChoice, playerMoveItem, playerItemIndex, playerTurnOrder) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
					    
					stmt.setString(1, "alice");
					stmt.setString(2, "abc");
					stmt.setString(3, "admin");
					stmt.setString(4, "Jody Faloney");
					stmt.setBoolean(5, false);
					stmt.setInt(6, 0);
					stmt.setInt(7, 0);
					stmt.setInt(8, 0);
					stmt.setInt(9, 0);
					//LINK THE POKEMON ARRAYLIST
					stmt.setInt(10, 0);
					stmt.setInt(11, 0);
					stmt.setInt(12, 0);
					stmt.setInt(13, 0);
					stmt.setInt(14, 0);
					stmt.addBatch();

					stmt.setString(1, "bob");
					stmt.setString(2, "123");
					stmt.setString(3, "user");
					stmt.setString(4, "Coey Meltch");
					stmt.setBoolean(5, true);
					stmt.setInt(6, 0);
					stmt.setInt(7, 0);
					stmt.setInt(8, 0);
					stmt.setInt(9, 0);
					//LINK THE POKEMON ARRAYLIST
					stmt.setInt(10, 0);
					stmt.setInt(11, 0);
					stmt.setInt(12, 0);
					stmt.setInt(13, 0);
					stmt.setInt(14, 0);
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
					stmt = conn.prepareStatement("select users12.* from users12 where users12.username = ?");

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
	public ColumnPlayer retrieveProfile(final Login login) throws SQLException {
		return databaseRun(new ITransaction<ColumnPlayer>() {
			@Override
			public ColumnPlayer run(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;


				try {
					stmt = conn.prepareStatement("select users12.* from users12 where users12.username = ?");

					stmt.setString(1, login.getUsername());

					resultSet = stmt.executeQuery();

					if (!resultSet.next()) {
						return null; // no such user
					}

					ColumnPlayer player1 = new ColumnPlayer();
					loadProfileFromResultSet(player1, resultSet);


					return player1;
				} finally {
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}

	protected void loadProfileFromResultSet(ColumnPlayer player1,
			ResultSet resultSet) throws SQLException {
		String temp = resultSet.getString(4);
		temp = resultSet.getString(5);
		
		player1.setName(resultSet.getString(5));
		player1.setGender(resultSet.getBoolean(6));
		player1.setPlayerLocation(resultSet.getInt(7));
		player1.setPlayerLocationX(resultSet.getInt(8));
		player1.setPlayerLocationY(resultSet.getInt(9));
		player1.setPlayerID(resultSet.getInt(10));
		player1.setCurrentPokemonIndex(resultSet.getInt(11));
		player1.setChoice(resultSet.getInt(12));
		player1.setMoveIndex(resultSet.getInt(13));
		player1.setItemIndex(resultSet.getInt(14));
		player1.setTurnOrder(resultSet.getInt(15));
		
		
	}
}



/*
stmt.setString(4, "Jody Faloney");
stmt.setBoolean(5, false);
stmt.setInt(6, 0);
stmt.setInt(7, 0);
stmt.setInt(8, 0);
//LINK THE POKEMON ARRAYLIST
stmt.setInt(9, 0);
stmt.setInt(10, 0);
stmt.setInt(11, 0);
stmt.setInt(12, 0);
stmt.setInt(13, 0);
*/