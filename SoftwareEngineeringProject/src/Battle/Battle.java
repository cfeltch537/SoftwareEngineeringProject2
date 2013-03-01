package Battle;

import PlayerClasses.Player;
import PokemonClasses.Pokemon;

public class Battle {
	private Player user;
	private Player opponent;
	
	
	public Battle(Player user, Player opponent){
		this.setUser(user);
		this.setOpponent(opponent);
		
		
	}


	public Player getUser() {
		return user;
	}


	public void setUser(Player user) {
		this.user = user;
	}


	public Player getOpponent() {
		return opponent;
	}


	public void setOpponent(Player opponent) {
		this.opponent = opponent;
	}

}
