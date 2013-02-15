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
	private int curAcc; //TMP: Pokemon's current accuracy modifier, integer from 0 to 1 to affect chance to hit
	private int statusHard; //TMP: Pokemon's status: SLP, PSN, PRZ, FRZ, BRN
	private int statusSoft; //TMP: Pokemon's status: Confusion, Bind, etc.
	private BattleStats stats;
	private PokeInfo info;
	private int lvl;
	private static String name;
	
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
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}
	public static Pokemon GeneratePokemon(int ID, int lvl){
		Pokemon poke= new Pokemon(ID, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, lvl, name);
		
		switch (ID) {
        case 1: 
        	poke.setName("Test1");
        	poke.setBaseHp(10+poke.getLvl()*10);
        	poke.setBaseAtk(10+poke.getLvl()*10);
        	poke.setBaseDef(10+poke.getLvl()*10);
        	poke.setBaseSpAtk(10+poke.getLvl()*10);
        	poke.setBaseSpDef(10+poke.getLvl()*10);
        	
                 break;
        case 2:  
	        poke.setName("Test2");
	    	poke.setBaseHp(10+poke.getLvl()*20);
	    	poke.setBaseAtk(10+poke.getLvl()*20);
	    	poke.setBaseDef(10+poke.getLvl()*20);
	    	poke.setBaseSpAtk(10+poke.getLvl()*20);
	    	poke.setBaseSpDef(10+poke.getLvl()*20);
                 break;

        default: poke.setName("Error");
                 break;
    }
		
		return null;
		
		

	}
	public BattleStats getStats() {
		return stats;
	}
	public void setStats(BattleStats stats) {
		this.stats = stats;
	}
	public PokeInfo getInfo() {
		return info;
	}
	public void setInfo(PokeInfo info) {
		this.info = info;
	}
	
	
	
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
	//TMP: Enter battle - sets the current battle stats to the base battle stats pre-battle
	public void enterBattle() {
		this.setCurAtk(this.getBaseAtk());
		this.setCurDef(this.getBaseDef());
		this.setCurSpAtk(this.getBaseSpAtk());
		this.setCurSpDef(this.getBaseSpDef());
		this.setCurSpd(this.getBaseSpd());
		this.setCurAcc(1);
	}
	//TMP: Exit Battle - sets the current battle stats to the base battle stats post-battle
	public void exitBattle() {
		this.setCurAtk(this.getBaseAtk());
		this.setCurDef(this.getBaseDef());
		this.setCurSpAtk(this.getBaseSpAtk());
		this.setCurSpDef(this.getBaseSpDef());
		this.setCurSpd(this.getBaseSpd());
		this.setCurAcc(1);
	}
	
	
	//getter for accuracy
	public int getCurAcc() {
		return curAcc;
	}
	
	//setter for accuracy
	public void setCurAcc(int _curAcc) {
		this.curAcc = _curAcc;
	}
	
	//getter for Hard Status
	public int getStatusHard() {
		return statusHard;
	}
	
	//setter for Hard Status
	public void setStatusHard(int _statusHard) {
		this.statusHard = _statusHard;
	}
	
	//getter for Soft Status
	public int getStatusSoft() {
		return statusSoft;
	}
	
	//setter for Soft Status
	public void setStatusSoft(int _statusSoft) {
		this.statusSoft = _statusSoft;
	}	

}
