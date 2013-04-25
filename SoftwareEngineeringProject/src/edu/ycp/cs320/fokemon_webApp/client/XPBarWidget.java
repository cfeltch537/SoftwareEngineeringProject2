
package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class XPBarWidget extends Composite{

	public Canvas xpBarCanvas;
	Canvas xpBarCanvasBackBuffer;
	Context2d xpBarContext;
	Context2d xpBarBackBufferContext;
	Double pokemonMaxXP;
	Double pokemonXP;

	int xpBarWidth = 123; //Pixels
	Double xpRatio;
	ImageElement xpEmpty, xpFull;
	
	public XPBarWidget(){
		//Create Canvases
		xpBarCanvas = Canvas.createIfSupported();
		xpBarCanvasBackBuffer = Canvas.createIfSupported();
		//Set Canvas Dimensions
	    xpBarCanvas.setWidth((xpBarWidth) + "px");
	    xpBarCanvas.setHeight(4 + "px");
	    xpBarCanvas.setCoordinateSpaceWidth((xpBarWidth));
	    xpBarCanvas.setCoordinateSpaceHeight((4)); 
	    xpBarCanvasBackBuffer.setWidth((xpBarWidth) + "px");
	    xpBarCanvasBackBuffer.setHeight(4 + "px");
	    xpBarCanvasBackBuffer.setCoordinateSpaceWidth((xpBarWidth));
	    xpBarCanvasBackBuffer.setCoordinateSpaceHeight((4)); 
	    //Set Context
	    xpBarContext = xpBarCanvas.getContext2d();
	    xpBarBackBufferContext = xpBarCanvasBackBuffer.getContext2d();
		//Set Bar Images
	    xpEmpty = (ImageElement) new Image("hpBars/xpBar_Empty.png").getElement().cast();
	    xpFull = (ImageElement) new Image("hpBars/xpBar_Full.png").getElement().cast();
	    //Add Widget to Panel
	    
	}
	
	void doUpdate(Double Pokemonxp, Double PokemonMaxXP) {
		   // update the back canvas, set to fron canvas
		this.pokemonXP = Pokemonxp;
		this.pokemonMaxXP = PokemonMaxXP;
		draw(xpBarBackBufferContext, xpBarContext);  
	}
	
	public void draw(Context2d context, Context2d front) {
		    
		 context.clearRect(0, 0, xpBarWidth, 4);
			// Draw Players xp Bar
			context.drawImage(xpEmpty,0,0);
			if(pokemonXP!=0){
			xpRatio = pokemonXP/pokemonMaxXP;
			context.drawImage(
					xpFull, // image
					0.0, //sx
					0.0, //sy
					xpBarWidth*xpRatio, //sw
					4.0, //sh
					0, //dx
					0, //dy
					xpBarWidth*xpRatio, //dw
					4.0); //dh
			
		}
		context.restore();
		front.drawImage(context.getCanvas(),0,0);
	}
}



