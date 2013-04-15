package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

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

}