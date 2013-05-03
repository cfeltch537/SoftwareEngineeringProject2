package edu.ycp.cs320.fokemon_webApp.client;

import java.util.ArrayList;

import org.apache.commons.collections.functors.SwitchTransformer;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.fokemon_webApp.shared.Battle.Battle;
import edu.ycp.cs320.fokemon_webApp.shared.Battle.TurnChoice;
import edu.ycp.cs320.fokemon_webApp.shared.PokemonClasses.Status;

public class BattleView extends Composite {
	static final String holderId = "canvasholder";
	AbsolutePanel battlePanel;
	Canvas battleCanvasBackBuffer;
	Canvas battleCanvas;
	Context2d battleContext;
	Context2d battleBackBufferContext;
	// Widgets
	ListBox commandOptions;
	TextBox battleAnnouncementBox;
	Label userHPvMax;
	Label playerPokemonName;
	Label opponentPokemonName;
	Image playerStatusAilments;
	Image opponentStatusAilments;
	Image playerPokemon;
	Image opponentPokemon;
	HealthBarWidget playerHPBar;
	HealthBarWidget opponentHPBar;
	XPBarWidget playerXPBar;
	// AspectRatios etc.
	int hpBarWidth = 123; // Pixel
	static int height;
	static int width;
	// Indices
	int key = 0;
	int commandOptionsIndex = 0;
	int index = 0;
	int messageIndex = 0;
	int turnIndex = 0;

	Battle battle;

	// Temp variables for testing until Pokemon and battle classes are ready
	Image img1, img2, img3;
	Double hpRatio;

	// ***************************************************************
	// .getTeam(battle.getUser().getCurrentPokemonIndex()).getStats().getCurHp()
	// = 180.0;

	public BattleView() {

		battlePanel = new AbsolutePanel();
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

		battlePanel.setWidth(width + "px");
		battlePanel.setHeight(height + "px");
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		battlePanel.add(battleCanvas, 0, 0);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Instantiate Command Options List box and add it to the Absolute panel
		// in bottom right corner
		commandOptions = new ListBox();
		commandOptions.setVisibleItemCount(4);
		commandOptions.setWidth("150px");
		commandOptions.setHeight("80px");
		setBattleOptions();
		battlePanel.clear();
		battlePanel.add(battleCanvas, 0, 0);
		battlePanel.add(commandOptions, width - 150 - 3, height - 80 - 3);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Instantiate Battle AnnounceMent Text Box and add it to the Absolute
		// panel in bottom left corner and center
		battleAnnouncementBox = new TextBox();
		battleAnnouncementBox.setWidth(width - 150 - 20 + "px");
		battleAnnouncementBox.setHeight("40px");
		battlePanel.add(battleAnnouncementBox, 5, height - 51);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Add HP Bars
		playerHPBar = new HealthBarWidget();
		opponentHPBar = new HealthBarWidget();
		playerXPBar = new XPBarWidget();
		battlePanel.add(playerHPBar.hpBarCanvas, width / 2 - hpBarWidth / 2 - 120, height / 2 - 15 - 120);
		battlePanel.add(opponentHPBar.hpBarCanvas, width / 2 - hpBarWidth / 2 + 120, height / 2 - 15 - 120);
		battlePanel.add(playerXPBar.xpBarCanvas, width / 2 - hpBarWidth / 2 - 120, height / 2 - 15 + 10 - 120);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		// Instantiate Images since Pokemon class in not ready yet
		img1 = new Image("PokemonSprites/Arena.png");
		// Instantiate Battle
		battleBackBufferContext.setFillStyle(CssColor.make("rgba(224,224,224,0.1)"));
		initHandlers();

	}

	void setBattle(Battle battle) {
		this.battle = battle;
		onPokemonShift();
		draw(battleBackBufferContext, battleContext);
		battleAnnouncementBox.setText(this.battle.getBattleMessage().get(0));
	}

	void doUpdate() {
		// update the back canvas, set to front canvas
		draw(battleBackBufferContext, battleContext);

	}

