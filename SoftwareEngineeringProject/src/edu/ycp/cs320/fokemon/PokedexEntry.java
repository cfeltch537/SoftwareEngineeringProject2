package edu.ycp.cs320.fokemon;

public class PokedexEntry {
	private int id;
	private int spriteFront;
	private int spriteBack;
	private String details;
	private String name;
	private int type;
	private int baseHP;
	private int baseAtk;
	private int baseDef;
	private int baseSpAtk;
	private int baseSpDef;
	private int baseSpd;
	private int incHP;
	private int incAtk;
	private int incDef;
	private int incSpAtk;
	private int incSpDef;
	private int incSpd;
	
	public PokedexEntry(int _id, int _spriteFront, int _spriteBack, String _details, String _name, int _type, int _baseHP, int _baseAtk, int _baseDef, 
			int _baseSpAtk, int _baseSpDef, int _baseSpd,  int _incHP, int _incAtk, int _incDef, int _incSpAtk, int _incSpDef, int _incSpd) {
		this.id=_id;
		this.spriteFront = _spriteBack;
		this.spriteBack = _spriteBack;
		this.details = _details;
		this.name = _name;
		this.type = _type;
		this.baseHP = _baseHP;
		this.baseAtk = _baseAtk;
		this.baseDef = _baseDef;
		this.baseSpAtk = _baseSpAtk;
		this.baseSpDef = _baseSpDef;
		this.baseSpd = _baseSpd;
		this.incHP = _incHP;
		this.incAtk = _incAtk;
		this.incDef = _incDef;
		this.incSpAtk = _incSpAtk;
		this.incSpDef = _incSpDef;
		this.incSpd = _incSpd;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpriteBack() {
		return spriteBack;
	}

	public void setSpriteBack(int spriteBack) {
		this.spriteBack = spriteBack;
	}

	public int getSpriteFront() {
		return spriteFront;
	}

	public void setSpriteFront(int spriteFront) {
		this.spriteFront = spriteFront;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getBaseHP() {
		return baseHP;
	}

	public void setBaseHP(int baseHP) {
		this.baseHP = baseHP;
	}

	public int getBaseAtk() {
		return baseAtk;
	}

	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}

	public int getBaseDef() {
		return baseDef;
	}

	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}

	public int getBaseSpAtk() {
		return baseSpAtk;
	}

	public void setBaseSpAtk(int baseSpAtk) {
		this.baseSpAtk = baseSpAtk;
	}

	public int getBaseSpDef() {
		return baseSpDef;
	}

	public void setBaseSpDef(int baseSpDef) {
		this.baseSpDef = baseSpDef;
	}

	public int getBaseSpd() {
		return baseSpd;
	}

	public void setBaseSpd(int baseSpd) {
		this.baseSpd = baseSpd;
	}

	public int getIncHP() {
		return incHP;
	}

	public void setIncHP(int incHP) {
		this.incHP = incHP;
	}

	public int getIncAtk() {
		return incAtk;
	}

	public void setIncAtk(int incAtk) {
		this.incAtk = incAtk;
	}

	public int getIncDef() {
		return incDef;
	}

	public void setIncDef(int incDef) {
		this.incDef = incDef;
	}

	public int getIncSpAtk() {
		return incSpAtk;
	}

	public void setIncSpAtk(int incSpAtk) {
		this.incSpAtk = incSpAtk;
	}

	public int getIncSpDef() {
		return incSpDef;
	}

	public void setIncSpDef(int incSpDef) {
		this.incSpDef = incSpDef;
	}

	public int getIncSpd() {
		return incSpd;
	}

	public void setIncSpd(int incSpd) {
		this.incSpd = incSpd;
	}
}
