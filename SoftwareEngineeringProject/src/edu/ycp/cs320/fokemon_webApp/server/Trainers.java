package edu.ycp.cs320.fokemon_webApp.server;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.fokemon_webApp.shared.Login.Login;
import edu.ycp.cs320.fokemon_webApp.shared.Player.Player;


/**
 * Web service for accessing order receipts.
 */
public class Trainers extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// The path info is the part of the URL that follows the
		// part identifying the servlet.  For example, if the
		// URL was http://hostname/receipts/42, and assuming that
		// "/receipts" is the path to the servlet, the path info
		// would be "/42".
		Player trainer = new Player();
		String info = req.getPathInfo();
		System.out.println("Path info is: " + info);

		// TODO: handle the request

		try {
			trainer = DBUtil.instance().retrieveTrainer(info);
		} catch (SQLException e) {
			throw new RuntimeException("SQLException", e);
		}	


		// TODO: write the response body with data from the database
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.getWriter().println("Trainer Name: " + trainer.getName() + "\nTrainer ID: " + trainer.getPlayerID() + "\nTeam Size: " + trainer.getTeamSize() +"\nTrainer PC Size: "+ trainer.getPC().size() + "\nTrainer Gender: " + trainer.getGender());
	}
}