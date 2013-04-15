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

import edu.ycp.cs320.fokemon_webApp.client.LoginService;
import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;




public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
	private static final long serialVersionUID = 1L;

	@Override
	public Login submitLogin(Login _login) {
		
		try {
			return DBUtil.instance().performLogin(_login);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException", e);
		}
		
//		_login.setId(0);
//		//TODO: Get check the login database for the username password combo and return the key integer
//		return _login;
	}

}