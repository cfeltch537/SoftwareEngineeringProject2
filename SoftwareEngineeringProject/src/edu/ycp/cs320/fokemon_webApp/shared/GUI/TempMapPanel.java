
//
//package edu.ycp.cs320.fokemon_webApp.shared.GUI;
//
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//import java.awt.image.BufferedImage;
//import java.awt.image.ImageObserver;
//import java.io.File;
//import java.io.IOException;
//import java.util.LinkedList;
//import com.google.gwt.user.client.ui.Image;
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JPanel;
//
//import edu.ycp.cs320.fokemon_webApp.shared.player.Location;
//import edu.ycp.cs320.fokemon_webApp.shared.player.Player;
//
//public class TempMapPanel extends JPanel {
//	
//	Area[] areaList = new Area[2];
//	Player player = new Player(00004, "Cody", true, new Location(0, 10, 10)); // Player Cody
//	public static boolean allowMove = false;		 // Boolean used to 
//	public static Integer step_count = 0;
//		
//	Graphics g = this.getGraphics();
//	Image img;
//	
//	public TempMapPanel(){
//			
//			areaList[0] = new Area();
//			areaList[0].createTallGrassSquare(5, 5, 10, 4);
//			areaList[0].createTallGrassSquare(5, 10, 10, 4);
//			areaList[0].createTallGrassSquare(5, 15, 10, 4);
//			areaList[0].placeStructure(25, 10, InteractableObject.PokeCenter);
//			areaList[1] = new Area();
//	        Dimension size = new Dimension(16*areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain.length, 16*areaList[player.getPlayerLocation().getAreaArrayIndex()].terrain[0].length);
//	        setPreferredSize(size);
//	        setMinimumSize(size);
//	        setMaximumSize(size);
//	        setSize(size);
//	        setLayout(null);
//	        
//	        this.addKeyListener(new KeyListener() {
//
//                @Override
//                public void keyTyped(KeyEvent e) {}
//
//                @Override
//                public void keyReleased(KeyEvent e) {}
//
//                @Override
//                public void keyPressed(KeyEvent e) {
//                	MovePlayer(e);
//                }
//            });
//
//	}
//	
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
//	
//}
//
//
//

