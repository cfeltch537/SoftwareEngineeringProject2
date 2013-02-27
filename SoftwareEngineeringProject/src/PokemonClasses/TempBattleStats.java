package PokemonClasses;

public class TempBattleStats {
	
	private int ATKBoost;
	private int DEFBoost;
	private int SPATKBoost;
	private int SPDEFBoost;
	private int SPDBoost;
	private boolean confused;
	private boolean skipTurn;
	private boolean skipNextTurn;
	private boolean seeded;
	private boolean attracted;
	
	public TempBattleStats(){
		ATKBoost=0;
		DEFBoost=0;
		SPATKBoost=0;
		SPDEFBoost=0;
		SPDBoost=0;
		setConfused(false);
		setSkipTurn(false);
		setSkipNextTurn(false);
		setSeeded(false);
		setAttracted(false);
		
	}


	public boolean isConfused() {
		return confused;
	}

	public void setConfused(boolean confused) {
		this.confused = confused;
	}

	public boolean isSkipTurn() {
		return skipTurn;
	}

	public void setSkipTurn(boolean skipTurn) {
		this.skipTurn = skipTurn;
	}

	public boolean isSkipNextTurn() {
		return skipNextTurn;
	}

	public void setSkipNextTurn(boolean skipNextTurn) {
		this.skipNextTurn = skipNextTurn;
	}

	public boolean isSeeded() {
		return seeded;
	}

	public void setSeeded(boolean seeded) {
		this.seeded = seeded;
	}

	public boolean isAttracted() {
		return attracted;
	}

	public void setAttracted(boolean attracted) {
		this.attracted = attracted;
	}


	public int getATKBoost() {
		return ATKBoost;
	}


	public void setATKBoost(int aTKBoost) {
		ATKBoost = aTKBoost;
	}


	public int getDEFBoost() {
		return DEFBoost;
	}


	public void setDEFBoost(int dEFBoost) {
		DEFBoost = dEFBoost;
	}


	public int getSPATKBoost() {
		return SPATKBoost;
	}


	public void setSPATKBoost(int sPATKBoost) {
		SPATKBoost = sPATKBoost;
	}


	public int getSPDEFBoost() {
		return SPDEFBoost;
	}


	public void setSPDEFBoost(int sPDEFBoost) {
		SPDEFBoost = sPDEFBoost;
	}


	public int getSPDBoost() {
		return SPDBoost;
	}


	public void setSPDBoost(int sPDBoost) {
		SPDBoost = sPDBoost;
	}
	
	

}
