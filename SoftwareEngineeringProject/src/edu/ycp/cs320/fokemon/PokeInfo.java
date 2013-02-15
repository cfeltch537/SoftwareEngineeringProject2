package edu.ycp.cs320.fokemon;



public class PokeInfo {
	private int PokeID;
	private int PlayerID;
	private String PokeName;
	private String Nickname;
	private Boolean Gender;
	private PokeType type;
	private int lvl;
	private int xp;
	
	public PokeInfo(int PokeID, int PlayerID, String PokeName, String Nickname, Boolean Gender, PokeType type, int lvl, int xp){
		this.PokeID=PokeID;
		this.PlayerID=PlayerID;
		this.PokeName=PokeName;
		this.Nickname=Nickname;
		this.Gender=Gender;
		this.type=type;
		this.lvl=lvl;
		this.xp=xp;
	}

	public int getPokeID() {
		return PokeID;
	}

	public void setPokeID(int pokeID) {
		PokeID = pokeID;
	}

	public int getPlayerID() {
		return PlayerID;
	}

	public void setPlayerID(int playerID) {
		PlayerID = playerID;
	}

	public String getPokeName() {
		return PokeName;
	}

	public void setPokeName(String pokeName) {
		PokeName = pokeName;
	}

	public String getNickname() {
		return Nickname;
	}

	public void setNickname(String nickname) {
		Nickname = nickname;
	}

	public Boolean getGender() {
		return Gender;
	}

	public void setGender(Boolean gender) {
		Gender = gender;
	}

	public PokeType getType() {
		return type;
	}

	public void setType(PokeType type) {
		this.type = type;
	}

	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}
	

}
