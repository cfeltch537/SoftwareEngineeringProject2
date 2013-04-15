package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.SQLException;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

public interface IDatabase {
	public Login performLogin(Login login) throws SQLException;
}
