package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.util.ArrayList;

import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;


public class Pokemon {
	//create parameters for each pokemon
	private BattleStats stats;
	private PokeInfo info;
	private TempBattleStats tempBattleStats;
	private ArrayList <Move> moves;
	
	public Pokemon(PokeInfo info, BattleStats stats, ArrayList <Move> moves){
		this.info=info;
		this.stats=stats;
		this.moves=moves;
	}
	public Pokemon(int nPokeNum, int lvl) {
		ArrayList <PokeType> type= new ArrayList<PokeType>();
		type.add(PokeType.NORMAL);
		stats=new BattleStats(lvl, lvl, lvl, lvl, lvl, lvl, lvl, Status.NRM);
		info=new PokeInfo(nPokeNum, nPokeNum, "<<Name>>", "<<Nickname>>", true, type, lvl, lvl);
		tempBattleStats= new TempBattleStats();
		moves= new ArrayList<Move>();

	}
	
	public static Pokemon GeneratePokemon(int ID, int lvl){
		Pokemon poke= new Pokemon(ID, lvl);
		
		switch (ID) {
        case 1: 
        	
                 break;
        case 2:  
                 break;

        default: ;
                 break;
    }
		
		return null;
		
		

	}
	public void LevelUp(){
		CheckEvolve();
		CheckLearnMove();
		UpdateStats();
	}
	private void UpdateStats() {
		// TODO Auto-generated method stub
		
	}
	private void CheckLearnMove() {
		// TODO Auto-generated method stub
		
	}
	private void CheckEvolve() {
		// TODO Auto-generated method stub
		
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
	public TempBattleStats getTempBattleStats() {
		return tempBattleStats;
	}
	public void setTempBattleStats(TempBattleStats tempBattleStats) {
		this.tempBattleStats = tempBattleStats;
	}
	public ArrayList <Move> getMoves() {
		return moves;
	}
	public void setMoves(ArrayList <Move> moves) {
		this.moves = moves;
	}
	public Move getMove(int index){
		return moves.get(index);
	}
}