	void onPokemonShift() {
		updatePokemonLabels();
		updatePokemonImages();
		updatePokemonStatus();
	}

	public void draw(Context2d context, Context2d front) {
		// context.save();
		context.fillRect(0, 0, width, height);
		context.drawImage((ImageElement) img1.getElement().cast(), width / 2
				- img1.getWidth() / 2, height / 2 - img1.getHeight() / 2);
		
		playerHPBar.doUpdate(
				(double) battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getStats().getCurHp(), (double) battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getStats().getMaxHp());
		opponentHPBar.doUpdate(
				(double) battle.getOpponent()
						.getTeam(battle.getOpponent().getCurrentPokemonIndex())
						.getStats().getCurHp(), (double) battle.getOpponent()
						.getTeam(battle.getOpponent().getCurrentPokemonIndex())
						.getStats().getMaxHp());
		playerXPBar.doUpdate(
				(double) battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getInfo().getXp() - Math.pow(battle.getUser()
								.getTeam(battle.getUser().getCurrentPokemonIndex())
								.getInfo().getLvl(), 3), (double) Math.pow(battle.getUser()
								.getTeam(battle.getUser().getCurrentPokemonIndex())
								.getInfo().getLvl()+1, 3) - Math.pow(battle.getUser()
										.getTeam(battle.getUser().getCurrentPokemonIndex())
										.getInfo().getLvl(), 3));
		updatePlayerHPLabel();

		// context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}

	void initHandlers() {
		KeyPressHandler wasdHandler = new KeyPressHandler() {
			@Override
			public void onKeyPress(KeyPressEvent event) {
				key = event.getUnicodeCharCode();
				index = commandOptions.getSelectedIndex();

				switch (key) {
				case 32: // Space; Select
					handleOptionSelect(index);
					break;
				case 53: // 2; DOWN in list
					incrementSelectedCommandOption();
					break;
				case 115: // S; DOWN in list
					incrementSelectedCommandOption();
					break;
				case 55: // 7; BACK to setBattleOptions()
					setBattleOptions();
					break;
				case 113: // Q; BACK to setBattleOptions()
					setBattleOptions();
					break;
				case 56: // 8; UP in list
					decrementSelectedCommandOption();
					break;
				case 119: // W; UP in list
					decrementSelectedCommandOption();
					break;
				case 57: // 9; Select
					handleOptionSelect(index);
					break;
				case 101: // E; Select
					handleOptionSelect(index);
					break;
				}
				// System.out.println(key); //For Debug
			}
		};
		commandOptions.addDomHandler(wasdHandler, KeyPressEvent.getType());
		commandOptions.setFocus(true);
	}

	void setBattleOptions() {
		commandOptions.clear();
		commandOptionsIndex = 0;
		commandOptions.addItem("FIGHT");
		commandOptions.addItem("POKeMON");
		commandOptions.addItem("BAG");
		commandOptions.addItem("RUN");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}

	void setFightOptions() { // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 1;
		for (int i = 0; i < battle.getUser()
				.getTeam(battle.getUser().getCurrentPokemonIndex()).getMoves()
				.size(); i++) {
			commandOptions.addItem(battle.getUser()
					.getTeam(battle.getUser().getCurrentPokemonIndex())
					.getMove(i).getMoveName().name
					+ " "
					+ battle.getUser()
							.getTeam(battle.getUser().getCurrentPokemonIndex())
							.getMove(i).getCurPP()
					+ "/"
					+ battle.getUser()
							.getTeam(battle.getUser().getCurrentPokemonIndex())
							.getMove(i).getMaxPP());
		}
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}

	void setPokemonOptions() { // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 2;
		for (int i = 0; i < battle.getUser().getTeam().size(); i++) {
			commandOptions.addItem(battle.getUser().getTeam(i).getInfo()
					.getNickname());
		}
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}

	void setItemOptions() { // Shows Pokemon Moves
		commandOptions.clear();
		commandOptionsIndex = 3;
//		commandOptions.addItem("ITEMS");
//		commandOptions.addItem("POKeBALLS");
//		commandOptions.addItem("KEY ITEMS");
//		commandOptions.addItem("BERRIES");
		for (int i = 0; i < battle.getUser().getItems().size(); i++) {
			commandOptions.addItem(battle.getUser().getItems().get(i).getItemName() + "  " + battle.getUser().getItems().get(i).getQuantity());
		}
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}

	void runAway() {
		battleAnnouncementBox.setText("Could not get away!");
	}

	void switchToNextScreen() {
		commandOptions.clear();
		commandOptions.addItem("NEXT...");
		commandOptions.setFocus(true);
		commandOptions.setItemSelected(0, true);
	}

	void handleOptionSelect(int index) { // Called by KB Handler; Handles User
											// Input
		switch (commandOptionsIndex) {
		case 0: // At Fight, Pokemon, Bag, Run Screen
			switch (index) {
			case 0:
				setFightOptions(); // FIGHT Selected
				break;
			case 1:
				setPokemonOptions(); // POKeMON Selected
				break;
			case 2:
				setItemOptions(); // BAG Selected
				break;
			case 3:
				handleTurn(index, TurnChoice.RUN);
				;// RUN Selected
				break;
			default:
				break;
			}
			break;
		case 1: // FIGHT SCREEN ... Trigger Move
			handleTurn(index, TurnChoice.MOVE);
			break;
		case 2: // Pokemon Screen ... Trigger Move
			handleTurn(index, TurnChoice.SWITCH);
			break;
		case 3: // Pokemon Screen ... Trigger Move
			handleTurn(index, TurnChoice.ITEM);
			break;
		}
	}

	void handleTurn(int userMoveIndex, TurnChoice userTurnChoice) {
		switch (turnIndex) {
		case 0: // TURN 1 SCREEN ... Message from Turn 1 Printing
			if (messageIndex == 0) {
				handleTurn1(index, userTurnChoice);
				switchToNextScreen();
			}
			if (messageIndex < battle.getBattleMessage().size()) { // While there is still a message to be displayed
				setBattleAnnouncement(battle.getBattleMessage(), messageIndex); // Display message
				messageIndex++; // Move on too next message
			} else { // When no more messages to be displayed
				messageIndex = 0; // reset message index
				checkEndBattle();
				handleTurn2(); // Trigger turn 2 (Slower Pokemon)
				switchToNextScreen(); // remain at next screen
				turnIndex = 1; // Switch to Turn 2 Case
			}
			break;
		case 1: // Turn 2 case
			if (messageIndex < battle.getBattleMessage().size()) { // While there is still a message to be displayed
				setBattleAnnouncement(battle.getBattleMessage(), messageIndex); // Display message
				messageIndex++; // Move on too next message
			} else { // When no more messages to be displayed
				messageIndex = 0; // Reset message index
				checkEndBattle();
				handleTurn3(); // Trigger turn 3 (Post Battle Damage and
								// Announcements)
				if (battle.getBattleMessage().size() != 0) {
					//setBattleAnnouncement(battle.getBattleMessage(),messageIndex);
					turnIndex = 2;
				} else {
					messageIndex = 0; // Reset message index
					turnIndex = 0;
					setBattleOptions(); // Return to Cattle Options for next
										// turn
				}
			}
			break;
		case 2: // Turn 3 Case
			if (messageIndex < battle.getBattleMessage().size()) { // While there is still a message to be displayed
				setBattleAnnouncement(battle.getBattleMessage(), messageIndex); // Display message
				messageIndex++; // Move on too next message
			} else { // When no more messages to be displayed
				messageIndex = 0; // reset message index
				setBattleOptions(); // Return to Cattle Options for next turn
				checkEndBattle();
				turnIndex = 0;
			}
			break;
		}
	}

	void incrementSelectedCommandOption() {
		if (commandOptions.getSelectedIndex() < commandOptions.getItemCount() - 1) {
			commandOptions.setItemSelected(
					commandOptions.getSelectedIndex() + 1, true);
		}
	}

	void decrementSelectedCommandOption() {
		if (commandOptions.getSelectedIndex() > 0) {
			commandOptions.setItemSelected(
					commandOptions.getSelectedIndex() - 1, true);
		}
	}

	public void setBattleAnnouncement(ArrayList<String> announcement, int index) {
		if (index < announcement.size()) {
			battleAnnouncementBox.setText(announcement.get(index));
		}
	}

	void updatePlayerHPLabel() {
		// Initialize Label widget if not already
		if (userHPvMax == null) {
			userHPvMax = new Label();
			battlePanel.add(userHPvMax, width / 2 - hpBarWidth / 2 - 120,
					height / 2 - 12 - 110);
		}
		userHPvMax.setText(battle.getUser()
				.getTeam(battle.getUser().getCurrentPokemonIndex()).getStats()
				.getCurHp()
				+ "/"
				+ battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getStats().getMaxHp());
	}

	void updatePokemonLabels() {
		// Player Battling Pokemon
		if (playerPokemonName == null) {
			playerPokemonName = new Label();
			battlePanel.add(playerPokemonName,
					width / 2 - hpBarWidth / 2 - 120, height / 2 - 12 - 140);
			battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		}
		playerPokemonName.setText(battle.getUser()
				.getTeam(battle.getUser().getCurrentPokemonIndex()).getInfo()
				.getNickname()
				+ "  Lv"
				+ battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getInfo().getLvl());
		// Player Battling Pokemon
		if (opponentPokemonName == null) {
			opponentPokemonName = new Label();
			battlePanel.add(opponentPokemonName, width / 2 - hpBarWidth / 2
					+ 120, height / 2 - 12 - 140);
			battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		}
		opponentPokemonName.setText(battle.getOpponent()
				.getTeam(battle.getOpponent().getCurrentPokemonIndex())
				.getInfo().getNickname()
				+ "  Lv"
				+ battle.getOpponent()
						.getTeam(battle.getOpponent().getCurrentPokemonIndex())
						.getInfo().getLvl());
	}

	void updatePokemonImages() {
		// Player Battling Pokemon
		if (playerPokemon != null) {
			battlePanel.remove(playerPokemon);
		}
		playerPokemon = new Image("PokemonSprites/"
				+ battle.getUser()
						.getTeam(battle.getUser().getCurrentPokemonIndex())
						.getInfo().getPokeName() + ".png");// This should set to
															// a pokemons ID
															// specific Image
		playerPokemon.setVisible(false);
		battlePanel.add(playerPokemon);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		playerPokemon.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				battlePanel.remove(playerPokemon);
				battlePanel.getElement().getStyle()
						.setPosition(Position.RELATIVE);
				battlePanel.add(playerPokemon,
						width / 2 - playerPokemon.getWidth() / 2 - 120, height
								/ 2 - playerPokemon.getHeight() - 10);
				battlePanel.getElement().getStyle()
						.setPosition(Position.RELATIVE);
				playerPokemon.setVisible(true);
			}
		});

		// Opponent Battling Pokemon

		if (opponentPokemon != null) {
			battlePanel.remove(opponentPokemon);
		}
		// opponentPokemon = new Image("PokemonSprites/Snorlax.png");//This
		// should set to a pokemons ID specific Image
		opponentPokemon = new Image("PokemonSprites/"
				+ battle.getOpponent()
						.getTeam(battle.getOpponent().getCurrentPokemonIndex())
						.getInfo().getPokeName() + ".png");// This should set to
															// a pokemons ID
															// specific Image
		opponentPokemon.setVisible(false);
		battlePanel.add(opponentPokemon);
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		opponentPokemon.addLoadHandler(new LoadHandler() {
			@Override
			public void onLoad(LoadEvent event) {
				battlePanel.remove(opponentPokemon);
				battlePanel.add(opponentPokemon,
						width / 2 - opponentPokemon.getWidth() / 2 + 120,
						height / 2 - opponentPokemon.getHeight() - 10);
				opponentPokemon.setVisible(true);
			}
		});
		battlePanel.getElement().getStyle().setPosition(Position.RELATIVE);
	}

	void updatePokemonStatus() {

		// Player
		if (playerStatusAilments == null) {
			playerStatusAilments = new Image();
			battlePanel.add(playerStatusAilments, width / 2 - hpBarWidth / 2
					- 120 - 34, height / 2 - 25 - 110);
		}
		switch (battle.getUser()
				.getTeam(battle.getUser().getCurrentPokemonIndex()).getStats()
				.getStatus()) {
		case BRN:
			playerStatusAilments.setUrl("StatusAilments/Burn.png");
			playerStatusAilments.setVisible(true);
			break;
		case FNT:
			playerStatusAilments.setUrl("StatusAilments/Faint.png");
			playerStatusAilments.setVisible(true);
			break;
		case SLP:
			playerStatusAilments.setUrl("StatusAilments/Sleep.png");
			playerStatusAilments.setVisible(true);
			break;
		case PRL:
			playerStatusAilments.setUrl("StatusAilments/Paralyze.png");
			playerStatusAilments.setVisible(true);
			break;
		case PSN:
			playerStatusAilments.setUrl("StatusAilments/Poison.png");
			playerStatusAilments.setVisible(true);
			break;
		case FRZ:
			playerStatusAilments.setUrl("StatusAilments/Freeze.png");
			playerStatusAilments.setVisible(true);
			break;
		case NRM:
			playerStatusAilments.setVisible(false);
		default:
			break;
		}
		playerStatusAilments.setPixelSize(32, 11);

		// Opponent
		if (opponentStatusAilments == null) {
			opponentStatusAilments = new Image();
			battlePanel.add(opponentStatusAilments, width / 2 + hpBarWidth / 2
					+ 120 + 3, height / 2 - 25 - 110);
		}

		switch (battle.getOpponent()
				.getTeam(battle.getOpponent().getCurrentPokemonIndex())
				.getStats().getStatus()) {
		case BRN:
			opponentStatusAilments.setUrl("StatusAilments/Burn.png");
			opponentStatusAilments.setVisible(true);
			break;
		case FNT:
			opponentStatusAilments.setUrl("StatusAilments/Faint.png");
			opponentStatusAilments.setVisible(true);
			break;
		case SLP:
			opponentStatusAilments.setUrl("StatusAilments/Sleep.png");
			opponentStatusAilments.setVisible(true);
			break;
		case PRL:
			opponentStatusAilments.setUrl("StatusAilments/Paralyze.png");
			opponentStatusAilments.setVisible(true);
			break;
		case PSN:
			opponentStatusAilments.setUrl("StatusAilments/Poison.png");
			opponentStatusAilments.setVisible(true);
			break;
		case FRZ:
			opponentStatusAilments.setUrl("StatusAilments/Freeze.png");
			opponentStatusAilments.setVisible(true);
			break;
		case NRM:
			opponentStatusAilments.setVisible(false);
		default:
			break;
		}
		opponentStatusAilments.setPixelSize(32, 11);
	}

	void handleTurn1(int moveIndex, TurnChoice userChoice) {
		battle.getUser().setMoveIndex(moveIndex);
		battle.getOpponent().setMoveIndex(0);
		battle.getUser().setChoice(userChoice);
		battle.getOpponent().setChoice(TurnChoice.MOVE);
		battle.Turn(1);
		updatePokemonStatus();
		setBattleAnnouncement(battle.getBattleMessage(), messageIndex);
		if (userChoice.equals(TurnChoice.SWITCH)) {
			onPokemonShift();
		}
	}

	void handleTurn2() {
		battle.Turn(2);
		updatePokemonStatus();
		setBattleAnnouncement(battle.getBattleMessage(), messageIndex);
		messageIndex++;
	}

	void handleTurn3() {
		battle.Turn(3);
		updatePokemonStatus();
		if (battle.getBattleMessage().size() != 0) {
			setBattleAnnouncement(battle.getBattleMessage(), messageIndex);
		}
		messageIndex++;
	}

	void checkEndBattle() {
		if (battle.getBattleOver()) {
			FokemonUI.endBattle();
		}
	}
}
