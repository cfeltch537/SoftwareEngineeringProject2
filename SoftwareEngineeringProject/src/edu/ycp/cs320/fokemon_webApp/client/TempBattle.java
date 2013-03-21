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
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Pokemon;

public class TempBattle {
  
	private Pokemon Attacker;
	private Pokemon Defender;
	private Move AttackerMove;
	private Move DefenderMove;
	private Player user;
	private Player opp;
	private Location loc;
	private Battle battle;
	
  public TempBattle() {
		loc=new Location(0, 0, 0);
		AttackerMove=MoveDataBase.generateMove(MoveName.Tackle);
		DefenderMove=MoveDataBase.generateMove(MoveName.Bite);
		Attacker=new Pokemon(50, 50);
		Defender=new Pokemon(35, 35);
		Attacker.getMoves().add(AttackerMove);
		Attacker.getMoves().add(DefenderMove);
		Defender.getMoves().add(DefenderMove);
		Pokemon Attacker2=new Pokemon(40,40);
		Attacker2=Attacker;
		Pokemon Attacker3=new Pokemon(40,40);
		Attacker3=Attacker;
		
		Pokemon Defender2=new Pokemon(35,35);
		Defender2=Defender;
		Pokemon Defender3=new Pokemon(35,35);
		Defender3=Defender;
		user=new Player(200, "Cody F.", true, loc);
		user.getTeam().add(Attacker);
		user.getTeam().add(Attacker2);
		user.getTeam().add(Attacker3);
		opp=new Player(100,"Roberto", true, loc);
		opp.getTeam().add(Defender);
		opp.getTeam().add(Defender2);
		opp.getTeam().add(Defender3);
		setBattle(new Battle(user, opp));
  }
  
  public Player getUser() {
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