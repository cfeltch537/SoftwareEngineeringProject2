package edu.ycp.cs320.fokemon_webApp.shared.GUI;

import com.google.gwt.user.client.ui.Image;

public class Area {
	int HEIGHT;
	int WIDTH;
	Image img;

	public Terrain[][] terrain;

	public Area(int WIDTH, int HEIGHT, Flooring flooring) {
		
		terrain = new Terrain[WIDTH][HEIGHT];
		
		if(flooring!=null){
			for (int width = 0; width < WIDTH; width++) {
				for (int height = 0; height < HEIGHT; height++) {
						terrain[width][height] = new Terrain(flooring, null);
				}
			}
		}
	}
	
	public void setTerrain(int xStart, int xEnd, int yStary, int yEnd, Flooring flooring){
		for (int width = xStart; width < xEnd; width++) {
			for (int height = yStary; height < yEnd; height++) {
				terrain[width][height] = new Terrain(flooring, null);
			}
		}
	}

	public void createTallGrassSquare(int x_start, int y_start, int width,
			int height) {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (i == 0 && j == 0) { // Upper Left Corner
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassUpperLeftEdge);
				} else if (i == width - 1 && j == height - 1) { // Lower Right
																// Corner
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassLowerRightEdge);
				} else if (i == 0 && j == height - 1) { // Lower Left Corner
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassLowerLeftEdge);
				} else if (i == width - 1 && j == 0) { // Upper Right Corner
														// Corner
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassUpperRightEdge);
				} else if (i == 0) { // Left Edge
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassLeftEdge);
				} else if (j == 0) { // Upper Edge
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassUpperEdge);
				} else if (i == width - 1) { // Right Edge
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassRightEdge);
				} else if (j == height - 1) { // Lower Edge
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrassLowerEdge);
				} else { // Central Grass
					terrain[x_start + i][y_start + j].interactableObjectList
							.add(InteractableObject.TallGrass);
				}
			}
		}
	}
	public void placeStructure(int x_start, int y_start, InteractableObject structure, boolean blockMovement){
		terrain[x_start][y_start].interactableObjectList.add(structure);
		//^add structure to map; Top left corder at (x_start,y_start)
		//"TerrainImages/PokeCenter"
		if(blockMovement){
			for(int i=0; i<structure.img.getWidth()/16; i++){
				for(int j=0; j<structure.img.getHeight()/16; j++){
					terrain[x_start+i][y_start+j].blockMovement();
				}
			}
		}
		switch (structure) {
		case PokeCenter:
			terrain[x_start+2][y_start+5].interactableObjectList.add(InteractableObject.HealingSpace);
			break;
		case PC:
			terrain[x_start][y_start+2].interactableObjectList.add(InteractableObject.PCexchange);
			break;
		default:
			break;
		}
	}

}
