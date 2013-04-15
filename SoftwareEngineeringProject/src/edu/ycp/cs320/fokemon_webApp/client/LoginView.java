package edu.ycp.cs320.fokemon_webApp.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.client.RPC;

import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.i18n.client.HasDirection.Direction;
import com.google.gwt.user.client.ui.CheckBox;

public class LoginView extends Composite {

	private TextBox textBoxUsername;
	private TextBox textBoxPassword;
	private Login model;

	public LoginView() {
		FlowPanel panel = new FlowPanel();
		initWidget(panel);
		model = new Login();

		Label lblLoginToYour = new Label("Sign in to your account");
		lblLoginToYour.setStyleName("gwt-Label-Login");
		panel.add(lblLoginToYour);

		FlexTable flexTable = new FlexTable();
		panel.add(flexTable);
		flexTable.setWidth("345px");

		Label lblUsername = new Label("Username:");
		lblUsername.setStyleName("gwt-Label-Login");
		flexTable.setWidget(0, 0, lblUsername);

		textBoxUsername = new TextBox();
		flexTable.setWidget(0, 1, textBoxUsername);

		Label lblPassword = new Label("Password:");
		lblPassword.setStyleName("gwt-Label-Login");
		flexTable.setWidget(1, 0, lblPassword);

		textBoxPassword = new TextBox();
		textBoxPassword.setDirection(Direction.RTL);
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
					
					// Switch to some other view
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
}
