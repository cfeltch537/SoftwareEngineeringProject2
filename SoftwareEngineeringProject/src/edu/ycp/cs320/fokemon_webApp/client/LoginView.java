package edu.ycp.cs320.fokemon_webApp.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;

public class LoginView extends Composite {

	AbsolutePanel loginPanel;
	private TextBox textBoxUsername;
	private PasswordTextBox textBoxPassword;
	Login model;
	Boolean validLogin;

	public LoginView() {
		loginPanel = new AbsolutePanel();
		initWidget(loginPanel);
		model = new Login();
		validLogin = false;

		Label lblLoginToYour = new Label("Sign in to your account");
		lblLoginToYour.setStyleName("gwt-Label-Login");
		loginPanel.add(lblLoginToYour);

		FlexTable flexTable = new FlexTable();
		loginPanel.add(flexTable);
		flexTable.setWidth("345px");

		Label lblUsername = new Label("Username:");
		lblUsername.setStyleName("gwt-Label-Login");
		flexTable.setWidget(0, 0, lblUsername);

		textBoxUsername = new TextBox();
		flexTable.setWidget(0, 1, textBoxUsername);

		Label lblPassword = new Label("Password:");
		lblPassword.setStyleName("gwt-Label-Login");
		flexTable.setWidget(1, 0, lblPassword);

		textBoxPassword = new PasswordTextBox();
		flexTable.setWidget(1, 1, textBoxPassword);


		Button btnSignIn = new Button("Sign In");
		btnSignIn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (textBoxUsername.getText().length() == 0	|| textBoxPassword.getText().length() == 0) 
				{
					Window.alert("Username or password is empty."); 
				} 
				else 
				{
					model.setUsername(textBoxUsername.getText());
					model.setPassword(textBoxPassword.getText());
					handleLogin();
					
				}
			}
		});
		flexTable.setWidget(3, 1, btnSignIn);

	}
	protected void handleLogin() {
		RPC.login.submitLogin(model, new AsyncCallback<Login>() {
			@Override
			public void onSuccess(Login result) {
				if (result != null) {
					GWT.log("Login succeeded!");
					Window.alert("Success");
					model.setId(result.getId());
					model.setRole(result.getRole());
					// Switch to some other view
					validLogin = true;
					loadProfile();
				} else {
					GWT.log("Unknown username/password");
					Window.alert("Unknown username/password");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Login failure", caught);

				Window.alert("Failure");

			}
		});
	}

	protected void loadProfile() {
		RPC.loadProfile.retrieveProfile(model, new AsyncCallback<Player>() {
			@Override
			public void onSuccess(Player result) {
				if (result != null) {
					GWT.log("Load succeeded!");
					Window.alert("Load Success");
					// Switch to some other view
					Window.alert(result.getName());
					
					validLogin = true;
				} else {
					GWT.log("Load Fail");
					Window.alert("Load Fail");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Load failure", caught);

				Window.alert("Failure");

			}
		});
	}
}



