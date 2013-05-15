package edu.ycp.cs320.fokemon_webApp.client;

import java.sql.SQLException;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;

@RemoteServiceRelativePath("load")
public interface LoadProfileService extends RemoteService {
	/**
	 * 
	 * 
	 * @param message a message to send to the server.
	 * @return true if successful, false otherwise
	 * @throws SQLException 
	 */
	public Player retrieveProfile(Login login);	
	
	public Login createProfile(Login login, Player player1);	
	
	public Player saveProfile(Login model, Player player1);	
}
