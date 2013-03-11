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

public class SpringObject {
  public static final double springStrength = 0.1;
  public static final double friction = 0.8;
  public Vector pos, vel, goal;
  
  public SpringObject(Vector start) {
    this.pos = new Vector(start);
    this.vel = new Vector(0, 0);
    this.goal = new Vector(start);
  }
  
  public void update() {
    Vector d = Vector.sub(goal, pos);
    d.mult(springStrength);
    vel.add(d);
    vel.mult(friction);
    pos.add(vel);
  }
}