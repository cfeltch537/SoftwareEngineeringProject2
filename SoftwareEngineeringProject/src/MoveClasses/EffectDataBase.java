package MoveClasses;

import java.util.ArrayList;
import java.util.Random;

import edu.ycp.cs320.fokemon.Pokemon;
import edu.ycp.cs320.fokemon.Status;



public class EffectDataBase {
	private static Random rand=new Random();
	private static int randomNum=0;
	private static int i=0;
	
	
	public static void moveEffect(Pokemon Attacker, Pokemon Defender, ArrayList <Effect> effect){
		for (i=0; i<effect.size(); i++){
			randomNum = rand.nextInt(100);
			effect.get(i).setEffectText("");
			if(effect.get(i).getEffectChance()>=randomNum){
			
				switch (effect.get(i).getEffectIndex()) {
		        case NONE: //no effect
		                 break;
		        case PARALYZE:  //Paralyzed
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.PRL);
		        	effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Was Paralyzed./n");
		                 break;
		        case POISON:  //Poisoned
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.PSN);
		        	effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Was Poisoned./n");
		                 break;
		        case SLEEP:  //Sleep
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.SLP);
		        	effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Fell Asleep./n");
		                 break;	
		        case BURN:  //Burn
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.BRN);
		        	effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Was Burned./n");
		                 break;
		        case FREEZE:  //Freeze
		        	if(Defender.getStats().getStatus()==Status.NRM)
			        Defender.getStats().setStatus(Status.FRZ);
		        	effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Was Frozen Solid./n");
		                 break;
		        case KO:  //Death
			        Defender.getStats().setCurHp(0);
			        effect.get(i).setEffectText(Defender.getInfo().getNickname()+" Was One-Hit KOed./n");
		                 break;
		        case RECOVERCONST:  //RecoverConstant HP
			        Attacker.getStats().setCurHp(Attacker.getStats().getCurHp()+effect.get(i).getMagnitude());
			        effect.get(i).setEffectText(Attacker.getInfo().getNickname()+" Has Recovered HP./n");
		                 break;  
		        default: //no effect
		                 break;
				}
			
			}	
			
		}	

	}
	}


