package edu.ycp.cs320.fokemon_webApp.shared.Login;

import java.io.Serializable;
import java.math.BigDecimal;


@SuppressWarnings("serial")
public class Login  implements Serializable {
	public enum Events {
		USERNAME_ENTERED,
		PASSWORD_ENTERED,
	}
	
	private int id;
	private String username;
	private String password;
	private String role;
	

	public Login() {

	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String _username) {
		this.username = _username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String _password) {
		this.password = _password;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}

