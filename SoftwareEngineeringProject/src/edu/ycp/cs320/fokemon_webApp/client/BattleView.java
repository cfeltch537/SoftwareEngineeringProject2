
package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.TurnChoice;

public class BattleView extends Composite{
	static final String holderId = "canvasholder";
	Canvas battleCanvasBackBuffer;
	Canvas battleCanvas;
	Context2d battleContext;
	Context2d battleBackBufferContext;
	// Widgets
	ListBox commandOptions;
	TextBox battleAnnouncementBox;
	Label userHPvMax;
	HealthBarWidget playerHPBar;
	HealthBarWidget opponentHPBar;
	// AspectRatios etc.
	int hpBarWidth = 123; //Pixel
	static int height;
	static int width;
	// Indices
	int key;
	int commandOptionsIndex = 0;
	int index;
	
	TempBattle test;
	
	// Temp variables for testing until Pokemon and battle classes are ready
	Image img1, img2, img3;
	Double hpRatio;
	//***************************************************************
	 //.getTeam(test.getUser().getCurrentPokemonIndex()).getStats().getCurHp() = 180.0;

	
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
	    FokemonUI.panel.getElement().getStyle().setPosition(Position.RELATIVE);
	    FokemonUI.panel.add(battleCanvas,0,0);
	    FokemonUI.panel.getElement().getStyle().setPosition(Position.RELATIVE);
	    
	    
	    commandOptions = new ListBox();
	    commandOptions.setVisibleItemCount(4);
	    commandOptions.setWidth("150px");
	    commandOptions.setHeight("80px");
	    setBattleOptions();
	    FokemonUI.panel.clear();
	    FokemonUI.panel.add(battleCanvas,0,0);
	    FokemonUI.panel.add(commandOptions, width-150-3, height-80-3);
	    FokemonUI.panel.getElement().getStyle().setPosition(Position.RELATIVE);

	    battleAnnouncementBox = new TextBox();
	    battleAnnouncementBox.setWidth(width-150-20 + "px");
	    battleAnnouncementBox.setHeight("40px");
	    battleAnnouncementBox.setText("Look at my horse. My horse is amazing!!!");
	    FokemonUI.panel.add(battleAnnouncementBox, 5, height-51);
	    FokemonUI.panel.getElement().getStyle().setPosition(Position.RELATIVE);
	    
	    //Add HP Bars
	    playerHPBar = new HealthBarWidget();
	    opponentHPBar = new HealthBarWidget();
	    FokemonUI.panel.add(playerHPBar.hpBarCanvas, width/2 - hpBarWidth/2 - 120, height/2 - 12 - 120);
	    FokemonUI.panel.add(opponentHPBar.hpBarCanvas, width/2 - hpBarWidth/2 + 120, height/2 - 12 - 120);
	    FokemonUI.panel.getElement().getStyle().setPosition(Position.RELATIVE);
		
	    // Instantiate Images since Pokemon class in not ready yet
	    img1 = new Image("PokemonSprites/Arena.png");
	    img2 = new Image("PokemonSprites/Charizard.png");
	    img3 = new Image("PokemonSprites/Pikachu.png");
	    
	    //Instantiate Battle
	    test = new TempBattle();
	    
	    battleBackBufferContext.setFillStyle(CssColor.make("rgba(211,211,211,0.2)"));

	    
	    initHandlers();	
	}
	
	void doUpdate() {
			// update the back canvas, set to fron canvas
			draw(battleBackBufferContext, battleContext);
		  }
	
	public void draw(Context2d context, Context2d front) {
		
		//context.save();
		context.fillRect(0, 0, width, height);
    	context.drawImage((ImageElement) img1.getElement().cast(), width/2 - img1.getWidth()/2, height/2-img1.getHeight()/2);
    	context.drawImage((ImageElement) img2.getElement().cast(), width/2 - img2.getWidth()/2 - 120, height/2 - img2.getHeight() - 10);
    	context.drawImage((ImageElement) img3.getElement().cast(), width/2 - img3.getWidth()/2 + 120, height/2 - img3.getHeight() - 10);
    	//The following should actually be triggered off of a change in HP, or turn
    	playerHPBar.doUpdate((double)test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getStats().getCurHp(), (double)test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getStats().getMaxHp());
		opponentHPBar.doUpdate((double)test.getOpp().getTeam(test.getOpp().getCurrentPokemonIndex()).getStats().getCurHp(), (double)test.getOpp().getTeam(test.getOpp().getCurrentPokemonIndex()).getStats().getMaxHp());
		updatePlayerHPLabel();
		//context.restore();
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
					handleOptionSelect(index);
					break;
				case 101: //E; Select
					handleOptionSelect(index);
					break;
				}
				setBattleAnnouncement(test.getBattle().getBattleMessage());
				//System.out.println(key); //For Debug
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
		for(int i=0; i<test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getMoves().size(); i++){
		commandOptions.addItem(test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getMove(i).getMoveName().toString());
		}
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
	void runAway(){
		setBattleAnnouncement("Could not escape!");
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
				runAway();
				break;
			default:
				break;
			}
			break;
		case 1: // FIGHT Screen; showing Pokemons Moves
			switch(index){
			case 0: // MOVE 1
				test.getUser().setMoveIndex(0);
				test.getOpp().setMoveIndex(0);
				test.getUser().setChoice(TurnChoice.MOVE);
				test.getOpp().setChoice(TurnChoice.MOVE);
				
				test.getBattle().Turn();
				
				
				
				//Attack; Temporarily reduce opponents HP by 20
				
				//(double)test.getOpp().getTeam(test.getOpp().getCurrentPokemonIndex()).getStats().getCurHp() = (double)test.getOpp().getTeam(test.getOpp().getCurrentPokemonIndex()).getStats().getCurHp()-25;
				setBattleOptions();
				break;
			case 1: // MOVE 2
				//Not Yet Implemented
				test.getUser().setMoveIndex(1);
				test.getOpp().setMoveIndex(0);
				test.getUser().setChoice(TurnChoice.MOVE);
				test.getOpp().setChoice(TurnChoice.MOVE);
				
				test.getBattle().Turn();
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
	 void updatePlayerHPLabel(){
		 //Initialize Label widget if not already
		 if(userHPvMax==null){
			 userHPvMax = new Label();
			 FokemonUI.panel.add(userHPvMax, width/2  - hpBarWidth/2 - 120, height/2 - 12 - 140);
		 }
		 userHPvMax.setText((double)test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getStats().getCurHp()+"/"+(double)test.getUser().getTeam(test.getUser().getCurrentPokemonIndex()).getStats().getMaxHp());
	 }
}



