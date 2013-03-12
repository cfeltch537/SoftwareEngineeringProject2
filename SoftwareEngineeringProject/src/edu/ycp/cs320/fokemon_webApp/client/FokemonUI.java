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

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


import edu.ycp.cs320.fokemon_webApp.shared.GUI.Area;
import edu.ycp.cs320.fokemon_webApp.shared.player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.player.Player;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FokemonUI implements EntryPoint {
	static final String holderId = "canvasholder";

	  static final String upgradeMessage = "Your browser does not support the HTML5 Canvas. Please upgrade your browser to view this demo.";

	  Canvas canvasTemp;
	  Canvas canvas;
	  Canvas backBufferTemp;
	  Canvas backBuffer;
	  LogoGroup logoGroup;
	  CanvasImage canvasImage;
	  public static Area[] areaList = new Area[2];

	  public static Player player = new Player(00004, "Cody", true, new Location(0, 10, 10)); // Player Cody
	  public static boolean allowMove = false;
	  public static Integer step_count = 0;
	  
	  // mouse positions relative to canvas
	  int mouseX, mouseY;

	  //timer refresh rate, in milliseconds
	  static final int refreshRate = 100;
	  
	  // canvas size, in px
	  static final int heightTemp = 400;
	  static final int widthTemp = 400;
	  static int height;
	  static int width;
	  
	  
	  final CssColor redrawColor = CssColor.make("rgba(255,255,255,0.6)");
	  Context2d context;
	  Context2d backBufferContext;
	  Context2d contextTemp;
	  Context2d backBufferContextTemp;
	  
	  public void onModuleLoad() {
		  
		areaList[0] = new Area();
		areaList[0].createTallGrassSquare(5, 5, 10, 4);
		areaList[0].createTallGrassSquare(5, 10, 10, 4);
		areaList[0].createTallGrassSquare(5, 15, 10, 4);
		//areaList[0].placeStructure(25, 10, InteractableObject.PokeCenter);
		areaList[1] = new Area();
		
		 height = 16*areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[0].length;
		 width = 16*areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length;
		
		canvas = Canvas.createIfSupported();
		backBuffer = Canvas.createIfSupported();
	    canvasTemp = Canvas.createIfSupported();
	    backBufferTemp = Canvas.createIfSupported();
	    if (canvasTemp == null) {
	      RootPanel.get(holderId).add(new Label(upgradeMessage));
	      return;
	    }
	    if (canvas == null) {
		      RootPanel.get(holderId).add(new Label(upgradeMessage));
		      return;
		}
	    // init the canvases
	    canvas.setWidth(width + "px");
	    canvas.setHeight(height + "px");
	    canvas.setCoordinateSpaceWidth(width);
	    canvas.setCoordinateSpaceHeight(height);
	    backBuffer.setCoordinateSpaceWidth(width);
	    backBuffer.setCoordinateSpaceHeight(height);
	    RootPanel.get(holderId).add(canvas);
	    context = canvas.getContext2d();
	    backBufferContext = backBuffer.getContext2d();
	    
	    canvasTemp.setWidth(widthTemp + "px");
	    canvasTemp.setHeight(heightTemp + "px");
	    canvasTemp.setCoordinateSpaceWidth(widthTemp);
	    canvasTemp.setCoordinateSpaceHeight(heightTemp);
	    backBufferTemp.setCoordinateSpaceWidth(widthTemp);
	    backBufferTemp.setCoordinateSpaceHeight(heightTemp);
	    RootPanel.get(holderId).add(canvasTemp);
	    contextTemp = canvasTemp.getContext2d();
	    backBufferContextTemp = backBufferTemp.getContext2d();
	    
	    // init the objects
	    logoGroup = new LogoGroup(widthTemp, heightTemp, 18, 165);
	    canvasImage = new CanvasImage();

	    // init handlers
	    initHandlers();
	    
	    // setup timer
	    final Timer timer = new Timer() {
	      @Override
	      public void run() {
	        doUpdate();
	      }
	    };
	    timer.scheduleRepeating(refreshRate);
	  }

	  void doUpdate() {
	    // update the back canvas
	    backBufferContextTemp.setFillStyle(redrawColor);
	    backBufferContextTemp.fillRect(0, 0, widthTemp, heightTemp);
	    logoGroup.update(mouseX, mouseY);
	    logoGroup.draw(backBufferContextTemp);
	    // update the front canvas
	    logoGroup.draw(backBufferContextTemp, contextTemp);
	    canvasImage.draw(backBufferContext, context);
	    
	  }
	  
	  void initHandlers() {
	    canvasTemp.addMouseMoveHandler(new MouseMoveHandler() {
	      public void onMouseMove(MouseMoveEvent event) {
	        mouseX = event.getRelativeX(canvasTemp.getElement());
	        mouseY = event.getRelativeY(canvasTemp.getElement());
	      }
	    });

	    canvasTemp.addMouseOutHandler(new MouseOutHandler() {
	      public void onMouseOut(MouseOutEvent event) {
	        mouseX = -200;
	        mouseY = -200;
	      }
	    });

	    canvasTemp.addTouchMoveHandler(new TouchMoveHandler() {
	      public void onTouchMove(TouchMoveEvent event) {
	        event.preventDefault();
	        if (event.getTouches().length() > 0) {
	          Touch touch = event.getTouches().get(0);
	          mouseX = touch.getRelativeX(canvasTemp.getElement());
	          mouseY = touch.getRelativeY(canvasTemp.getElement());
	        }
	        event.preventDefault();
	      }
	    });

	    canvasTemp.addTouchEndHandler(new TouchEndHandler() {
	      public void onTouchEnd(TouchEndEvent event) {
	        event.preventDefault();
	        mouseX = -200;
	        mouseY = -200;
	      }
	    });

	    canvasTemp.addGestureStartHandler(new GestureStartHandler() {
	      public void onGestureStart(GestureStartEvent event) {
	        event.preventDefault();
	      }
	    });
	  }
	}