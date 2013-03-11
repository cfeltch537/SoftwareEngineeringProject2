package edu.ycp.cs320.fokemon;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class BattleStats {
	private int curHp;
	private int maxHp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spd;
	private Status status;
	
	public BattleStats(int curHp, int maxHp, int atk, int def, int spAtk, int spDef, int spd, Status status) {
		this.setCurHp(curHp);
		this.setMaxHp(maxHp);
		this.setAtk(atk);
		this.setDef(def);
		this.setSpAtk(spAtk);
		this.setSpDef(spDef);
		this.setSpd(spd);
		this.setStatus(status);
	}

	public int getCurHp() {
		return curHp;
	}

	public void setCurHp(int curHp) {
		this.curHp = curHp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpAtk() {
		return spAtk;
	}

	public void setSpAtk(int spAtk) {
		this.spAtk = spAtk;
	}

	public int getSpDef() {
		return spDef;
	}

	public void setSpDef(int spDef) {
		this.spDef = spDef;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void fullHeal() {
		curHp = maxHp;
		status = Status.NRM;
	}
	
	public void partialHeal(int x) {
		curHp += x;
	}
	
	public void changeStatus(Status x) {
		status = x;
	}
}
