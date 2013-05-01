package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Random;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import edu.ycp.cs320.fokemon_webApp.shared.GUI.Area;
import edu.ycp.cs320.fokemon_webApp.shared.GUI.InteractableObject;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;

public class MapView extends Composite {
	static final String holderId = "canvasholder";
	Canvas backBuffer;
	AbsolutePanel mapPanel;
	Canvas canvas;
	Context2d context;
	Context2d backBufferContext;
	Area[] areaList;
	Player player;
	Image img;
	static int height;
	static int width;

	Image playerImage;
	Image playerImageCovered;

	public MapView() {

		//Change
		mapPanel = new AbsolutePanel();
		player = new Player(00004, "Cody", true, new Location(0, 20, 20)); // Player
		playerImage = new Image("23x25_Trainer_Front.png");															// Cody
		playerImageCovered = new Image("23x25_Trainer_Front.png");		
		areaList = new Area[2];
		areaList[0] = new Area();
		areaList[0].createTallGrassSquare(5, 5, 10, 4);
		areaList[0].createTallGrassSquare(5, 10, 10, 4);
		areaList[0].createTallGrassSquare(5, 15, 10, 4);
		areaList[0].placeStructure(25, 10, InteractableObject.PokeCenter);
		areaList[1] = new Area();


		height = 16 * areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[0].length;
		width = 16 * areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length;


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

		doUpdate();
		initHandlers();
	}


	void initialize() {
		// update the back canvas, set to front canvas
		playerImageCovered.setVisibleRect(0, 0, playerImageCovered.getWidth(), playerImageCovered.getHeight()*2/3);
		drawFlooring(backBufferContext, context);
		drawInteractableObjects(backBufferContext, context);
		drawPlayer(backBufferContext, context);
	}

	void doUpdate() {
		// update the back canvas, set to fron canvas

		drawPlayer(backBufferContext, context);
	}

	public void drawFlooring(Context2d context, Context2d front) {

		context.save();

		// DrawFlooring
		for (int height = 0; height < areaList[player.getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[player.getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				if (areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img != null) {
					img = areaList[player.getPlayerLocation()
							.getAreaArrayIndex()].terrain[height][width].flooring.img;
					context.drawImage((ImageElement) img.getElement().cast(),
							16 * height, 16 * width);
				}
			}
		}

		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}		
	public void drawInteractableObjects(Context2d context, Context2d front) {

		context.save();	
		// InteractableObjects
		for (int height = 0; height < areaList[player.getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[player.getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				// ^Iterate through each terrain in the area
				for (int objectIndex = 0; objectIndex < areaList[player
						.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList
						.size(); objectIndex++) {
					if (areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList
							.get(objectIndex).img != null) {
						if (areaList[player.getPlayerLocation()
								.getAreaArrayIndex()].terrain[height][width].interactableObjectList
								.get(objectIndex).img != null) {
							img = areaList[player.getPlayerLocation()
									.getAreaArrayIndex()].terrain[height][width].interactableObjectList
									.get(objectIndex).img;
							context.drawImage((ImageElement) img.getElement()
									.cast(), 16 * height, 16 * width);
						}
					}
				}
			}
		}

		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}

	public void drawPlayer(Context2d context, Context2d front) {

		context.save();	
		// Player
		for (int height = 0; height < areaList[player.getPlayerLocation()
				.getAreaArrayIndex()].terrain.length; height++) {
			for (int width = 0; width < areaList[player.getPlayerLocation()
					.getAreaArrayIndex()].terrain[height].length; width++) {
				if (height == player.getPlayerLocation().getX()
						&& width == player.getPlayerLocation().getY()) {
					if (areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player
							.getPlayerLocation().getX()][player
							.getPlayerLocation().getY()].isTallGrassPresent()) {
						mapPanel.remove(playerImage);
						mapPanel.add(playerImageCovered,
								16 * player.getPlayerLocation().getX() - 3,
								16 * player.getPlayerLocation().getY() - 15 + 2);
						if (Random.nextInt(100) <= 12) {
							FokemonUI.startBattle();
						}
					} else {
						mapPanel.remove(playerImageCovered);
						mapPanel.add(playerImage,
								16 * player.getPlayerLocation().getX() - 3,
								16 * player.getPlayerLocation().getY() - 15 + 2);
					}
				mapPanel.getElement().getStyle().setPosition(Position.RELATIVE);
				}
			}
		}
		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
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
				doUpdate();
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
			player.getPlayerLocation().setY(player.getPlayerLocation().getY() - 1);
		}else if(direction.equals("down")&&validMove(direction)){
			player.getPlayerLocation().setY(player.getPlayerLocation().getY() + 1);
		}else if(direction.equals("left")&&validMove(direction)){
			player.getPlayerLocation().setX(player.getPlayerLocation().getX() - 1);
		}else if(direction.equals("right")&&validMove(direction)){
			player.getPlayerLocation().setX(player.getPlayerLocation().getX() + 1);
		}
	}
	public boolean validMove(String direction){
		
		if (direction.equals("right")
				&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()+1][player.getPlayerLocation().getY()].isMovable()) {
			return true;
		} else if (direction.equals("left")
				&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()-1][player.getPlayerLocation().getY()].isMovable()) {
			return true;
		} else if (direction.equals("up")
				&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()-1].isMovable()) {
			return true;
		} else if (direction.equals("down")
				&&(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()+1].isMovable())){
			return true;
		}
		return false;
	}
}
