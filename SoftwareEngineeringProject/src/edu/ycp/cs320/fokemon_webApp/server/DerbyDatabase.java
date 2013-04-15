package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

public class DerbyDatabase implements IDatabase {
	private static final String DATASTORE = "/home/tpowell/fokemon";
	
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
					stmt = conn.prepareStatement(
							"create table login_receipts (" +
							"  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
							"  username VARCHAR(200) NOT NULL, " +
							"  password VARCHAR(200) NOT NULL" +
							"  role VARCHAR(200) NOT NULL" +
							")"
					);
				} finally {
					DBUtil.closeQuietly(stmt);
				}
				
				return true;
			}
		});
	}
	
	@Override
	public Login performLogin(Login login) throws SQLException {
		return databaseRun(new ITransaction<Login>() {
			@Override
			public Login run(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
	
}
