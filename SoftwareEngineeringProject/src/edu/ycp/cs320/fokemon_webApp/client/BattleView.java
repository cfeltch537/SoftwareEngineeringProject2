
package edu.ycp.cs320.fokemon_webApp.client;

import org.apache.tools.ant.taskdefs.condition.Equals;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.canvas.dom.client.FillStrokeStyle;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class BattleView extends Composite{
	static final String holderId = "canvasholder";
	Canvas battleCanvasBackBuffer;
	Canvas battleCanvas;
	Context2d battleContext;
	Context2d battleBackBufferContext;
	static int height;
	static int width;
	static final int refreshRate = 50;
	ListBox commandOptions;
	TextBox battleAnnouncementBox;
	int key;
	int commandOptionsIndex = 0;
	int index;
	Image img;
	
	public BattleView(){
		
		battleCanvas = Canvas.createIfSupported();
		battleCanvasBackBuffer = Canvas.createIfSupported();
		height = MapView.height;
		width = MapView.width;
	    // init the canvases
	    battleCanvas.setWidth(width + "px");
	    battleCanvas.setHeight(height + "px");
	    battleCanvas.setCoordinateSpaceWidth(width);
	    battleCanvas.setCoordinateSpaceHeight(height); 
	    battleCanvasBackBuffer.setCoordinateSpaceWidth(width);
	    battleCanvasBackBuffer.setCoordinateSpaceHeight(height);
	    battleCanvasBackBuffer.setCoordinateSpaceWidth(width);
	    battleCanvasBackBuffer.setCoordinateSpaceHeight(height);
	    battleContext = battleCanvas.getContext2d();
	    battleBackBufferContext = battleCanvasBackBuffer.getContext2d();
	    
	    FokemonUI.panel.setWidth(width + "px");
	    FokemonUI.panel.setHeight(height + "px");
	    RootPanel.get(holderId).add(FokemonUI.panel);
	    FokemonUI.panel.add(battleCanvas,0,0);
	    
	    commandOptions = new ListBox();
	    commandOptions.setVisibleItemCount(4);
	    commandOptions.setWidth("150px");
	    commandOptions.setHeight("80px");
	    setBattleOptions();
	    FokemonUI.panel.clear();
	    FokemonUI.panel.add(battleCanvas);
	    FokemonUI.panel.add(commandOptions, width-150, height-80);

	    battleAnnouncementBox = new TextBox();
	    battleAnnouncementBox.setWidth(width-150-20 + "px");
	    battleAnnouncementBox.setHeight("40px");
	    battleAnnouncementBox.setText("Look at my horse. My horse is amazing!!!");
	    FokemonUI.panel.add(battleAnnouncementBox, 10, height-50);
		
	    initHandlers();	
	}
	
	void doUpdate() {
			// update the back canvas, set to fron canvas
			battleBackBufferContext.setFillStyle(CssColor.make("rgba(0,255,0,0.6)"));
			draw(battleBackBufferContext, battleContext);  
		  }
	
	public void draw(Context2d context, Context2d front) {
		
		context.save();
		img = new Image("PokemonSprites/Arena.png");
    	context.drawImage((ImageElement) img.getElement().cast(), width/2 - img.getWidth()/2, height/2-img.getHeight()/2);
    	
    	img = new Image("PokemonSprites/Charizard.png");
    	context.drawImage((ImageElement) img.getElement().cast(), width/2 - img.getWidth()/2 - 120, height/2 - img.getHeight() - 10);
    	
    	img = new Image("PokemonSprites/Pikachu.png");
    	context.drawImage((ImageElement) img.getElement().cast(), width/2 - img.getWidth()/2 + 120, height/2 - img.getHeight() - 10);
		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}
	
	  void initHandlers() {
		KeyPressHandler wasdHandler = new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				key = event.getUnicodeCharCode();
				index = commandOptions.getSelectedIndex();
				switch(key){
				case 32: //Space; Select
					System.out.println(commandOptions.getSelectedIndex());
					handleOptionSelect(index);
					break;
				case 53: //2; DOWN in list
					incrementSelectedCommandOption();
					break;
				case 115: //S; DOWN in list
					incrementSelectedCommandOption();
					break;
				case 55: //7; BACK to setBattleOptions()
					setBattleOptions();
					break;
				case 113: //Q; BACK to setBattleOptions()
					setBattleOptions();
					break;
				case 56: //8; UP in list
					decrementSelectedCommandOption();
					break;
				case 119: //W; UP in list
					decrementSelectedCommandOption();
					break;
				case 57: //9; Select
					System.out.println(commandOptions.getSelectedIndex());
					handleOptionSelect(index);
					break;
				case 101: //E; Select
					System.out.println(commandOptions.getSelectedIndex());
					handleOptionSelect(index);
					break;
				}
				System.out.println(key); //For Debug
			}
		};
		commandOptions.addDomHandler(wasdHandler, KeyPressEvent.getType());
		commandOptions.setFocus(true);
	}
	void setBattleOptions(){
		commandOptions.clear();
		commandOptionsIndex = 0;
		commandOptions.addItem("FIGHT");
		commandOptions.addItem("POKeMON");
		commandOptions.addItem("BAG");
		commandOptions.addItem("RUN");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}
	void setFightOptions(){ // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 1;
		commandOptions.addItem("MOVE 1");
		commandOptions.addItem("MOVE 2");
		commandOptions.addItem("MOVE 3");
		commandOptions.addItem("MOVE 4");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}
	void setPokemonOptions(){ // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 2;
		commandOptions.addItem("POKeMON 1");
		commandOptions.addItem("POKeMON 2");
		commandOptions.addItem("POKeMON 3");
		commandOptions.addItem("POKeMON 4");
		commandOptions.addItem("POKeMON 5");
		commandOptions.addItem("POKeMON 6");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}
	void setItemOptions(){ // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 3;
		commandOptions.addItem("ITEMS");
		commandOptions.addItem("POKeBALLS");
		commandOptions.addItem("KEY ITEMS");
		commandOptions.addItem("BERRIES");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}
	 void handleOptionSelect(int index) {		 
		switch(commandOptionsIndex){
		case 0:
			switch(index){
			case 0: // BATTLE Screen; Initial screen giving fight bag pokemon run options
				setFightOptions();
				break;
			case 1: // POKeMON
				setPokemonOptions();
				break;
			case 2: // BAG
				setItemOptions();
				break;
			case 3: // RUN
				//Not Yet Implemented
				break;
			default:
				break;
			}
			break;
		case 1: // FIGHT Screen; showing Pokemons Moves
			switch(index){
			case 0: // MOVE 1
				//Not Yet Implemented
				break;
			case 1: // MOVE 2
				//Not Yet Implemented
				break;
			case 2: // MOVE 3
				//Not Yet Implemented
				break;
			case 3: // MOVE 4
				//Not Yet Implemented
				break;
			default:
				break;
			}
			break;
		}
			
		}
	 void incrementSelectedCommandOption(){
		 if(commandOptions.getSelectedIndex()<commandOptions.getItemCount()){
			 commandOptions.setItemSelected(commandOptions.getSelectedIndex()+1, true);
		 }
	 }
	 void decrementSelectedCommandOption(){
		 if(commandOptions.getSelectedIndex()>0){
			 commandOptions.setItemSelected(commandOptions.getSelectedIndex()-1, true);
		 }
	 }
	 public void setBattleAnnouncement(String announcement){
		 battleAnnouncementBox.setText(announcement);
	 }
}



