package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.GUI.Area;
import edu.ycp.cs320.fokemon_webApp.shared.GUI.Flooring;
import edu.ycp.cs320.fokemon_webApp.shared.GUI.InteractableObject;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;

public class MapView extends Composite {
	static final String holderId = "canvasholder";
	Canvas backBuffer;
	AbsolutePanel mapPanel;
	Canvas canvas;
	Context2d context;
	Context2d backBufferContext;
	public Area[] areaList;
	Image img;
	static int height;
	static int width;
	int mapHeightMAX = 30;
	int mapWidthMAX = 60;

	Image playerImage;
	Image playerImageCovered;

	public MapView() {
	}
	void initialize() {
		
		mapPanel = new AbsolutePanel();
		if(Game.getUser().getGender()){
			playerImage = new Image("Trainer_Male.png");	
			playerImageCovered = new Image("Trainer_Male.png");
		}else{
			playerImage = new Image("Trainer_Female.png");	
			playerImageCovered = new Image("Trainer_Female.png");	
		}
		playerImageCovered.setVisibleRect(0, 0, playerImageCovered.getWidth(), playerImageCovered.getHeight()*2/3);
		areaList = new Area[2];
		areaList[0] = new Area(mapWidthMAX, mapHeightMAX, Flooring.Grass);
		areaList[0].createTallGrassSquare(5, 5, 10, 4);
		areaList[0].createTallGrassSquare(5, 10, 10, 4);
		areaList[0].createTallGrassSquare(5, 15, 10, 4);
		areaList[0].setTerrain(40, 45, 0, 30, Flooring.Sand);
		areaList[0].setTerrain(45, 60, 0, 30, Flooring.SaltWater);
		areaList[0].placeStructure(25, 10, InteractableObject.PokeCenter, true);
		areaList[0].placeStructure(38, 14, InteractableObject.PC, true);
		areaList[0].placeStructure(45, 10, InteractableObject.Boat, true);
		areaList[0].placeStructure(44, 13, InteractableObject.AreaIncrement, false);
		areaList[1] = new Area(41, 21, Flooring.WoodFloor);
		areaList[1].placeStructure(40, 11, InteractableObject.AreaDecrement, false);
		areaList[1].placeStructure(15, 6, InteractableObject.PokeRing, false);
		areaList[1].placeStructure(17, 8, InteractableObject.Lance, true);
		areaList[1].placeStructure(19, 12, InteractableObject.EnterLanceBattle, false);

		height = 16 * mapHeightMAX;
		width = 16 * mapWidthMAX;


		canvas = Canvas.createIfSupported();
		backBuffer = Canvas.createIfSupported();

		// init the canvases
		canvas.setWidth(width + "px");
		canvas.setHeight(height + "px");
		canvas.setCoordinateSpaceWidth(width);
		canvas.setCoordinateSpaceHeight(height);
		backBuffer.setCoordinateSpaceWidth(width);
		backBuffer.setCoordinateSpaceHeight(height);
		backBuffer.setCoordinateSpaceWidth(width);
		backBuffer.setCoordinateSpaceHeight(height);
		context = canvas.getContext2d();
		backBufferContext = backBuffer.getContext2d();

		mapPanel.setWidth(width + "px");
		mapPanel.setHeight(height + "px");
		mapPanel.add(canvas);
		mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// update the back canvas, set to front canvas
//		drawFlooring(backBufferContext, context);
//		drawInteractableObjects(backBufferContext, context);
//		drawPlayer(backBufferContext, context);
//		movementUpdate();
		initHandlers();
	}
	void movementUpdate() {
		// update the back canvas, set to fron canvas
		drawPlayer();
		checkForInteractions();
	}
	void drawFlooring() {

		context.save();

		// Draw Nothing-ness
		for (int height = 0; height < mapWidthMAX; height++) {
			for (int width = 0; width < mapHeightMAX; width++) {					
				backBufferContext.drawImage((ImageElement) Flooring.Nothing.img.getElement().cast(), 16 * height, 16 * width);
			}
		}

		// DrawFlooring
		for (int height = 0; height < areaList[Game.getUser().getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[Game.getUser().getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img != null) {
					img = areaList[Game.getUser().getPlayerLocation()
							.getAreaArrayIndex()].terrain[height][width].flooring.img;
					backBufferContext.drawImage((ImageElement) img.getElement().cast(),
							16 * height, 16 * width);
				}
			}
		}

		backBufferContext.restore();
		context.drawImage(backBufferContext.getCanvas(), 0, 0);
	}		
	void drawInteractableObjects() {

		backBufferContext.save();	
		// InteractableObjects
		for (int height = 0; height < areaList[Game.getUser().getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[Game.getUser().getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				// ^Iterate through each terrain in the area
				for (int objectIndex = 0; objectIndex < areaList[Game.getUser()
						.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList
						.size(); objectIndex++) {
					if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList
							.get(objectIndex).img != null) {
						if (areaList[Game.getUser().getPlayerLocation()
								.getAreaArrayIndex()].terrain[height][width].interactableObjectList
								.get(objectIndex).img != null) {
							img = areaList[Game.getUser().getPlayerLocation()
									.getAreaArrayIndex()].terrain[height][width].interactableObjectList
									.get(objectIndex).img;
							backBufferContext.drawImage((ImageElement) img.getElement()
									.cast(), 16 * height, 16 * width);
						}
					}
				}
			}
		}

		backBufferContext.restore();
		context.drawImage(backBufferContext.getCanvas(), 0, 0);
	}
	public void drawPlayer() {

		backBufferContext.save();	
		// Player
		for (int height = 0; height < areaList[Game.getUser().getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[Game.getUser().getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				if (height == Game.getUser().getPlayerLocation().getX()
						&& width == Game.getUser().getPlayerLocation().getY()) {
					if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser()
							.getPlayerLocation().getX()][Game.getUser()
							.getPlayerLocation().getY()].isTallGrassPresent()) {
						mapPanel.remove(playerImage);
						mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);
						mapPanel.add(playerImageCovered,
								16 * Game.getUser().getPlayerLocation().getX() - 3,
								16 * Game.getUser().getPlayerLocation().getY() - 15 + 2);
						mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);
					}else{
						mapPanel.remove(playerImageCovered);
						mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);
						mapPanel.add(playerImage,
								16 * Game.getUser().getPlayerLocation().getX() - 3,
								16 * Game.getUser().getPlayerLocation().getY() - 15 + 2);
						mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);
					}
				
				}
			}
		}
		backBufferContext.restore();
		context.drawImage(backBufferContext.getCanvas(), 0, 0);
	}
	void initHandlers() {
		KeyPressHandler wasdHandler = new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				int key = event.getUnicodeCharCode();
				switch (key) {
				case 119: // W; UP
					movePlayer("up");
					break;
				case 56: // 8; UP
					movePlayer("up");
					break;
				case 115: // S; DOWN
					movePlayer("down");
					break;
				case 53: // 5; DOWN
					movePlayer("down");
					break;
				case 97: // A, LEFT
					movePlayer("left");
					break;
				case 52: // 4; LEFT
					movePlayer("left");
					break;
				case 100: // D; RIGHT
					movePlayer("right");
					break;
				case 54: // 6; RIGHT
					movePlayer("right");
					break;
				}
				//System.out.println(key); // For Debug
				movementUpdate();
			}
		};
		canvas.addDomHandler(wasdHandler, KeyPressEvent.getType());
		canvas.setFocus(true);
	}
	public void setFocusCanvas() {
		canvas.setFocus(true);
	}
	public void movePlayer(String direction){
		if(direction.equals("up")&&validMove(direction)){
			Game.getUser().getPlayerLocation().setY(Game.getUser().getPlayerLocation().getY() - 1);
		}else if(direction.equals("down")&&validMove(direction)){
			Game.getUser().getPlayerLocation().setY(Game.getUser().getPlayerLocation().getY() + 1);
		}else if(direction.equals("left")&&validMove(direction)){
			Game.getUser().getPlayerLocation().setX(Game.getUser().getPlayerLocation().getX() - 1);
		}else if(direction.equals("right")&&validMove(direction)){
			Game.getUser().getPlayerLocation().setX(Game.getUser().getPlayerLocation().getX() + 1);
		}
	}
	public boolean validMove(String direction){
		
		if (direction.equals("right")
				&&Game.getUser().getPlayerLocation().getX()+1 < areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain.length
				&&areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()+1][Game.getUser().getPlayerLocation().getY()].isMovable()){
			return true;
		} else if (direction.equals("left")
				&&Game.getUser().getPlayerLocation().getX()-1 >= 0
				&&areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()-1][Game.getUser().getPlayerLocation().getY()].isMovable()) {
			return true;
		} else if (direction.equals("up")
				&&Game.getUser().getPlayerLocation().getY()-1 > 0
				&&areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()-1].isMovable()) {
			return true;
		} else if (direction.equals("down")
				&&Game.getUser().getPlayerLocation().getY()+1 < areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[0].length
				&&areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()+1].isMovable()){
			return true;
		}
		return false;
	}
	public void checkForInteractions(){
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isHealAllSpace()) {
			Game.HealTeam();
			Window.alert("Pokemon HP Fully Restored!!!");
		} //Healing Interaction
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isWildPokemon()
				&&(Random.nextInt(100) <= 12)) { //12% change of entering battle
			FokemonUI.startBattle(Battle.wildPokemonBattle());
		} //Enter Random Battle Interaction
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isEnterPCView()){ 
			FokemonUI.enterPCView();
		} //Enter PC View
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isIncrementAreaIndex()){ 
			Game.getUser().getPlayerLocation().setAreaArrayIndex(Game.getUser().getPlayerLocation().getAreaArrayIndex() +1);
			Game.getUser().getPlayerLocation().setX(1);
			Game.getUser().getPlayerLocation().setY(11);
			completeUpdate();
		} //Increment Area Index
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isDecrementAreaIndex()){ 
			Game.getUser().getPlayerLocation().setAreaArrayIndex(Game.getUser().getPlayerLocation().getAreaArrayIndex() -1);
			Game.getUser().getPlayerLocation().setX(43);
			Game.getUser().getPlayerLocation().setY(13);
			completeUpdate();
		} //Decrement Area Index
		if (areaList[Game.getUser().getPlayerLocation().getAreaArrayIndex()].terrain[Game.getUser().getPlayerLocation().getX()][Game.getUser().getPlayerLocation().getY()].isTrainerBattle()){ 
			FokemonUI.startBattle(Game.getBossBattle());
		} //Trigger Trainer Battle
	}
	public void completeUpdate() {
		drawFlooring();
		drawInteractableObjects();
		drawPlayer();
	}
}
