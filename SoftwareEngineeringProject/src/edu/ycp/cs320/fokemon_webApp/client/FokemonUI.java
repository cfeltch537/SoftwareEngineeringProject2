/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemDatabase;
import edu.ycp.cs320.fokemon_webApp.shared.ItemClasses.ItemName;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */

public class FokemonUI {

	static final String holderId = "canvasholder";

	static final String upgradeMessage = "Your browser does not support the HTML5 Canvas. Please upgrade your browser to view this demo.";

	static LoginView loginView;

	static Button saveButton;
	static CirculatingImagesView tempView;
	static MapView map;
	static BattleView battleView;
	private static PokedexReader pokedex;
	private PokedexReaderServiceAsync pokedexReaderSvc = GWT
			.create(PokedexReaderService.class);
	static final int refreshRate = 25;

	public void initialize() {

		saveButton = new Button("Save");
		saveButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveCurrentProfile();
				//LoginView.saveProfile();
			}
		});
		LoginUI.rootPanel.add(saveButton);
		createPokedexReader();
		map = new MapView();
		LoginUI.rootPanel.add(map.mapPanel);
		map.initialize();      
		map.setFocusCanvas();
		tempView = new CirculatingImagesView();



		final Timer timer = new Timer() {
			@Override
			public void run() {
				doUpdate();

			}
		};
		timer.scheduleRepeating(refreshRate);
	}

	static void doUpdate() {
		if (battleView != null && battleView.battle != null) {
			battleView.doUpdate();
		}
	}


	private void createPokedexReader() {
		// Initialize the service proxy.
		if (pokedexReaderSvc == null) {
			pokedexReaderSvc = GWT.create(PokedexReaderService.class);
		}

		// Set up the callback object.
		AsyncCallback<PokedexReader> callback = new AsyncCallback<PokedexReader>() {
			public void onFailure(Throwable caught) {
				System.out.println("error with CSV File Reader");
				// TODO: Do something with errors.
			}
			public void onSuccess(PokedexReader result) {
				// updateTable(result);
				setPokedex(result);
				System.out.println("Pokedex is Ready");

				if(Game.getUser().getTeam().size() == 0){
					//The following wall of text is to populate the player's array lists
					Game.getUser().getItems().add(ItemDatabase.generateItem(ItemName.SUPER_POTION,5));
					Game.getUser().getItems().add(ItemDatabase.generateItem(ItemName.HYPER_POTION,5));
					Game.getUser().getItems().add(ItemDatabase.generateItem(ItemName.REVIVE,5));
					Game.getUser().getItems().add(ItemDatabase.generateItem(ItemName.MASTER_BALL,5));
					Game.getUser().getItems().add(ItemDatabase.generateItem(ItemName.POKE_BALL,5));
					
					Pokemon Attacker = null;
					switch(Random.nextInt(3)){
					case 0:
						Attacker = Pokemon.GeneratePokemon(PokeID.Charizard, 75);
						Attacker.getInfo().setNickname("Charizizzle");
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Spore));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Flamethrower));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Dragon_Rage));
						break;
					case 1:
						Attacker = Pokemon.GeneratePokemon(PokeID.Blastoise, 75);
						Attacker.getInfo().setNickname("Bluntoise");
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Spore));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Hydro_Pump));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Waterfall));
						break;
					case 2:
						Attacker = Pokemon.GeneratePokemon(PokeID.Venusaur, 75);
						Attacker.getInfo().setNickname("Vaposaur");
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Spore));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.SolarBeam));
						Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Razor_Leaf));
						break;
					}
					
					Game.getUser().getTeam().add(Attacker);
				}
				//Wall of text over


				battleView = new BattleView();

			}
		};

		// Make the call to the stock price service.
		pokedexReaderSvc.readCSV(callback);
		// pokedexReaderSvc.readCSV(callback).getPrices(stocks.toArray(new
		// String[0]), callback);
	}

	public static PokedexReader getPokedex() {
		return pokedex;
	}

	public static void setPokedex(PokedexReader pokedex) {
		FokemonUI.pokedex = pokedex;
	}

	public static void startBattle() {// Instantiates BattleView
		if (pokedex != null) {
			// Call joey's create battle function(s); creating instance of a
			// battle
			if (battleView == null) {
				battleView = new BattleView(); // Instantiate a BattleView
			}
			battleView.setBattle(Battle.wildPokemonBattle());
			LoginUI.rootPanel.remove(map.mapPanel);
			LoginUI.rootPanel.add(battleView.battlePanel);
			battleView.commandOptions.setFocus(true);
		}
	}

	public static void endBattle() {// Instantiates BattleView
		if (pokedex != null) {
			// Call joey's create battle function(s); creating instance of a
			// battle
			LoginUI.rootPanel.remove(battleView.battlePanel);
			LoginUI.rootPanel.add(map.mapPanel);
			battleView.commandOptions.setFocus(true);
			map.setFocusCanvas();
		}
	}

	protected void saveCurrentProfile() {
		RPC.loadProfile.saveProfile(Game.getLogin(),Game.getUser(), new AsyncCallback<Player>() {
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

}
