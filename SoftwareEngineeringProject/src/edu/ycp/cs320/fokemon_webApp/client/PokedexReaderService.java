package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;


@RemoteServiceRelativePath("PokedexReader")
public interface PokedexReaderService extends RemoteService {

   PokedexReader readCSV();
}


