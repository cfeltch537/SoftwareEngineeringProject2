package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.io.Serializable;
import java.util.ArrayList;

public class PokeInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PokeID ID;
	private int PlayerID;
	private int catchRate;
	private String PokeName;
	private String Nickname;
	private Boolean Gender;
	private Boolean UsedInBattle;
	private Boolean isWild;
	private ArrayList<PokeType> type;
	private int lvl;
	private int xp;

	public PokeInfo(PokeID ID, int PlayerID, String PokeName, String Nickname,
			Boolean Gender, ArrayList<PokeType> type, int lvl, int xp, int catchRate) {
		this.setID(ID);
		this.PlayerID = PlayerID;
		this.PokeName = PokeName;
		this.Nickname = Nickname;
		this.Gender = Gender;
		this.type = type;
		this.lvl = lvl;
		this.xp = xp;
		this.UsedInBattle = false;
		this.setIsWild(false);
		this.catchRate=catchRate;
	}
	
	public PokeInfo() {
		this.setID(null);
		this.PlayerID = 0;
		this.PokeName = null;
		this.Nickname = null;
		this.Gender = false;
		this.type = null;
		this.lvl = 0;
		this.xp = 0;
		this.UsedInBattle = false;
		this.setIsWild(false);
		this.catchRate=0;
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

	public ArrayList<PokeType> getType() {
		return type;
	}

	public void setType(ArrayList<PokeType> type) {
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

	public PokeID getID() {
		return ID;
	}

	public void setID(PokeID iD) {
		ID = iD;
	}

	public Boolean getUsedInBattle() {
		return UsedInBattle;
	}

	public void setUsedInBattle(Boolean usedInBattle) {
		UsedInBattle = usedInBattle;
	}

	public Boolean getIsWild() {
		return isWild;
	}

	public void setIsWild(Boolean isWild) {
		this.isWild = isWild;
	}

	public int getCatchRate() {
		return catchRate;
	}

	public void setCatchRate(int catchRate) {
		this.catchRate = catchRate;
	}

}
