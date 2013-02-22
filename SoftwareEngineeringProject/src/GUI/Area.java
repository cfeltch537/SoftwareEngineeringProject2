package GUI;

import edu.ycp.cs320.fokemon.Terrain;

public class Area {
	int HEIGHT = 30;
	int WIDTH = 60;
	
	Terrain[][] terrain = new Terrain[WIDTH][HEIGHT];
	
	public Area(){ //
		for(int width = 0; width<WIDTH; width++){
			for(int height = 0; height<HEIGHT; height++){
				
				if(width==0||height==0||width==WIDTH||height==HEIGHT){
					terrain[width][height]= new Terrain(Flooring.Grass, null, null, null, null, null);
				}else{
					terrain[width][height]= new Terrain(Flooring.Grass, null, null, null, null, null);
				}
			}
		}
	}	
	
	public void createTallGrassSquare(int x_start, int y_start, int width, int height){
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				if(i==0&&j==0){ //Upper Left Corner
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassUpperLeftEdge, Interaction.Battle_Wild);
				}else if(i==width-1&&j==height-1){ // Lower Right Corner
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassLowerRightEdge, Interaction.Battle_Wild);
				}else if(i==0&&j==height-1){ // Lower Left Corner
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassLowerLeftEdge, Interaction.Battle_Wild);
				}else if(i==width-1&&j==0){ // Upper Right Corner Corner
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassUpperRightEdge, Interaction.Battle_Wild);
				}else if(i==0){ //Left Edge
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassLeftEdge, Interaction.Battle_Wild);
				}else if(j==0){ // Upper Edge
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassUpperEdge, Interaction.Battle_Wild);
				}else if(i==width-1){ // Right Edge
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassRightEdge, Interaction.Battle_Wild);
				}else if(j==height-1){ // Lower Edge
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrassLowerEdge, Interaction.Battle_Wild);
				}else{ // Central Grass
					terrain[x_start+i][y_start+j].interactableObject = new InteractableObject(InteractableObjectName.TallGrass, Interaction.Battle_Wild);
				}
			}
		}
	}
	
	
}

