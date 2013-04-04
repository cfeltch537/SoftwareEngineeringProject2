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

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class TempBattle {
  
	private Pokemon Attacker;
	private Pokemon Defender;
	private Move AttackerMove;
	private Move DefenderMove;
	private static Player user;
	private Player opp;
	private Location loc;
	private Battle battle;
	
  public TempBattle() {
		loc=new Location(0, 0, 0);
		user=new Player(200, "Cody F.", true, loc);
		opp=new Player(100,"Roberto", true, loc);
		AttackerMove=MoveDataBase.generateMove(MoveName.Tackle);
		DefenderMove=MoveDataBase.generateMove(MoveName.Bite);
		Attacker=Pokemon.GeneratePokemon(PokeID.Charizard, 50);
		Attacker.getInfo().setNickname("Charizizzle");
		Defender=Pokemon.GeneratePokemon(PokeID.Pikachu, 35);
		Defender.getInfo().setNickname("Pikajew");
		Attacker.getMoves().add(AttackerMove);
		Attacker.getMoves().add(DefenderMove);
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Thunder_Wave));
		Attacker.getMoves().add(MoveDataBase.generateMove(MoveName.Acid));
		Defender.getMoves().add(DefenderMove);
		Pokemon Attacker2=Pokemon.GeneratePokemon(PokeID.Squirtle, 10);
		Pokemon Attacker3=Pokemon.GeneratePokemon(PokeID.Blastoise,30);
		Pokemon Defender2=Pokemon.GeneratePokemon(PokeID.Abra,10);
		Pokemon Defender3=Pokemon.GeneratePokemon(PokeID.Gastly,35);
		user.getTeam().add(Attacker);
		user.getTeam().add(Attacker2);
		user.getTeam().add(Attacker3);
		opp.getTeam().add(Defender);
		opp.getTeam().add(Defender2);
		opp.getTeam().add(Defender3);
		setBattle(new Battle(user, opp));
  }
  

public static Player getUser() {

	return user;
}

public void setUser(Player user) {
	this.user = user;
}

public Player getOpp() {
	return opp;
}

public void setOpp(Player opp) {
	this.opp = opp;
}

public void update() {
    
  }

public Battle getBattle() {
	return battle;
}

public void setBattle(Battle battle) {
	this.battle = battle;
}
}
