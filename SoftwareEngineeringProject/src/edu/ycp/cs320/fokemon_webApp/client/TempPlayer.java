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

import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class TempPlayer {
  
	Player tempPlayer;
	Pokemon charmander;
	Pokemon squirtle;
	
  public TempPlayer() {
	  tempPlayer = new Player(00004, "Cody", true, new Location(0, 20, 20)); // Player Cody
	  //charmander = new Pokemon(57, 65, 71, 14, 61, 48, 32, 47, 46, 48, 74, 14, 4, 154789, "Charmander");
	  //squirtle = new Pokemon(10, 12, 15, 6, 3, 17, 49, 15, 32, 84, 71, 31, 7, 154494, "Squirtle");
  }
  
  public void update() {
    
  }
}