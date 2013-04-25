package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.dom.client.Touch;
import com.google.gwt.event.dom.client.GestureStartEvent;
import com.google.gwt.event.dom.client.GestureStartHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.TouchEndEvent;
import com.google.gwt.event.dom.client.TouchEndHandler;
import com.google.gwt.event.dom.client.TouchMoveEvent;
import com.google.gwt.event.dom.client.TouchMoveHandler;
import com.google.gwt.user.client.ui.Composite;

public class CirculatingImagesView extends Composite {
	static final String holderId = "canvasholder";
	Canvas canvasTemp;
	Canvas backBufferTemp;
	LogoGroup logoGroup;
	// mouse positions relative to canvas
	int mouseX, mouseY;

	// timer refresh rate, in milliseconds
	static final int refreshRate = 100;

	// canvas size, in px
	static final int heightTemp = 400;
	static final int widthTemp = 400;

	final CssColor redrawColor = CssColor.make("rgba(255,255,255,0.6)");
	Context2d contextTemp;
	Context2d backBufferContextTemp;

	public CirculatingImagesView() {

		canvasTemp = Canvas.createIfSupported();
		backBufferTemp = Canvas.createIfSupported();
		canvasTemp.setWidth(widthTemp + "px");
		canvasTemp.setHeight(heightTemp + "px");
		canvasTemp.setCoordinateSpaceWidth(widthTemp);
		canvasTemp.setCoordinateSpaceHeight(heightTemp);
		backBufferTemp.setCoordinateSpaceWidth(widthTemp);
		backBufferTemp.setCoordinateSpaceHeight(heightTemp);
		contextTemp = canvasTemp.getContext2d();
		backBufferContextTemp = backBufferTemp.getContext2d();

		// init the objects
		logoGroup = new LogoGroup(widthTemp, heightTemp, 18, 165);

		initHandlers();

		// setup timer
		// final Timer timer = new Timer() {
		// @Override
		// public void run() {
		// doUpdate();
		// }
		// };
		// timer.scheduleRepeating(refreshRate);
	}

	void doUpdate() {
		// update the back canvas
		backBufferContextTemp.setFillStyle(redrawColor);
		backBufferContextTemp.fillRect(0, 0, widthTemp, heightTemp);
		logoGroup.update(mouseX, mouseY);
		logoGroup.draw(backBufferContextTemp);
		// update the front canvas
		logoGroup.draw(backBufferContextTemp, contextTemp);

	}

	void initHandlers() {
		canvasTemp.addMouseMoveHandler(new MouseMoveHandler() {
			public void onMouseMove(MouseMoveEvent event) {
				mouseX = event.getRelativeX(canvasTemp.getElement());
				mouseY = event.getRelativeY(canvasTemp.getElement());
			}
		});

		canvasTemp.addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				mouseX = -200;
				mouseY = -200;
			}
		});

		canvasTemp.addTouchMoveHandler(new TouchMoveHandler() {
			public void onTouchMove(TouchMoveEvent event) {
				event.preventDefault();
				if (event.getTouches().length() > 0) {
					Touch touch = event.getTouches().get(0);
					mouseX = touch.getRelativeX(canvasTemp.getElement());
					mouseY = touch.getRelativeY(canvasTemp.getElement());
				}
				event.preventDefault();
			}
		});

		canvasTemp.addTouchEndHandler(new TouchEndHandler() {
			public void onTouchEnd(TouchEndEvent event) {
				event.preventDefault();
				mouseX = -200;
				mouseY = -200;
			}
		});

		canvasTemp.addGestureStartHandler(new GestureStartHandler() {
			public void onGestureStart(GestureStartEvent event) {
				event.preventDefault();
			}
		});
	}
}
