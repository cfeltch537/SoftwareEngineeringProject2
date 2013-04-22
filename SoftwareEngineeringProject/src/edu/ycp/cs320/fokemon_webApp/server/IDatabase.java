package edu.ycp.cs320.fokemon_webApp.server;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Login.ColumnPlayer;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public interface IDatabase {
	public Login performLogin(Login login) throws SQLException;

	public ColumnPlayer retrieveProfile(Login login) throws SQLException;
}
