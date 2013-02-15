package edu.ycp.cs320.fokemon;

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

public class TempMapPanel extends JPanel {
	
	Area area1 = new Area();
	public int[][] map = new int[40][20];
	public static Integer playerX = 20;
	public static Integer playerY = 10;
	public static Integer step_count = 0;
		
	Graphics g = this.getGraphics();
	Image img;
	
	public TempMapPanel(){
			
	        Dimension size = new Dimension(25*map.length, 25*map[0].length);
	        setPreferredSize(size);
	        setMinimumSize(size);
	        setMaximumSize(size);
	        setSize(size);
	        setLayout(null);
	        
	        
	       
//	        for (int i = 0; i < map.length; i++) {
//	            for (int j = 0; j < map[0].length; j++) {
//	               
////	            	if(i+j<37){    
////	            	map[i][j] = 1; //Grass
////	                }else if(i+j<39){
////		                map[i][j] = 0;//Dirt
////		            }else if(i+j<42){
////		                map[i][j] = 2;//Sand
////		            }else if(i+j>=42){
////	                map[i][j] = 3;//Water
////	                }
//	                
//	                if(i<30){    
//	            	map[i][j] = 1; //Grass
//	                }else if(i<32){
//		                map[i][j] = 0;//Dirt
//		            }else if(i<35){
//		                map[i][j] = 2;//Sand
//		            }else if(i>=35){
//	                map[i][j] = 3;//Water
//	                }
//	            }
//	        }
	        
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
        
		//LAYER !
		for (int height = 0; height < area1.terrain.length; height++) {
            for (int width = 0; width < area1.terrain[height].length; width++) {
            	img = area1.terrain[height][width].getFlooringImage();
            	g.drawImage(img, 16*height, 16*width, null);
            	//g.draw3DRect(25*i, 25*j, 25, 25, true);
            }
        }
        for (int height = 0; height < area1.terrain.length; height++) {
            for (int width = 0; width < area1.terrain[height].length; width++) {
            	
            	if(height==playerX&&width==playerY){
            		if(step_count==0){
            			img = new ImageIcon(".\\src\\16x16_TerrainImages/Dawn_LeftFootForeward.png").getImage();
            		}else if(step_count==1){
            			img = new ImageIcon(".\\src\\16x16_TerrainImages/Dawn_RightFootForeward.png").getImage();
            		}else if(step_count==2){
            			img = new ImageIcon(".\\src\\16x16_TerrainImages/Dawn_LeftFootForeward.png").getImage();
            		}else if(step_count==3){
            			img = new ImageIcon(".\\src\\16x16_TerrainImages/Dawn_RightFootForeward.png").getImage();
            		}else if(step_count==4){
            			img = new ImageIcon(".\\src\\16x16_TerrainImages/Dawn_StandingForeward.png").getImage();
            		}
            		
            		g.draw3DRect(16*playerX, 16*playerY+2*step_count, 21, 25, true);
            		g.drawImage(img, 16*playerX, 16*playerY-10+2*step_count, null);
	
                	if(step_count!=4){
                    	step_count++;
                    }
            	}
            }
        }
    		
	}
	public void MovePlayer(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
	            //Right arrow key code
	    	TempMapPanel.playerX++;
	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
	            //Left arrow key code
	    	TempMapPanel.playerX--;
	    } else if (e.getKeyCode() == KeyEvent.VK_UP ) {
	            //Up arrow key code
	    	TempMapPanel.playerY--;
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
	            //Down arrow key code
	    	step_count = 0;
	    	TempMapPanel.playerY++;
	    }
	   // repaint();
	}
	
}


