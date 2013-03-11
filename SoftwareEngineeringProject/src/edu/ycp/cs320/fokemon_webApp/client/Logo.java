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

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;

public class Logo extends SpringObject {
  ImageElement image;
  double rot;

  Logo(ImageElement image) {
    super(new Vector(0,0));
    this.image = image;
    this.rot = 0;
  }
  
  void draw(Context2d context) {
    context.save();
    context.translate(this.pos.x, this.pos.y);
    context.rotate(rot);
    context.drawImage(image, 0, 0);
    context.restore();
  }
}