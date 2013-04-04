package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.util.ArrayList;
import java.util.Random;

import edu.ycp.cs320.fokemon_webApp.client.FokemonUI;
import edu.ycp.cs320.fokemon_webApp.client.TempBattle;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.Move;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveDataBase;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;


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
	public Pokemon(PokeID nPokeNum, int lvl) {
		/*ArrayList <PokeType> type= new ArrayList<PokeType>();
		type.add(PokeType.NORMAL);
		stats=new BattleStats(lvl, lvl, lvl, lvl, lvl, lvl, lvl, Status.NRM, lvl, null, null);
		info=new PokeInfo(nPokeNum, 100, "<<Name>>", "<<Nickname>>", true, type, lvl, lvl);
		tempBattleStats= new TempBattleStats();
		moves= new ArrayList<Move>();*/
		GeneratePokemon(nPokeNum, lvl);

	}
	
	public static Pokemon GeneratePokemon(PokeID ID, int lvl){
		Random rand=new Random();
		
		//Pokemon poke= new Pokemon(ID, lvl);
		
		PokedexEntry entry=new PokedexEntry();
		entry=FokemonUI.getPokedex().getPokeMap().get(ID);
		boolean gender;
		if(rand.nextInt()%2==0)gender=false;
		else gender=true;
		PokeInfo info=new PokeInfo(entry.getPokeID(),TempBattle.getUser().getPlayerID(),entry.getPokeName(),entry.getPokeName(),gender,entry.getType(),lvl,0);
		
		Move move1=MoveDataBase.generateMove(MoveName.Tackle);
		ArrayList<Move>moves=new ArrayList<Move>();
		
		moves.add(move1);
		BattleStats battleStats=new BattleStats(0,0,0,0,0,0, 0, Status.NRM,entry.getBaseXP(),entry.getBaseStats(),entry.getEVyield());
		Pokemon pokemon=new Pokemon(info, battleStats, moves);
		
		pokemon.UpdateStats();
		
		
		return pokemon;
		
		

	}
	public void LevelUp(){
		CheckEvolve();
		CheckLearnMove();
		UpdateStats();
	}
	public void UpdateStats() {
		// TODO Auto-generated method stub
		UpdateHPStat();
		int stat;
		int IV=0; int EV=0; int Nature=1;
		
		stat=((IV+2*getStats().getBaseStats()[1]+EV/4)*getInfo().getLvl()/100+5)*Nature;
		getStats().setAtk(stat);
		
		stat=((IV+2*getStats().getBaseStats()[2]+EV/4)*getInfo().getLvl()/100+5)*Nature;
		getStats().setDef(stat);
		
		stat=((IV+2*getStats().getBaseStats()[3]+EV/4)*getInfo().getLvl()/100+5)*Nature;
		getStats().setSpAtk(stat);
		
		stat=((IV+2*getStats().getBaseStats()[4]+EV/4)*getInfo().getLvl()/100+5)*Nature;
		getStats().setSpDef(stat);
		
		stat=((IV+2*getStats().getBaseStats()[5]+EV/4)*getInfo().getLvl()/100+5)*Nature;
		getStats().setSpd(stat);
	}
	private void UpdateHPStat() {
		int HP;
		int IV=0; int EV=0;
		HP=(IV+2*getStats().getBaseStats()[0]+EV/4+100)*getInfo().getLvl()/100+10;
		getStats().setMaxHp(HP);
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
