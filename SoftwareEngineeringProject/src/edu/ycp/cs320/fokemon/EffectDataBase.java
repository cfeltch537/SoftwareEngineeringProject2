package edu.ycp.cs320.fokemon;

import java.util.Random;

public class EffectDataBase {
	private static Random rand=new Random();
	private static int randomNum=0;
	
	
	public static void moveEffect(Pokemon Attacker, Pokemon Defender, Effect EffectIndex, int EffectChance, int Magnitude){
		
		
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		randomNum = rand.nextInt(100);
		
		switch (EffectIndex) {
        case NONE: //no effect
                 break;
        case PARALYZE:  //Paralyzed
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.PRL);
                 break;
        case POISON:  //Poisoned
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.PSN);
                 break;
        case SLEEP:  //Sleep
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.SLP);
                 break;	
        case BURN:  //Burn
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.BRN);
                 break;
        case FREEZE:  //Freeze
        	if(EffectChance>=randomNum && Defender.getStats().getStatus()==Status.NRM)
	        Defender.getStats().setStatus(Status.FRZ);
                 break;
        case KO:  //Death
        	if(EffectChance>=randomNum)
	        Defender.getStats().setCurHp(0);
                 break;
        case RECOVER:  //Recover
        	if(EffectChance>=randomNum)
	        Defender.getStats().setCurHp(0);
                 break;
                 
                 

        default: //no effect
                 break;
    }
		
		
		
		

	
	}

}
