package edu.ycp.cs320.fokemon_webApp.client;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
	/**
	 * 
	 * 
	 * @param message a message to send to the server.
	 * @param callback the callback to return true if successful, false otherwise
	 * @throws SQLException 
	 */
	public void submitLogin(Login login, AsyncCallback<Login> callback);
	
	
}
