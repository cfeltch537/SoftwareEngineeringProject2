package edu.ycp.cs320.fokemon;

import java.util.TreeMap;
import edu.ycp.cs320.fokemon.PokedexEntry;

public class Pokedex {

	public Pokedex() {
		PokedexEntry PokeEntry = new PokedexEntry(1,0,0,"Words","Name",1,10,10,10,10,10,10,1,2,3,4,5,6);
		TreeMap <Integer, PokedexEntry>pokeMap = new TreeMap<Integer,PokedexEntry>();
		pokeMap.put(1, PokeEntry);
	}
	
	public static void main(){
		PokedexEntry PokeEntry = new PokedexEntry(1,0,0,"Words","Name",1,10,10,10,10,10,10,1,2,3,4,5,6);
		TreeMap <Integer, PokedexEntry>pokeMap = new TreeMap<Integer,PokedexEntry>();
		pokeMap.put(1, PokeEntry);
	}
	
}
