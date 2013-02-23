package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import edu.ycp.cs320.fokemon.Location;
import edu.ycp.cs320.fokemon.Player;

public class TempMapPanel extends JPanel {
	
	Area area1 = new Area(); // For now only one area will exist
	Player player = new Player(00004, "Cody", true, new Location(0, 20, 10)); // Player Cody
	public static boolean allowMove = false;		 // Boolean used to 
	public int[][] map = new int[40][20];
	public static Integer step_count = 0;
		
	Graphics g = this.getGraphics();
	Image img;
	
	public TempMapPanel(){
			
			area1.createTallGrassSquare(5, 5, 10, 10);
	        Dimension size = new Dimension(25*map.length, 25*map[0].length);
	        setPreferredSize(size);
	        setMinimumSize(size);
	        setMaximumSize(size);
	        setSize(size);
	        setLayout(null);
	        
	        this.addKeyListener(new KeyListener() {

                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyReleased(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                	MovePlayer(e);
                }
            });

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		// Paint the window background
		g.setColor(Color.BLACK); // Draws outline of shape as mouse moves
        
		//Flooring Layer
		for (int height = 0; height < area1.terrain.length; height++) {
            for (int width = 0; width < area1.terrain[height].length; width++) {
            	if(area1.terrain[height][width].flooring.img!=null){
            	img = area1.terrain[height][width].flooring.img;
            	g.drawImage(img, 16*height, 16*width, null);
            	//g.draw3DRect(16*i, 16*j, 16, 16, true);
            	}
            }
        }
		//InteractableObjects
		for (int height = 0; height < area1.terrain.length; height++) {
            for (int width = 0; width < area1.terrain[height].length; width++) {
            //^Iterate through each terrain in the area
            	for(int objectIndex = 0; objectIndex<area1.terrain[height][width].interactableObjectList.size(); objectIndex++){
	            	if(area1.terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
	            		if(area1.terrain[height][width].interactableObjectList.get(objectIndex).img!=null){
	            		img = area1.terrain[height][width].interactableObjectList.get(objectIndex).img;
		            	g.drawImage(img, 16*height, 16*width, null);
		            	//g.draw3DRect(25*i, 25*j, 25, 25, true);
	            		}
	            	}	
            	}	
            }
        }
		//Player
        for (int height = 0; height < area1.terrain.length; height++) {
            for (int width = 0; width < area1.terrain[height].length; width++) {
            	
            	if(height==player.getPlayerLocation().getX()&&width==player.getPlayerLocation().getY()){
            		if(step_count==0){
            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_LeftFootForeward.png").getImage();
            		}else if(step_count==1){
            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_RightFootForeward.png").getImage();
            		}else if(step_count==2){
            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_LeftFootForeward.png").getImage();
            		}else if(step_count==3){
            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_RightFootForeward.png").getImage();
            		}else if(step_count==4){
            			img = new ImageIcon(".\\src\\TerrainImages/Dawn_StandingForeward.png").getImage();
            		}
            		
            		g.draw3DRect(16*player.getPlayerLocation().getX(), 16*player.getPlayerLocation().getY()+2*step_count, 21, 25, true);
            		g.drawImage(img, 16*player.getPlayerLocation().getX(), 16*player.getPlayerLocation().getY()-10+2*step_count, null);
	
                	if(step_count!=4){
                    	step_count++;
                    }
            	}
            }
        }
    		
	}
	public void MovePlayer(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT&&allowMove) {
		            //Right arrow key code
		    	player.getPlayerLocation().setX(player.getPlayerLocation().getX()+1);
		    } else if (e.getKeyCode() == KeyEvent.VK_LEFT&&allowMove) {
		            //Left arrow key code
		    	player.getPlayerLocation().setX(player.getPlayerLocation().getX()-1);
		    } else if (e.getKeyCode() == KeyEvent.VK_UP&&allowMove) {
		            //Up arrow key code
		    	player.getPlayerLocation().setY(player.getPlayerLocation().getY()-1);
		    } else if (e.getKeyCode() == KeyEvent.VK_DOWN&&allowMove) {
		            //Down arrow key code
		    	step_count = 0;
		    	player.getPlayerLocation().setY(player.getPlayerLocation().getY()+1);
		    }
			allowMove=false;
	}
	
}


