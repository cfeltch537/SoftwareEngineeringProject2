package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public interface IDatabase {
	public Login performLogin(Login login) throws SQLException;

	public Player retrieveProfile(Login login) throws SQLException;

	public Player saveProfile(Login login, Player player1) throws SQLException;
	
	public Login createProfile(Login login, Player player1) throws SQLException;

	public Login checkUsername(Login _login) throws SQLException;

	public Player retrieveTrainer(String info) throws SQLException;
}
