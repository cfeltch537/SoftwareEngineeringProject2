package edu.ycp.cs320.fokemon;

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
	
}
