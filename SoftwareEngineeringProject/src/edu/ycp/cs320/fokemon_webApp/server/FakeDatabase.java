package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;

public class FakeDatabase implements IDatabase {
	private List<Login> loginList;

	public FakeDatabase() {
		this.loginList = new ArrayList<Login>();
		
		Login user1 = new Login();
		user1.setId(1);
		user1.setUsername("alice");
		user1.setPassword("abc");
		user1.setRole("admin");
		
		Login user2 = new Login();
		user2.setId(2);
		user2.setUsername("bob");
		user2.setPassword("123");
		user2.setRole("user");
		
		loginList.add(user1);
		loginList.add(user2);
	}

	@Override
	public Login performLogin(Login login) throws SQLException {
		for (Login user : loginList) {
			if (user.getUsername().equals(login.getUsername()) && user.getPassword().equals(login.getPassword())) {
				login.setId(user.getId());
				login.setRole(user.getRole());
				return login;
			}
		}
		return null;
	}

	@Override
	public Player retrieveProfile(Login login) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player saveProfile(Login login, Player player1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login createProfile(Login login, Player player1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login checkUsername(Login _login) {
		// TODO Auto-generated method stub
		return null;
	}
}
