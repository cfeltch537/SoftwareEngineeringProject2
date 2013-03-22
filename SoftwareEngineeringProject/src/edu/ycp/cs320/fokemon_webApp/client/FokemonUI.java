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
package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FokemonUI implements EntryPoint {
	static final String holderId = "canvasholder";

	  static final String upgradeMessage = "Your browser does not support the HTML5 Canvas. Please upgrade your browser to view this demo.";

	  static CirculatingImagesView tempView;
	  static MapView map;
	  static AbsolutePanel panel;
	  static BattleView battle;
	  static final int refreshRate = 25;
	  
	  public void onModuleLoad() {
		  
		  panel = new AbsolutePanel();
		  map = new MapView();
		  tempView = new CirculatingImagesView();
		  battle = new BattleView();
		  panel.getElement().getStyle().setPosition(Position.RELATIVE);
		  
		  final Timer timer = new Timer() {
		      @Override
		      public void run() {
		        doUpdate();
		      }
		};
		timer.scheduleRepeating(refreshRate);
	  }
	  static void doUpdate() {
		  // update the back canvas, set to front canvas
		  
		  map.doUpdate(); 
		  //tempView.doUpdate();
		  battle.doUpdate();
		  }
	}