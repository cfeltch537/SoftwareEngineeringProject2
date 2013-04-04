package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.core.client.GWT;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;

public class RPC {
	public static final PokedexReaderServiceAsync pokedexReader =
			GWT.create(PokedexReaderService.class);
}
