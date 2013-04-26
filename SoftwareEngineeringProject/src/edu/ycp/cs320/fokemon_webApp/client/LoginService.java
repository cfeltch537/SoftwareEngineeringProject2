package edu.ycp.cs320.fokemon_webApp.client;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

@RemoteServiceRelativePath("login")
public interface LoginService extends RemoteService {
	/**
	 * 
	 * 
	 * @param message a message to send to the server.
	 * @return true if successful, false otherwise
	 * @throws SQLException 
	 */
	public Login submitLogin(Login login);
	
	public Login checkUsername(Login login);
}
