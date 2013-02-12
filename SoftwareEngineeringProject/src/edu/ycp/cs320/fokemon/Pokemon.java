package edu.ycp.cs320.fokemon;

public class Pokemon {
	//create parameters for each pokemon
	private int curHp;
	private int baseHp;
	private int curAtk;
	private int baseAtk;
	private int curDef;
	private int baseDef;
	private int curSpAtk;
	private int baseSpAtk;
	private int curSpDef;
	private int baseSpDef;
	private int curSpd;
	private int baseSpd;
	private int pokeNum;
	private int idNum;
	private String name;
	
	
	public Pokemon(int nCurHp, int nBaseHp, int nCurAtk, int nBaseAtk, int nCurDef, int nBaseDef, int nCurSpAtk, int nBaseSpAtk, int nCurSpDef, int nBaseSpDef, int nCurSpd, int nBaseSpd, int nPokeNum, int nIdNum, String nName) {
		setCurHp(nCurHp);
		setBaseHp(nBaseHp);
		setCurAtk(nCurAtk);
		setBaseAtk(nBaseAtk);
		setCurDef(nCurDef);
		setBaseDef(nBaseDef);
		setCurSpAtk(nCurSpAtk);
		setBaseSpAtk(nBaseSpAtk);
		setCurSpDef(nCurSpDef);
		setBaseSpDef(nBaseSpDef);
		setCurSpd(nCurSpd);
		setBaseSpd(nBaseSpd);
		setPokeNum(nPokeNum);
		setIdNum(nIdNum);
		setName(nName);
	}
	//getter for curHp
	public int getCurHp() {
		return curHp;
	}
	//setter for curHp
	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}
	//getter for baseHp
	public int getBaseHp() {
		return baseHp;
	}
	//setter for baseHp
	public void setBaseHp(int baseHp) {
		this.baseHp = baseHp;
	}
	//getter for curAtk
	public int getCurAtk() {
		return curAtk;
	}
	//setter for curAtk
	public void setCurAtk(int curAtk) {
		this.curAtk = curAtk;
	}
	//getter for baseAtk
	public int getBaseAtk() {
		return baseAtk;
	}
	//setter for baseAtk
	public void setBaseAtk(int baseAtk) {
		this.baseAtk = baseAtk;
	}
	//getter for curDef
	public int getCurDef() {
		return curDef;
	}
	//setter for curDef
	public void setCurDef(int curDef) {
		this.curDef = curDef;
	}
	//getter for baseDef
	public int getBaseDef() {
		return baseDef;
	}
	//setter for baseDef
	public void setBaseDef(int baseDef) {
		this.baseDef = baseDef;
	}
	//getter for curSpAtk
	public int getCurSpAtk() {
		return curSpAtk;
	}
	//setter for curSpAtk
	public void setCurSpAtk(int curSpAtk) {
		this.curSpAtk = curSpAtk;
	}
	//getter for baseSpAtk
	public int getBaseSpAtk() {
		return baseSpAtk;
	}
	//setter for baseSpAtk
	public void setBaseSpAtk(int baseSpAtk) {
		this.baseSpAtk = baseSpAtk;
	}
	//getter for curSpDef
	public int getCurSpDef() {
		return curSpDef;
	}
	//setter for curSpDef
	public void setCurSpDef(int curSpDef) {
		this.curSpDef = curSpDef;
	}
	//getter for baseSpDef
	public int getBaseSpDef() {
		return baseSpDef;
	}
	//setter for curSpDef
	public void setBaseSpDef(int baseSpDef) {
		this.baseSpDef = baseSpDef;
	}
	//getter for curSpd
	public int getCurSpd() {
		return curSpd;
	}
	//setter for curSpd
	public void setCurSpd(int curSpd) {
		this.curSpd = curSpd;
	}
	//getter for baseSpd
	public int getBaseSpd() {
		return baseSpd;
	}
	//setter for baseSpd
	public void setBaseSpd(int baseSpd) {
		this.baseSpd = baseSpd;
	}
	//getter for pokeNum
	public int getPokeNum() {
		return pokeNum;
	}
	//setter for PokeNum
	public void setPokeNum(int pokeNum) {
		this.pokeNum = pokeNum;
	}
	//getter for idNum
	public int getIdNum() {
		return idNum;
	}
	//setter for idNum
	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}
	//getter for name
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
}
