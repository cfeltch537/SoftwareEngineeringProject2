package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class LoginUI implements EntryPoint {
	static RootPanel rootPanel;
	static LoginView loginView;
	static final String holderId = "loginholder";
	public void onModuleLoad() {
		rootPanel = RootPanel.get();
		
		loginView = new LoginView();
		rootPanel.add(loginView, 10, 10);
		loginView.textBoxUsername.setFocus(true);
		loginView.rdbtnBoy.setValue(true);
		
	}
	public static void removePanel(){
		rootPanel.remove(loginView);
	}
}
