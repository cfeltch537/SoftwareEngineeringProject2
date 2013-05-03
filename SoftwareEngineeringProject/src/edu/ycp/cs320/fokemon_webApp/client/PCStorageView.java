package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import edu.ycp.cs320.fokemon_webApp.shared.Player.Game;

public class PCStorageView extends Composite {
	static final String holderId = "canvasholder";
	AbsolutePanel storagePanel;
	ListBox listBox_CurrentTeam;
	ListBox listBox_StoredPokemon;
	Button addToParty;
	Button addToPC;
	Button increaseIndex;
	Button decreaseIndex;
	Button closeView;
	TextBox pcTextBox;
	static int height;
	static int width;
	static int height_offset;
	static int width_offset;
	static int listBox_Width;
	static int listBox_Height;
	static int button_Width;
	static int button_Height;


	public PCStorageView() {

		storagePanel = new AbsolutePanel();
		
		height = MapView.height;
		width = MapView.width;
		height_offset = 0;
		width_offset = 0;
		listBox_Width = 150;
		listBox_Height = 400;
		button_Width = 150;
		button_Height = 25;
		
		//set Absolute Panel dimensions to MapView dimensions
		storagePanel.setWidth(width + "px");
		storagePanel.setHeight(height + "px");
		storagePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Instantiate list boxes to contain party and PC pokemon
		listBox_CurrentTeam = new ListBox();
		listBox_CurrentTeam.setVisibleItemCount(4);
		listBox_CurrentTeam.setWidth(listBox_Width + "px");
		listBox_CurrentTeam.setHeight(listBox_Height + "px");
		listBox_StoredPokemon = new ListBox();
		listBox_StoredPokemon.setVisibleItemCount(4);
		listBox_StoredPokemon.setWidth(listBox_Width + "px");
		listBox_StoredPokemon.setHeight(listBox_Height + "px");
		storagePanel.clear();
		storagePanel.add(listBox_CurrentTeam, width_offset, height_offset);
		storagePanel.add(listBox_StoredPokemon, width_offset + listBox_Width, height_offset);
		storagePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Instantiate Battle AnnounceMent Text Box and add it to the Absolute
		// panel in bottom left corner and center
		pcTextBox = new TextBox();
		pcTextBox.setWidth(width - 150 - 20 + "px");
		pcTextBox.setHeight("40px");
		//storagePanel.add(pcTextBox, 5, height - 51);
		storagePanel.getElement().getStyle().setPosition(Position.RELATIVE);

		// Add Buttons
		addToParty = new Button();
		addToPC = new Button();
		closeView = new Button();
		addToParty.setWidth(button_Width + "px");
		addToParty.setHeight(button_Height + "px");
		addToParty.setText("Move to Team");
		storagePanel.add(addToParty, width_offset + 2*listBox_Width, height_offset);
		addToPC.setWidth(button_Width + "px");
		addToPC.setHeight(button_Height + "px");
		addToPC.setText("Move to PC");
		storagePanel.add(addToPC, width_offset + 2*listBox_Width, height_offset + +button_Height);
		closeView.setWidth(button_Width + "px");
		closeView.setHeight(button_Height + "px");
		closeView.setText("Close PC");
		storagePanel.add(closeView, width_offset + 2*listBox_Width, height_offset + 2*button_Height);
		storagePanel.getElement().getStyle().setPosition(Position.RELATIVE);
		
		addToParty.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Game.getUser().getTeamSize()<6 && Game.getUser().getPC().size()!=0){
					Game.getUser().addPokemonToTeam(Game.getUser().getPC().get(listBox_StoredPokemon.getSelectedIndex()));
					Game.getUser().getPC().remove(listBox_StoredPokemon.getSelectedIndex());
				}
				fillTextBoxs();
			}
		});
		addToPC.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if(Game.getUser().getTeamSize()>1){
					Game.getUser().getPC().add(Game.getUser().getTeam(listBox_CurrentTeam.getSelectedIndex()));
					Game.getUser().getTeam().remove(listBox_CurrentTeam.getSelectedIndex());
				}
				fillTextBoxs();
			}
		});
		closeView.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				FokemonUI.closePCview();
			}
		});	
	}


	void fillTextBoxs() { // Shows Pokemon Moves
		// listBox_CurrentTeam
		listBox_CurrentTeam.clear();
		for (int i = 0; i < Game.getUser().getTeam().size(); i++) {
			listBox_CurrentTeam.addItem(Game.getUser().getTeam(i).getInfo()
					.getNickname() + " Lvl: " + Game.getUser().getTeam(i).getInfo()
					.getLvl());
		}
		listBox_CurrentTeam.setFocus(true);
		listBox_CurrentTeam.setItemSelected(0, true);
		// listBox_StoredPokemon
		listBox_StoredPokemon.clear();
		for (int i = 0; i < Game.getUser().getPC().size(); i++) {
			listBox_StoredPokemon.addItem(Game.getUser().getPC().get(i).getInfo()
					.getNickname() + " Lvl: " + Game.getUser().getPC().get(i).getInfo()
					.getLvl());
			}
		if(Game.getUser().getPC().size()==0){
			listBox_StoredPokemon.addItem("Empty");
		}
		listBox_StoredPokemon.setItemSelected(0, true);
	}
}
