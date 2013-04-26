package edu.ycp.cs320.fokemon_webApp.client;

import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoadProfileServiceAsync {
	/**
	 * 
	 * 
	 * @param message a message to send to the server.
	 * @param callback the callback to return true if successful, false otherwise
	 * @throws SQLException 
	 */
	public void retrieveProfile(Login login, AsyncCallback<Player> callback);	
	
	public void createProfile(Login login, Player player1, AsyncCallback<Login> callback);	
	
	public void saveProfile(Login model, Player player1, AsyncCallback<Player> callback);	
}
