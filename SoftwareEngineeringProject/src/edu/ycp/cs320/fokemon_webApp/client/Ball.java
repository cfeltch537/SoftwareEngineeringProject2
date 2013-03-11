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


import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;
import com.google.gwt.core.client.EntryPoint;
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
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.canvas.dom.client.CssColor;

public class Ball extends SpringObject {
  public CssColor color;
  public double posZ, velZ, goalZ;
  public double radius;
  public Vector startPos;
  public double startPosZ;
  public double startRadius;

  public Ball(Vector start, double startPosZ, double radius, CssColor color) {
    super(start);
    this.color = color;
    this.posZ = startPosZ;
    this.velZ = 0;
    this.goalZ = startPosZ;
    this.radius = radius;
    this.startPos = new Vector(start);
    this.startPosZ = startPosZ;
    this.startRadius = radius;
  }
  
  public Ball(double x, double y, double z, double radius, String color) {
    this(new Vector(x, y), z, radius, CssColor.make(color));
  }
  
  public void update() {
    super.update();
    
    Vector dh = Vector.sub(startPos, pos);
    double dist = dh.mag();
    goalZ = dist / 100.0 + 1.0;
    double dgZ = goalZ - posZ;
    double aZ = dgZ * springStrength;
    velZ += aZ;
    velZ *= friction;
    posZ += velZ;
    
    radius = startRadius * posZ;
    radius = radius < 1 ? 1 : radius;
  }
  
  public void draw(Context2d context) {
    context.setFillStyle(color);
    context.beginPath();
    context.arc(pos.x, pos.y, radius, 0, Math.PI * 2.0, true);
    context.closePath();
    context.fill();
  }
}