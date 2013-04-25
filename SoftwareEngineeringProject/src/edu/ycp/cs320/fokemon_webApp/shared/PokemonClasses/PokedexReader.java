package edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses;

import java.io.Serializable;
import java.util.TreeMap;

public class PokedexReader implements Serializable {
	private static final long serialVersionUID = 4354973849580040989L;

	private TreeMap<PokeID, PokedexEntry> pokeMap;

	public PokedexReader(TreeMap<PokeID, PokedexEntry> map) {
		pokeMap = map;
		// pokeMap=new TreeMap<PokeID,PokedexEntry>();
	}

	public PokedexReader() {

		// pokeMap=new TreeMap<PokeID,PokedexEntry>();
	}

	public TreeMap<PokeID, PokedexEntry> getPokeMap() {
		return pokeMap;
	}

	public void setPokeMap(TreeMap<PokeID, PokedexEntry> pokeMap) {
		this.pokeMap = pokeMap;
	}
}

/*
 * String strFile = "Pokedex.csv";
 * 
 * public PokedexReader() throws IOException { ArrayList <String>storeValues =
 * new ArrayList<String>(); storeValues.clear(); try { //src/Pokedex.csv //csv
 * file containing data String strFile = "Pokedex.csv"; //strFile=
 * "C://Users/user/My Documents/IGVC2013_SensorData/KalmanFilterData_03-13-2013_18.49.50.csv"
 * ; String value; //create BufferedReader to read csv file BufferedReader br =
 * new BufferedReader( new FileReader(strFile)); String strLine = "";
 * StringTokenizer st = null; int lineNumber = 0, tokenNumber = 0;
 * 
 * //read comma separated file line by line while( (strLine = br.readLine()) !=
 * null) { lineNumber++;
 * 
 * //break comma separated line using "," st = new StringTokenizer(strLine,
 * ",");
 * 
 * while(st.hasMoreTokens()) { //display csv values tokenNumber++;
 * value=st.nextToken(); if(value.isEmpty())value="0"; storeValues.add(value);
 * System.out.println(value) ; /*if ((tokenNumber==6 || tokenNumber==7) &&
 * lineNumber>1){ storeValues.add(st.nextToken()); }else{
 * System.out.println("Line # " + lineNumber + ", Token # " + tokenNumber +
 * ", Token : "+ st.nextToken()); } }
 * 
 * //reset token number tokenNumber = 0;
 * 
 * } br.close();
 * 
 * } finally{ System.out.println("ERROR reading CSV file"); }
 * 
 * }
 */

