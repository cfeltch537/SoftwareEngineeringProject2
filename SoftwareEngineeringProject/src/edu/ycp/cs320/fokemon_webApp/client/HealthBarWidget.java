package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;

public class HealthBarWidget extends Composite {

	public Canvas hpBarCanvas;
	Canvas hpBarCanvasBackBuffer;
	Context2d hpBarContext;
	Context2d hpBarBackBufferContext;
	Double PokemonMaxHP;
	Double PokemonHP;

	int hpBarWidth = 123; // Pixels
	Double hpRatio;
	ImageElement hpEmpty, hpGreen, hpYellow, hpOrange, hpRed;

	public HealthBarWidget() {
		// Create Canvases
		hpBarCanvas = Canvas.createIfSupported();
		hpBarCanvasBackBuffer = Canvas.createIfSupported();
		// Set Canvas Dimensions
		hpBarCanvas.setWidth((hpBarWidth) + "px");
		hpBarCanvas.setHeight(12 + "px");
		hpBarCanvas.setCoordinateSpaceWidth((hpBarWidth));
		hpBarCanvas.setCoordinateSpaceHeight((12));
		hpBarCanvasBackBuffer.setWidth((hpBarWidth) + "px");
		hpBarCanvasBackBuffer.setHeight(12 + "px");
		hpBarCanvasBackBuffer.setCoordinateSpaceWidth((hpBarWidth));
		hpBarCanvasBackBuffer.setCoordinateSpaceHeight((12));
		// Set Context
		hpBarContext = hpBarCanvas.getContext2d();
		hpBarBackBufferContext = hpBarCanvasBackBuffer.getContext2d();
		// Set Bar Images
		hpEmpty = (ImageElement) new Image("hpBars/hpBar_Empty.png")
				.getElement().cast();
		hpGreen = (ImageElement) new Image("hpBars/hpBar_Green.png")
				.getElement().cast();
		hpYellow = (ImageElement) new Image("hpBars/hpBar_Yellow.png")
				.getElement().cast();
		hpOrange = (ImageElement) new Image("hpBars/hpBar_Orange.png")
				.getElement().cast();
		hpRed = (ImageElement) new Image("hpBars/hpBar_Red.png").getElement()
				.cast();
		// Add Widget to Panel

	}

	void doUpdate(Double PokemonHP, Double PokemonMaxHP) {
		// update the back canvas, set to fron canvas
		this.PokemonHP = PokemonHP;
		this.PokemonMaxHP = PokemonMaxHP;
		draw(hpBarBackBufferContext, hpBarContext);
	}

	public void draw(Context2d context, Context2d front) {

		context.clearRect(0, 0, hpBarWidth, 12);
		// Draw Players HP Bar
		context.drawImage(hpEmpty, 0, 0);
		if (PokemonHP != 0) {
			hpRatio = PokemonHP / PokemonMaxHP;
			if (hpRatio >= 0.75) { // Green Bar
				context.drawImage(hpGreen, // image
						0.0, // sx
						0.0, // sy
						hpBarWidth * hpRatio, // sw
						12.0, // sh
						0, // dx
						0, // dy
						hpBarWidth * hpRatio, // dw
						12.0); // dh
			} else if (hpRatio >= 0.50) { // Yellow Bar
				context.drawImage(hpYellow, // image
						0.0, // sx
						0.0, // sy
						hpBarWidth * hpRatio, // sw
						12.0, // sh
						0, // dx
						0, // dy
						hpBarWidth * hpRatio, // dw
						12.0); // dh
			} else if (hpRatio >= 0.25) { // Orange Bar
				context.drawImage(hpOrange, // image
						0.0, // sx
						0.0, // sy
						hpBarWidth * hpRatio, // sw
						12.0, // sh
						0, // dx
						0, // dy
						hpBarWidth * hpRatio, // dw
						12.0); // dh
			} else if (hpRatio >= 0) { // Red Bar
				context.drawImage(hpRed, // image
						0.0, // sx
						0.0, // sy
						hpBarWidth * hpRatio, // sw
						12.0, // sh
						0, // dx
						0, // dy
						hpBarWidth * hpRatio, // dw
						12.0); // dh
			}
		}
		context.restore();
		front.drawImage(context.getCanvas(), 0, 0);
	}
}
