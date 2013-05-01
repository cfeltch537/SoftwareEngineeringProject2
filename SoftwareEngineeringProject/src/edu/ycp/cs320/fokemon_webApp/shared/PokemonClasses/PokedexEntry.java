package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;

public class PokedexEntry implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7929743202600974187L;
	private int[] baseStats = new int[6];
	private PokeID ID;
	private String PokeName;
	private ArrayList<PokeType> type;
	private TreeMap<Integer,PokeID> evolution;
	private TreeMap<Integer,MoveName> moveList;
	private int baseXP;
	private int[] EVyield = new int[6];
	private int catchRate;

	public PokedexEntry() {
		
	}

	public PokedexEntry(PokeID ID, String PokeName, int[] baseStats,
			int baseXP, int[] EVyield, ArrayList<PokeType> type,int catchRate,TreeMap<Integer,PokeID> evolution,TreeMap<Integer,MoveName> moveList) {
		this.ID = ID;
		this.PokeName = PokeName;
		this.baseStats = baseStats;
		this.baseXP = baseXP;
		this.EVyield = EVyield;
		this.type = type;
		this.catchRate=catchRate;
		this.evolution=evolution;
		this.moveList=moveList;
	}

	public int[] getBaseStats() {
		return baseStats;
	}

	public void setBaseStats(int[] baseStats) {
		this.baseStats = baseStats;
	}

	public PokeID getPokeID() {
		return ID;
	}

	public void setPokeID(PokeID pokeID) {
		ID = pokeID;
	}

	public String getPokeName() {
		return PokeName;
	}

	public void setPokeName(String pokeName) {
		PokeName = pokeName;
	}

	public ArrayList<PokeType> getType() {
		return type;
	}

	public void setType(ArrayList<PokeType> type) {
		this.type = type;
	}

	public int getBaseXP() {
		return baseXP;
	}

	public void setBaseXP(int baseXP) {
		this.baseXP = baseXP;
	}

	public int[] getEVyield() {
		return EVyield;
	}

	public void setEVyield(int[] eVyield) {
		EVyield = eVyield;
	}

	public int getCatchRate() {
		return catchRate;
	}

	public void setCatchRate(int catchRate) {
		this.catchRate = catchRate;
	}

	public TreeMap<Integer,PokeID> getEvolution() {
		return evolution;
	}

	public void setEvolution(TreeMap<Integer,PokeID> evolution) {
		this.evolution = evolution;
	}

	public TreeMap<Integer,MoveName> getMoveList() {
		return moveList;
	}

	public void setMoveList(TreeMap<Integer,MoveName> moveList) {
		this.moveList = moveList;
	}

	/*
	 * public PokedexEntry(int _id, Image _spriteFront, Image _spriteBack,
	 * String _name, String _details, int _type, int _baseHP, int _baseAtk, int
	 * _baseDef, int _baseSpAtk, int _baseSpDef, int _baseSpd, int _incHP, int
	 * _incAtk, int _incDef, int _incSpAtk, int _incSpDef, int _incSpd) {
	 * this.id=_id; this.spriteFront = _spriteBack; this.spriteBack =
	 * _spriteBack; this.name = _name; this.details = _details; this.type =
	 * _type; this.baseHP = _baseHP; this.baseAtk = _baseAtk; this.baseDef =
	 * _baseDef; this.baseSpAtk = _baseSpAtk; this.baseSpDef = _baseSpDef;
	 * this.baseSpd = _baseSpd; this.incHP = _incHP; this.incAtk = _incAtk;
	 * this.incDef = _incDef; this.incSpAtk = _incSpAtk; this.incSpDef =
	 * _incSpDef; this.incSpd = _incSpd;
	 * 
	 * }
	 * 
	 * public void printEntry() { System.out.printf("\nID = %d",this.id);
	 * //System.out.printf("\nSprite Front =  ",this.spriteFront);
	 * //System.out.printf(" ",this.spriteBack); System.out.printf("\nName = "+
	 * this.name); System.out.printf("\nDetails = "+ this.details);
	 * System.out.printf("\nType = %d ", this.type);
	 * System.out.printf("\nHP base = %d ", this.baseHP);
	 * System.out.printf("\nAtk base =  %d ", this.baseAtk);
	 * System.out.printf("\nDef base = %d ", this.baseDef);
	 * System.out.printf("\nSpAtk base = %d ", this.baseSpAtk);
	 * System.out.printf("\nSpDef base = %d", this.baseSpDef);
	 * System.out.printf("\nSpeed base = %d", this.baseSpd);
	 * System.out.printf("\nHP inc = %d ", this.incHP);
	 * System.out.printf("\nAtk inc = %d ",this.incAtk);
	 * System.out.printf("\nDef inc = %d ", this.incDef);
	 * System.out.printf("\nSpAtk inc = %d ", this.incSpAtk);
	 * System.out.printf("\nSpDef inc = %d", this.incSpDef);
	 * System.out.printf("\nSpeed inc = %d ", this.incSpd);
	 * 
	 * }
	 * 
	 * 
	 * public int getId() { return id; }
	 * 
	 * public void setId(int id) { this.id = id; }
	 * 
	 * public Image getSpriteBack() { return spriteBack; }
	 * 
	 * public void setSpriteBack(Image spriteBack) { this.spriteBack =
	 * spriteBack; }
	 * 
	 * public Image getSpriteFront() { return spriteFront; }
	 * 
	 * public void setSpriteFront(Image spriteFront) { this.spriteFront =
	 * spriteFront; }
	 * 
	 * public String getDetails() { return details; }
	 * 
	 * public void setDetails(String details) { this.details = details; }
	 * 
	 * public String getName() { return name; }
	 * 
	 * public void setName(String name) { this.name = name; }
	 * 
	 * public int getType() { return type; }
	 * 
	 * public void setType(int type) { this.type = type; }
	 * 
	 * public int getBaseHP() { return baseHP; }
	 * 
	 * public void setBaseHP(int baseHP) { this.baseHP = baseHP; }
	 * 
	 * public int getBaseAtk() { return baseAtk; }
	 * 
	 * public void setBaseAtk(int baseAtk) { this.baseAtk = baseAtk; }
	 * 
	 * public int getBaseDef() { return baseDef; }
	 * 
	 * public void setBaseDef(int baseDef) { this.baseDef = baseDef; }
	 * 
	 * public int getBaseSpAtk() { return baseSpAtk; }
	 * 
	 * public void setBaseSpAtk(int baseSpAtk) { this.baseSpAtk = baseSpAtk; }
	 * 
	 * public int getBaseSpDef() { return baseSpDef; }
	 * 
	 * public void setBaseSpDef(int baseSpDef) { this.baseSpDef = baseSpDef; }
	 * 
	 * public int getBaseSpd() { return baseSpd; }
	 * 
	 * public void setBaseSpd(int baseSpd) { this.baseSpd = baseSpd; }
	 * 
	 * public int getIncHP() { return incHP; }
	 * 
	 * public void setIncHP(int incHP) { this.incHP = incHP; }
	 * 
	 * public int getIncAtk() { return incAtk; }
	 * 
	 * public void setIncAtk(int incAtk) { this.incAtk = incAtk; }
	 * 
	 * public int getIncDef() { return incDef; }
	 * 
	 * public void setIncDef(int incDef) { this.incDef = incDef; }
	 * 
	 * public int getIncSpAtk() { return incSpAtk; }
	 * 
	 * public void setIncSpAtk(int incSpAtk) { this.incSpAtk = incSpAtk; }
	 * 
	 * public int getIncSpDef() { return incSpDef; }
	 * 
	 * public void setIncSpDef(int incSpDef) { this.incSpDef = incSpDef; }
	 * 
	 * public int getIncSpd() { return incSpd; }
	 * 
	 * public void setIncSpd(int incSpd) { this.incSpd = incSpd; }
	 */
}
