package edu.ycp.cs320.fokemon_webApp.client;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface PokedexReaderServiceAsync {

	void readCSV(AsyncCallback<PokedexReader> callback);
}
