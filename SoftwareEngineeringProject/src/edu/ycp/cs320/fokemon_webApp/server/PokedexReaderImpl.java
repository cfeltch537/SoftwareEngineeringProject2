/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package edu.ycp.cs320.fokemon_webApp.server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.fokemon_webApp.client.PokedexReaderService;
import edu.ycp.cs320.fokemon_webApp.shared.MoveClasses.MoveName;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeID;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokeType;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexEntry;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.PokedexReader;

public class PokedexReaderImpl extends RemoteServiceServlet implements
		PokedexReaderService {
	private static final long serialVersionUID = 1L;

	@Override
	public PokedexReader readCSV() {
		PokedexReader test = new PokedexReader();
		System.out.println("********************in CSV reader");

		TreeMap<PokeID, PokedexEntry> pokeMap = new TreeMap<PokeID, PokedexEntry>();
		ArrayList<String> storeValues = new ArrayList<String>();
		storeValues = loadIt();
		for (int i = 0; i < storeValues.size(); i += 50) {
			TreeMap<Integer, PokeID> evolution=new TreeMap<Integer,PokeID>();
			TreeMap<Integer, MoveName> moveList=new TreeMap<Integer,MoveName>();
			int[] baseStats = { Integer.parseInt(storeValues.get(i + 2)),
					Integer.parseInt(storeValues.get(i + 3)),
					Integer.parseInt(storeValues.get(i + 4)),
					Integer.parseInt(storeValues.get(i + 5)),
					Integer.parseInt(storeValues.get(i + 6)),
					Integer.parseInt(storeValues.get(i + 7)) };
			int[] EVyield = { Integer.parseInt(storeValues.get(i + 9)),
					Integer.parseInt(storeValues.get(i + 10)),
					Integer.parseInt(storeValues.get(i + 11)),
					Integer.parseInt(storeValues.get(i + 12)),
					Integer.parseInt(storeValues.get(i + 13)),
					Integer.parseInt(storeValues.get(i + 14)) };
			ArrayList<PokeType> type = new ArrayList<PokeType>();
			type.add(PokeType.valueOf(storeValues.get(i + 15)));
			if (storeValues.get(i + 16) != "NONE")type.add(PokeType.valueOf(storeValues.get(i + 15)));
			//18 is level of evolution 19 is evolved pokemon
			//if (storeValues.get(i + 19) != "Mew"){
			evolution.put(Integer.parseInt(storeValues.get(i + 18)), (PokeID.valueOf(storeValues.get(i + 19))));
			//else evolution.put(999, PokeID.Bulbasaur);
				
			for(int j=0;j<30;j=j+2){
				moveList.put(Integer.parseInt(storeValues.get(i+20+j)), MoveName.valueOf(storeValues.get(i+20+j+1)));
			}
			PokedexEntry entry = new PokedexEntry(PokeID.valueOf(storeValues
					.get(i + 1)), storeValues.get(i + 1), baseStats,
					Integer.parseInt(storeValues.get(i + 8)), EVyield, type,Integer.parseInt(storeValues.get(i + 17)), evolution,moveList);
			pokeMap.put(PokeID.valueOf(storeValues.get(i + 1)), entry);
		}

		return new PokedexReader(pokeMap);

	}

	// Does Nothing For Now

	private static ArrayList<String> loadIt() {
		ArrayList<String> storeValues = new ArrayList<String>();
		storeValues.clear();
		String strFile = "Pokedex.csv";
		// strFile="C://Users/user/My Documents/IGVC2013_SensorData/KalmanFilterData_03-13-2013_18.49.50.csv";
		String value;
		// create BufferedReader to read csv file
		// InputStream in =
		// PokedexReaderImpl.class.getClassLoader().getResourceAsStream("strFile");
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(strFile));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String strLine = "";
		StringTokenizer st = null;
		int lineNumber = 0, tokenNumber = 0;
		// InputStream in =
		// Server.class.getClassLoader().getResourceAsStream("edu/ycp/cs320/example/hello.txt");

		// read comma separated file line by line
		try {
			while ((strLine = br.readLine()) != null) {
				lineNumber++;

				// break comma separated line using ","
				st = new StringTokenizer(strLine, ",");

				while (st.hasMoreTokens()) {
					// display csv values
					tokenNumber++;
					value = st.nextToken();
					if (value.isEmpty())
						value = "0";
					storeValues.add(value);
					// System.out.println(value);
					/*
					 * if ((tokenNumber==6 || tokenNumber==7) && lineNumber>1){
					 * storeValues.add(st.nextToken()); }else{
					 * System.out.println("Line # " + lineNumber + ", Token # "
					 * + tokenNumber + ", Token : "+ st.nextToken()); }
					 */
				}

				// reset token number
				tokenNumber = 0;

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return storeValues;

		/*
		 * try { BufferedReader rdr = new BufferedReader(new
		 * InputStreamReader(in)); while (true) { String line = rdr.readLine();
		 * if (line == null) { break; } System.out.println(line); } } finally {
		 * in.close(); }
		 */
	}

}