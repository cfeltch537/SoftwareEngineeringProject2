package GUI;


public class Area {
	int HEIGHT = 30;
	int WIDTH = 60;
	
	Terrain[][] terrain = new Terrain[WIDTH][HEIGHT];
	
	public Area(){ //
		for(int width = 0; width<WIDTH; width++){
			for(int height = 0; height<HEIGHT; height++){
				if(width<40){
					terrain[width][height]= new Terrain(Flooring.Grass, null);
				}else if(width<45){
					terrain[width][height]= new Terrain(Flooring.Sand, null);
				}else{
					terrain[width][height]= new Terrain(Flooring.Sand, new InteractableObject[]{InteractableObject.SaltWater});
				}
			}
		}
	}	
	
	public void createTallGrassSquare(int x_start, int y_start, int width, int height){
		for(int i=0; i<width; i++){
			for(int j=0; j<height; j++){
				if(i==0&&j==0){ //Upper Left Corner
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassUpperLeftEdge);
				}else if(i==width-1&&j==height-1){ // Lower Right Corner
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassLowerRightEdge);
				}else if(i==0&&j==height-1){ // Lower Left Corner
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassLowerLeftEdge);
				}else if(i==width-1&&j==0){ // Upper Right Corner Corner
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassUpperRightEdge);
				}else if(i==0){ //Left Edge
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassLeftEdge);
				}else if(j==0){ // Upper Edge
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassUpperEdge);
				}else if(i==width-1){ // Right Edge
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassRightEdge);
				}else if(j==height-1){ // Lower Edge
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrassLowerEdge);
				}else{ // Central Grass
					terrain[x_start+i][y_start+j].interactableObjectList.add(InteractableObject.TallGrass);
				}
			}
		}
	}
	public void placeStructure(int x_start, int y_start, InteractableObject structure){
		terrain[x_start][y_start].interactableObjectList.add(structure);
	}
	
}

