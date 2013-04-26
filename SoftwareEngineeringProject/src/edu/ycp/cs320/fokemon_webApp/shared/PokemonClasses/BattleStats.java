package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.io.Serializable;

import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class BattleStats implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int curHp;
	private int maxHp;
	private int atk;
	private int def;
	private int spAtk;
	private int spDef;
	private int spd;
	private int SLPCount;
	private int baseXP;
	private int[] baseStats;
	private int[] EVyield;
	private Status status;

	public BattleStats(int curHp, int maxHp, int atk, int def, int spAtk,
			int spDef, int spd, Status status, int baseXP, int[] baseStats,
			int[] EVyield) {
		this.setCurHp(curHp);
		this.setMaxHp(maxHp);
		this.setAtk(atk);
		this.setDef(def);
		this.setSpAtk(spAtk);
		this.setSpDef(spDef);
		this.setSpd(spd);
		this.setStatus(status);
		this.setBaseXP(baseXP);
		this.setBaseStats(baseStats);
		this.setEVyield(EVyield);
		SLPCount = 0;
	}
	
	public BattleStats() {
		this.setCurHp(0);
		this.setMaxHp(0);
		this.setAtk(0);
		this.setDef(0);
		this.setSpAtk(0);
		this.setSpDef(0);
		this.setSpd(0);
		this.setStatus(null);
		this.setBaseXP(0);
		this.setBaseStats(new int[1]);
		this.setEVyield(new int[1]);
		SLPCount = 0;
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
		SLPCount = 0;
	}

	public void partialHeal(int x) {
		curHp += x;
	}

	public void changeStatus(Status x) {
		status = x;
	}

	public int getSLPCount() {
		return SLPCount;
	}

	public void setSLPCount(int sLPCount) {
		SLPCount = sLPCount;
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

	public int[] getBaseStats() {
		return baseStats;
	}

	public void setBaseStats(int[] baseStats) {
		this.baseStats = baseStats;
	}
}
