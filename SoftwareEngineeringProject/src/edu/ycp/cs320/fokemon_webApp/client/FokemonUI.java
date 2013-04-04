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

import java.io.IOException;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */


public class FokemonUI implements EntryPoint {
	
	static final String holderId = "canvasholder";

	  static final String upgradeMessage = "Your browser does not support the HTML5 Canvas. Please upgrade your browser to view this demo.";

	  static CirculatingImagesView tempView;
	  static MapView map;
	  static AbsolutePanel panel;
	  static BattleView battle;
	  private static PokedexReader pokedex;
	  private PokedexReaderServiceAsync pokedexReaderSvc = GWT.create(PokedexReaderService.class);
	  static final int refreshRate = 25;
	  
	  public void onModuleLoad() {

		  panel = new AbsolutePanel();
		  createPokedexReader();
		  map = new MapView();
		  tempView = new CirculatingImagesView();
		  panel.getElement().getStyle().setPosition(Position.RELATIVE);
		 //System.out.println(pokedex.getPokeMap().firstKey().toString());
		  
		  
		  final Timer timer = new Timer() {
		      @Override
		      public void run() {
		        doUpdate();
		      }
		};
		timer.scheduleRepeating(refreshRate);
	  }
	  static void doUpdate() {
		  // update the back canvas, set to front canvas
		//System.out.println(pokedex.getPokeMap().firstKey().toString());
		  map.doUpdate(); 
		  //tempView.doUpdate();
		  if(battle!=null){
		  battle.doUpdate();
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
		        //updateTable(result);
		    	  setPokedex(result);
		    	  battle = new BattleView();

		      }
		    };

		    // Make the call to the stock price service.
		    pokedexReaderSvc.readCSV(callback);
		    //pokedexReaderSvc.readCSV(callback).getPrices(stocks.toArray(new String[0]), callback);
		  }
	public static PokedexReader getPokedex() {
		return pokedex;
	}
	public static void setPokedex(PokedexReader pokedex) {
		FokemonUI.pokedex = pokedex;
	}
}

