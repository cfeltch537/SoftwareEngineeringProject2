/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package edu.ycp.cs320.fokemon_webApp.client;

import com.google.gwt.canvas.dom.client.CanvasPixelArray;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.ImageData;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;

public class LogoGroup {
	final double width;
	final double height;
	final int numLogos;
	final double radius;
	Image logoImg;
	Logo[] logos;
	boolean imageLoaded;

	double k;

	public LogoGroup(double width, double height, int numLogos, double radius) {
		this.width = width;
		this.height = height;
		this.numLogos = numLogos;
		this.radius = radius;

		// init logos array
		logos = new Logo[numLogos];

		// init image
		logoImg = new Image("23x25_Trainer_Front.png");
		logoImg.addLoadHandler(new LoadHandler() {
			public void onLoad(LoadEvent event) {
				imageLoaded = true;
				// once image is loaded, init logo objects
				ImageElement imageElement = (ImageElement) logoImg.getElement()
						.cast();
				for (int i = logos.length - 1; i >= 0; i--) {
					Logo logo = new Logo(imageElement);
					logo.pos.x = LogoGroup.this.width / 2;
					logo.pos.y = LogoGroup.this.height / 2;
					logos[i] = logo;
				}
			}
		});
		logoImg.setVisible(false);
		RootPanel.get().add(logoImg); // image must be on page to fire load
	}

	public void update(double mouseX, double mouseY) {
		if (!imageLoaded) {
			return;
		}

		k = (k + Math.PI / 2.0 * 0.009);

		for (int i = numLogos - 1; i >= 0; i--) {
			Logo logo = logos[i];
			double logoPerTPi = 2 * Math.PI * i / numLogos;
			Vector goal = new Vector(width / 2 + radius
					* Math.cos(k + logoPerTPi), height / 2 + radius
					* Math.sin(k + logoPerTPi));
			logo.goal.set(goal);
			logo.rot = k + logoPerTPi + Math.PI / 2.0;

			Vector d = new Vector(mouseX, mouseY);
			d.sub(logo.pos);
			if (d.magSquared() < 50 * 50) {
				logo.goal = Vector.sub(logo.pos, d);
			}

			logo.update();
		}
	}

	public void draw(Context2d context) {
		if (!imageLoaded) {
			return;
		}

		for (int i = numLogos - 1; i >= 0; i--) {
			logos[i].draw(context);
		}
	}

	public void draw(Context2d back, Context2d front) {
		front.drawImage(back.getCanvas(), 0, 0);
	}
}