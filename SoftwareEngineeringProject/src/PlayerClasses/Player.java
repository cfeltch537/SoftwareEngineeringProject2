package PlayerClasses;

import java.util.ArrayList;

import PokemonClasses.Pokemon;



public class Player {
	private String name;
	private boolean gender;
	private Location PlayerLocation;
	private int PlayerID;
	private ArrayList <Pokemon> team;
	
	

	public Player(int PlayerID, String name, boolean gender, Location playerLocation){
		this.setPlayerID(PlayerID);
		this.setName(name);
		this.setGender(gender);
		
		team=new ArrayList<Pokemon>();
		setPlayerLocation(new Location(playerLocation.getAreaArrayIndex(), playerLocation.getX(), playerLocation.getY()));
		//team.add(new Pokemon())
		

	}

	public int getTeamSize() {
		return team.size();	
	}

	public Pokemon getTeam(int i) {
		return team.get(i);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Location getPlayerLocation() {
		return PlayerLocation;
	}

	public void setPlayerLocation(Location playerLocation) {
		PlayerLocation = playerLocation;
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}
}
