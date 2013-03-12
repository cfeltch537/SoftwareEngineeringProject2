
package edu.ycp.cs320.fokemon_webApp.client;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Image;
import javax.imageio.ImageIO;


import edu.ycp.cs320.fokemon_webApp.shared.GUI.Area;
import edu.ycp.cs320.fokemon_webApp.shared.player.Location;
import edu.ycp.cs320.fokemon_webApp.shared.player.Player;

public class CanvasImage{
	
	Area[] areaList;
	Player player;
	Image img;
	
	public CanvasImage(){
		areaList = edu.ycp.cs320.fokemon_webApp.client.FokemonUI.areaList;
		player = edu.ycp.cs320.fokemon_webApp.client.FokemonUI.player;
	}
	
	public void update(){
	    
	}
	
	public void draw(Context2d context, Context2d front) {
		    
		 context.save();
		 
		 //DrawFlooring
		 for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
	            for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
	            	if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img!=null){
	            	img = areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img;
	            	context.drawImage((ImageElement) img.getElement().cast(), 16*height, 16*width);

	            	}
	            }
	        }
		 
		//InteractableObjects
		for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
            for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
            //^Iterate through each terrain in the area
            	for(int objectIndex = 0; objectIndex<areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.size(); objectIndex++){
	            	if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
	            		if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
	            		img = areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img;
		            	context.drawImage((ImageElement) img.getElement().cast(), 16*height, 16*width);
	            		}
	            	}	
            	}	
            }
        }
		//Player
      for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
          for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
        	  if(height==player.getPlayerLocation().getX()&&width==player.getPlayerLocation().getY()){
        		img = new Image ("23x25_Trainer_Front.png");
          		if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()].isTallGrassPresent()){
          			img.setVisibleRect(0, 0, img.getWidth(), img.getHeight()/2);
          			context.drawImage((ImageElement) img.getElement().cast(), 16*player.getPlayerLocation().getX()-3, 16*player.getPlayerLocation().getY()-15+2);
          		}else{
	            	context.drawImage((ImageElement) img.getElement().cast(), 16*player.getPlayerLocation().getX()-3, 16*player.getPlayerLocation().getY()-15+2);
          		}
        	  }
//              	if(player.getPlayerLocation().getX()==0&&player.getPlayerLocation().getY()==0){
//              		player.getPlayerLocation().setAreaArrayIndex(player.getPlayerLocation().getAreaArrayIndex()+1);
//              		player.getPlayerLocation().setX(20);
//              	}
              	
          	}
          }
		
		
		
		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}
	
//	public void paint(Graphics g) {
//		super.paint(g);
//		// Paint the window background
//		g.setColor(Color.BLACK); // Draws outline of shape as mouse moves
//        
//		//Flooring Layer
//		for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
//            for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
//            	if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img!=null){
//            	img = areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].flooring.img;
//            	g.drawImage(img, 16*height, 16*width, null);
//            	//g.draw3DRect(16*i, 16*j, 16, 16, true);
//            	}
//            }
//        }
//		//InteractableObjects
//		for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
//            for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
//            //^Iterate through each terrain in the area
//            	for(int objectIndex = 0; objectIndex<areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.size(); objectIndex++){
//	            	if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
//	            		if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
//	            		img = areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height][width].interactableObjectList.get(objectIndex).img;
//		            	g.drawImage(img, 16*height, 16*width, null);
//		            	//g.draw3DRect(25*i, 25*j, 25, 25, true);
//	            		}
//	            	}	
//            	}	
//            }
//        }
//		//Player
//        for (int height = 0; height < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length; height++) {
//            for (int width = 0; width < areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[height].length; width++) {
//            	
//            	if(height==player.getPlayerLocation().getX()&&width==player.getPlayerLocation().getY()){
//            		if(step_count==0){
//            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_LeftFootForeward.png").getImage();
//            		}else if(step_count==1){
//            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_RightFootForeward.png").getImage();
//            		}else if(step_count==2){
//            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_LeftFootForeward.png").getImage();
//            		}else if(step_count==3){
//            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_RightFootForeward.png").getImage();
//            		}else if(step_count==4){
//            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_StandingForeward.png").getImage();
//            		}
//            		if(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()].isTallGrassPresent()){
//            			g.drawImage(img,
//            				       16*player.getPlayerLocation().getX()-3,
//            				       16*player.getPlayerLocation().getY()-7,
//            				       16*player.getPlayerLocation().getX()+22-3,
//            				       16*player.getPlayerLocation().getY()+19-7,
//            				       0, 0, 22, 19, new ImageObserver() {
//									@Override
//									public boolean imageUpdate(Image arg0, int arg1, int arg2, int arg3,int arg4, int arg5) {
//										// TODO Auto-generated method stub...Nah
//										return false;
//									}
//								});
//            		}else{
//            		g.drawImage(img, 16*player.getPlayerLocation().getX()-3, 16*player.getPlayerLocation().getY()-15+2*step_count, null);
//            		}
//            		//g.draw3DRect(16*player.getPlayerLocation().getX(), 16*player.getPlayerLocation().getY()+2*step_count, 21, 25, true);
//	
//                	if(step_count!=4){
//                    	step_count++;
//                    }
//                	if(player.getPlayerLocation().getX()==0&&player.getPlayerLocation().getY()==0){
//                		player.getPlayerLocation().setAreaArrayIndex(player.getPlayerLocation().getAreaArrayIndex()+1);
//                		player.getPlayerLocation().setX(20);
//                	}
//                	
//            	}
//            }
//        }
//    		
//	}
//	public void MovePlayer(KeyEvent e) {
//		if (e.getKeyCode() == KeyEvent.VK_RIGHT&&allowMove&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()+1][player.getPlayerLocation().getY()].isMovable()) {
//	            //Right arrow key code
//	    	player.getPlayerLocation().setX(player.getPlayerLocation().getX()+1);
//	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT&&allowMove&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()-1][player.getPlayerLocation().getY()].isMovable()) {
//	            //Left arrow key code
//	    	player.getPlayerLocation().setX(player.getPlayerLocation().getX()-1);
//	    } else if (e.getKeyCode() == KeyEvent.VK_UP&&allowMove&&areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()-1].isMovable()) {
//	            //Up arrow key code
//	    	player.getPlayerLocation().setY(player.getPlayerLocation().getY()-1);
//	    } else if ((e.getKeyCode() == KeyEvent.VK_DOWN&&allowMove)
//		    		&&(areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[player.getPlayerLocation().getX()][player.getPlayerLocation().getY()+1].isMovable())){
//	            //Down arrow key code
//	    	step_count = 0;
//	    	player.getPlayerLocation().setY(player.getPlayerLocation().getY()+1);
//	    }
//		allowMove=false;
//	}
	
}



