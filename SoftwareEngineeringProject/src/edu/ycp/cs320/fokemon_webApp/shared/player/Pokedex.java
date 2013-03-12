package edu.ycp.cs320.fokemon_webApp.shared.player;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.swing.ImageIcon;

import edu.ycp.cs320.fokemon_webApp.shared.player.PokedexEntry;


public class Pokedex {

	TreeMap <Integer, PokedexEntry>pokeMap = new TreeMap<Integer,PokedexEntry>();
	
	public Pokedex() {
		PokedexEntry temp;
		try
	    {
	      FileReader fr = new FileReader(".\\src\\PokedexTest'.csv");
	      BufferedReader br = new BufferedReader(fr);
	      String stringRead = br.readLine();

	      while( stringRead != null )
	      {
	        StringTokenizer st = new StringTokenizer(stringRead, ",");
	        int id = Integer.parseInt(st.nextToken());
	        Image spriteFront = new ImageIcon(".\\src\\Battle_Sprites/" + st.nextToken() + ".png").getImage();
	        Image spriteBack = new ImageIcon(".\\src\\Battle_Sprites/" + st.nextToken() + ".png").getImage();
	        String name = st.nextToken();
	        String details = st.nextToken();
	        int type = Integer.parseInt(st.nextToken());
	        int baseHP = Integer.parseInt(st.nextToken());
	        int baseAtk = Integer.parseInt(st.nextToken());
	        int baseDef = Integer.parseInt(st.nextToken());
	        int baseSpAtk = Integer.parseInt(st.nextToken());
	        int baseSpDef = Integer.parseInt(st.nextToken());
	        int baseSpd = Integer.parseInt(st.nextToken());
	        int incHP = Integer.parseInt(st.nextToken());
	        int incAtk = Integer.parseInt(st.nextToken());
	        int incDef = Integer.parseInt(st.nextToken());
	        int incSpAtk = Integer.parseInt(st.nextToken());
	        int incSpDef = Integer.parseInt(st.nextToken());
	        int incSpd = Integer.parseInt(st.nextToken());

	        temp = new PokedexEntry(id,spriteFront,spriteBack,name,details,type,baseHP,baseAtk,baseDef,baseSpAtk,baseSpDef,baseSpd,incHP,incAtk,incDef,incSpAtk,incSpDef,incSpd);	      
	        pokeMap.put(temp.getId(), temp);
	        // read the next line
	        stringRead = br.readLine();
	      }
	      br.close( );
	    }
	    catch(IOException ioe){
	    	
	    }
		
	}
	
}
