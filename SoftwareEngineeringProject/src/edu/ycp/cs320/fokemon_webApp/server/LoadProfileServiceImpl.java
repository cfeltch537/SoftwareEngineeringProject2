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
package edu.ycp.cs320.fokemon_webApp.server;



import java.sql.SQLException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.fokemon_webApp.client.LoadProfileService;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;
import edu.ycp.cs320.fokemon_webApp.shared.Login.ColumnPlayer;



public class LoadProfileServiceImpl extends RemoteServiceServlet implements LoadProfileService {
	private static final long serialVersionUID = 1L;

	@Override
	public ColumnPlayer retrieveProfile(Login login) {
		
		try {
			return DBUtil.instance().retrieveProfile(login);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException", e);
		}		
	}

	
}