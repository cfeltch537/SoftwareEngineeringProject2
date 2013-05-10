
package edu.ycp.cs320.fokemon_webApp.client;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.user.client.Random;
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
import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import com.google.gwt.user.client.ui.RadioButton;

public class LoginView extends Composite {

	AbsolutePanel loginPanel;
	TextBox textBoxUsername;
	PasswordTextBox textBoxPassword;
	PasswordTextBox textBoxPassword2;
	TextBox textBoxName;
	Login model;
	Boolean validLogin;
	Player player1;
	Label lblLoginToYour;
	Label lblUsername;
	Label lblPassword;
	Label lblPassword2;
	Label lblName;
	Label lblGender;
	Label lblAreYouA;
	RadioButton rdbtnBoy;
	RadioButton rdbtnGirl; 
	Button btnStartYourAdventure;
	Button btnRegister;
	Button btnSignIn;
	Label lblChoice;
	RadioButton rdbtnFire;
	RadioButton rdbtnWater;
	RadioButton rdbtnGrass;
	int typeChoice;

	public LoginView() {
		loginPanel = new AbsolutePanel();
		initWidget(loginPanel);
		loginPanel.setSize("572px", "307px");
		model = new Login();
		validLogin = false;
		player1 = new Player();

		lblLoginToYour = new Label("Sign in to your account");
		lblLoginToYour.setStyleName("gwt-Label-Login");
		loginPanel.add(lblLoginToYour);

		FlexTable flexTable = new FlexTable();
		loginPanel.add(flexTable, 0, 24);
		flexTable.setWidth("345px");

		lblUsername = new Label("Username:");
		lblUsername.setStyleName("gwt-Label-Login");
		flexTable.setWidget(0, 0, lblUsername);

		textBoxUsername = new TextBox();
		flexTable.setWidget(0, 1, textBoxUsername);

		lblPassword = new Label("Password:");
		lblPassword.setStyleName("gwt-Label-Login");
		flexTable.setWidget(1, 0, lblPassword);

		lblPassword2 = new Label("Confirm Password");
		lblPassword.setStyleName("gwt-Label-Login");
		flexTable.setWidget(0, 2, lblPassword2);
		lblPassword2.setVisible(false);

		textBoxPassword = new PasswordTextBox();
		flexTable.setWidget(1, 1, textBoxPassword);
		textBoxPassword.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
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
			}
		});

		textBoxPassword2 = new PasswordTextBox();
		flexTable.setWidget(1, 2, textBoxPassword2);
		textBoxPassword2.setVisible(false);
		textBoxPassword2.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (textBoxUsername.getText().length() == 0	|| textBoxPassword.getText().length() == 0) 
					{
						Window.alert("Username or password is empty."); 
					} 
					else if (!textBoxPassword.getText().equals(textBoxPassword2.getText())){
						Window.alert("Passwords do not match."); 
					} else {
						checkUsername();
					}
				}
			}
		});
		lblUsername.setStyleName("gwt-Label-Login");
		lblUsername.setStyleName("gwt-Label-Login");


		lblUsername.setStyleName("gwt-Label-Login");

		btnSignIn = new Button("Sign In");
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

		btnRegister = new Button("Register");
		btnRegister.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Register Line
				if(!textBoxPassword2.isVisible())
				{
					textBoxPassword2.setVisible(true);
					lblPassword2.setVisible(true);
					textBoxPassword2.setFocus(true);
				}
				else
				{
					if (textBoxUsername.getText().length() == 0	|| textBoxPassword.getText().length() == 0) 
					{
						Window.alert("Username or password is empty."); 
					} 
					else if (!textBoxPassword.getText().equals(textBoxPassword2.getText())){
						Window.alert("Passwords do not match."); 
					} else {
						model.setUsername(textBoxUsername.getText());
						model.setPassword(textBoxPassword.getText());
						checkUsername();
						//Check Username
						//if good, register
					}
				}
			}
		});
		flexTable.setWidget(3, 1, btnSignIn);
		flexTable.setWidget(3, 2, btnRegister);

		lblGender = new Label("Gender:");
		flexTable.setWidget(4, 1, lblGender);
		lblGender.setVisible(false);

		lblAreYouA = new Label("Are you a boy, or a girl...?");
		flexTable.setWidget(4, 2, lblAreYouA);
		lblAreYouA.setVisible(false);

		textBoxName = new TextBox();
		flexTable.setWidget(5, 0, textBoxName);
		textBoxName.setVisible(false);
		textBoxName.addKeyDownHandler(new KeyDownHandler() {
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					if (textBoxName.getText().length() == 0	) 
					{
						Window.alert("You have a name, don't you?"); 
					} else {
						player1 = new Player(Random.nextInt(99999),textBoxName.getText(),rdbtnBoy.getValue(),new Location(0,20,20));
						createProfile();
					}
				}
			}
		});

		lblName = new Label("Name:");
		flexTable.setWidget(4, 0, lblName);
		lblName.setVisible(false);

		rdbtnBoy = new RadioButton("new name", "Boy");
		flexTable.setWidget(5, 1, rdbtnBoy);
		rdbtnBoy.setVisible(false);

		rdbtnGirl = new RadioButton("new name", "Girl");
		flexTable.setWidget(5, 2, rdbtnGirl);
		rdbtnGirl.setVisible(false);
		
		lblChoice = new Label("Choose your Pokemon ");
		flexTable.setWidget(6, 0, lblChoice);
		lblChoice.setVisible(false);

		rdbtnFire = new RadioButton("type", "Charmander");
		rdbtnFire.setValue(true);
		flexTable.setWidget(7, 0, rdbtnFire);
		rdbtnFire.setVisible(false);


		rdbtnWater = new RadioButton("type", "Squirtle");
		flexTable.setWidget(7, 1, rdbtnWater);
		rdbtnWater.setVisible(false);


		rdbtnGrass = new RadioButton("type", "Bulbasaur");
		flexTable.setWidget(7, 2, rdbtnGrass);
		rdbtnGrass.setVisible(false);


		btnStartYourAdventure = new Button("Start your adventure!");
		flexTable.setWidget(6, 1, btnStartYourAdventure);
		btnStartYourAdventure.setVisible(false);
		btnStartYourAdventure.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//Register Line

				if (textBoxName.getText().length() == 0	) 
				{
					Window.alert("You have a name, don't you?"); 
				} else {
					player1 = new Player(Random.nextInt(99999),textBoxName.getText(),rdbtnBoy.getValue(),new Location(0,20,20));
					createProfile();
				}

			}
		});

	}

	void initialize() {
		// initialize the login view

	}


	protected void handleLogin() {
		RPC.login.submitLogin(model, new AsyncCallback<Login>() {
			@Override
			public void onSuccess(Login result) {
				if (result != null) {
					GWT.log("Login succeeded!");
					//Window.alert("Success");
					model.setId(result.getId());
					model.setRole(result.getRole());
					// Switch to some other view
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

	protected void checkUsername() {
		RPC.login.checkUsername(model, new AsyncCallback<Login>() {
			@Override
			public void onSuccess(Login result) {
				if (result != null) {
					GWT.log("Username okay!");
					//Window.alert("Success");
					// Switch to some other view

					lblGender.setVisible(true);
					lblAreYouA.setVisible(true);
					textBoxName.setVisible(true);
					lblName.setVisible(true);
					rdbtnBoy.setVisible(true);
					rdbtnGirl.setVisible(true);
					lblChoice.setVisible(true);
					rdbtnFire.setVisible(true);
					rdbtnWater.setVisible(true);
					rdbtnGrass.setVisible(true);
					btnStartYourAdventure.setVisible(true);
					lblLoginToYour.setVisible(false);
					lblUsername.setVisible(false);
					lblPassword.setVisible(false);
					lblPassword2.setVisible(false);
					textBoxUsername.setVisible(false);
					textBoxPassword.setVisible(false);
					textBoxPassword2.setVisible(false);
					btnRegister.setVisible(false);
					btnSignIn.setVisible(false);
					textBoxName.setFocus(true);
					
//					if (model.getPassword().length()>=3){
//						if (model.getPassword().substring(0,3).equals("lol"))
//							model.setRole("admin");
//						else
//							model.setRole("user");
//					} else 
						model.setRole("user");
				} else {
					GWT.log("Username Already Exists");
					Window.alert("Username Already Exists");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Username check failure", caught);

				Window.alert("Username check failure");

			}
		});
	}

	protected void loadProfile() {
		RPC.loadProfile.retrieveProfile(model, new AsyncCallback<Player>() {
			@Override
			public void onSuccess(Player result) {
				if (result != null) {
					GWT.log("Load succeeded!");
					Window.alert("Welcome " + result.getName());
					new Game(result, model, typeChoice);

					//saveProfile();
					LoginUI.removePanel();
					FokemonUI fokeUI = new FokemonUI();
					fokeUI.initialize();
					//validLogin = true;
				} else {
					GWT.log("Load Fail");
					Window.alert("Load Fail");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Load failure", caught);

				Window.alert("Load Failure");

			}
		});
	}
	protected static void saveProfile() {
		RPC.loadProfile.saveProfile(Game.getLogin(),Game.getUser(), new AsyncCallback<Player>() {
			@Override
			public void onSuccess(Player result) {
				if (result != null) {
					GWT.log("Save succeeded!");
					Window.alert("Save Success");


				} else {
					GWT.log("Save Fail");
					Window.alert("Save Fail");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Save failure", caught);

				Window.alert("Failure");

			}
		});
	}

	protected void saveCurrentProfile(Login _login, Player _player) {
		RPC.loadProfile.saveProfile(_login,_player, new AsyncCallback<Player>() {
			@Override
			public void onSuccess(Player result) {
				if (result != null) {
					GWT.log("Save Current succeeded!");
					Window.alert("Save Current Success");

					//Window.alert("Player Name: " + result.getName());
				} else {
					GWT.log("Save Current Fail");
					Window.alert("Save Current Fail");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Save Current failure", caught);

				Window.alert("Save Current Failure");

			}
		});
	}
	protected void createProfile() {
		RPC.loadProfile.createProfile(model, player1, new AsyncCallback<Login>() {
			@Override
			public void onSuccess(Login result) {
				if (result != null) {
					GWT.log("Create succeeded!");
					Window.alert("Create Success");

					model.setId(result.getId());
					//Window.alert("Player Name: " + result.getName());
					if (rdbtnFire.getValue()) 
						typeChoice = 0;
					else if (rdbtnWater.getValue()) 
						typeChoice = 1;
					else if (rdbtnGrass.getValue()) 
						typeChoice = 2;
					loadProfile();
				} else {
					GWT.log("Create Fail");
					Window.alert("Create Fail");
				}

			}

			@Override
			public void onFailure(Throwable caught) {
				GWT.log("Create failure", caught);

				Window.alert("Create Failure");

			}
		});
	}
}


