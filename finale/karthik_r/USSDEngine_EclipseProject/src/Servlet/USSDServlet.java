package Servlet;




import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import USSDEngine.*;


@SuppressWarnings("serial")
public class USSDServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/plain");
		PrintWriter pw = response.getWriter();
		String phoneNo = request.getParameter("mobile_no");
		String session = request.getParameter("session_id");
		String userInput = request.getParameter("user_input");
		
		
		// The USSD Class handles all requests
		USSD newUssd = new USSD();
		String resp;
		if(userInput.equals("")) {
		//This is a new user. Hence start a new entry for him in the Hashmap. 
		//Send him level0
		//Save in the hashmap that he has reached level0
			resp = newUssd.startModule(session,phoneNo);
			pw.println(resp);
			
		}
		else {
		//This user has reached a state. hence hashmap will have his current state info
		//Send the session, phoneNo so that his current state can be fetched from the hashmap
		//based on his current state, the response is fetched from the Service
			resp = newUssd.getResponse(userInput, session, phoneNo);
			pw.println(resp);
		}
		
	}
}