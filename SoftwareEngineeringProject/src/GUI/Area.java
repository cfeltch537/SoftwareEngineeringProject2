package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Area {
	int HEIGHT = 30;
	int WIDTH = 60;
	
	Terrain[][] terrain = new Terrain[WIDTH][HEIGHT];
	
	public Area(){
		for(int width = 0; width<WIDTH; width++){
			for(int height = 0; height<HEIGHT; height++){
				if(width<40){
					terrain[width][height]= new Terrain(Flooring.Grass, null);
				}else if(width<45){
					terrain[width][height]= new Terrain(Flooring.Sand, null);
				}else{
					terrain[width][height]= new Terrain(Flooring.SaltWater, null);
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
		//^add structure to map; Top left corder at (x_start,y_start)
		BufferedImage bimg;
		int pixelWidth=0;
		int pixelHeight=0;
		try {
			bimg = ImageIO.read(new File(structure.imageSource));
			pixelWidth = bimg.getWidth();
			pixelHeight = bimg.getHeight();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//^Defines the height and width of the structure; in pixels
		for(int i=0; i<pixelWidth/16; i++){
			for(int j=0; j<pixelHeight/16; j++){
				terrain[x_start+i][y_start+j].blockMovement();
			}
		}
	}
	
}

