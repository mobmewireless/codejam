


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
		
		USSD newUssd = new USSD();
		String resp;
		if(userInput.equals("")) {
			resp = newUssd.startModule(session,phoneNo);
			pw.println(resp);
			
		}
		else {
			resp = newUssd.getResponse(userInput, session, phoneNo);
			pw.println(resp);
		}
		/*pw.println("<html>");
		pw.println("<head><title>Hello World</title></title>");
		pw.println("<body>");
		pw.println("<h1>Hello World</h1>");
		pw.println("</body></html>");
		*/
	}
}
