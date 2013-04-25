package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.core.client.GWT;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;

public class RPC {
	public static final PokedexReaderServiceAsync pokedexReader =
			GWT.create(PokedexReaderService.class);
	
	public static final LoginServiceAsync login =
			GWT.create(LoginService.class);
	
	public static final LoadProfileServiceAsync loadProfile =
			GWT.create(LoadProfileService.class);
	

}
