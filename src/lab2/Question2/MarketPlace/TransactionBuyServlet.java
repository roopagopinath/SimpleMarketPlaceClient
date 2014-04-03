package lab2.Question2.MarketPlace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TransactionBuy
 */
public class TransactionBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MarketPlaceProxy proxy;

	public void init() throws ServletException{

		proxy = new lab2.Question2.MarketPlace.MarketPlaceProxy();
		proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/MarketPlace?wsdl");


	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			Cookie loginCookie = null;
			Cookie[] cookies = request.getCookies();
			if(cookies != null){
				for(Cookie cookie : cookies){
					if(cookie.getName().equals("user")){
						loginCookie = cookie;
						break;
					}
				}
			}
			if(loginCookie != null){

			String[] msg = proxy.buy(loginCookie.getValue());
			if(msg == null){
				throw new IOException();
			}

			out.println("<html> <body bgcolor=\"#E6E6FA\">");
			out.println("<p align=\"right\" ><table><tr><td>Signed in User:</td><td>"+loginCookie.getValue() + "</td></tr></table></p>");
			out.println("<h3>Items Bought!!</h3> ");
			out.println("<br/>");
			request.getSession().setAttribute("count", msg.length);

			for(int i=0; i< msg.length; i++){
				String[] m = msg[i].split(":");
				
				String textToDisplay = m[1] + " : "+ m[2] + " Advertised by " + m[0] + ".<br/> Number of items bought is " + m[3] + " on " + m[5] + ":"+ m[6] + ":" + m[7].substring(0, 2) + "<br/><br/>";
				//Display transactions
				out.println((i+1) +". " + textToDisplay );

			}
			//Back to Transactions page
			out.println("<form action=\"Transactions.jsp\">");
			out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Transactions\">");
			out.println("</form><br/><br/>");

			//Back to options page
			out.println("<form action=\"Options.jsp\">");
			out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Options\">");
			out.println("</form><br/><br/>");
			
			//Signout
			out.println("<form action=\"SignOutServlet\" method=\"post\"><br/>");
			out.println("<input type=\"submit\" name=\"Sign Out\" value=\"Sign Out\">");
			out.println("</form><br/><br/>");

			out.println("</body> </html>");
			}
			else{
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUpIn.jsp");
				out.println("<font color=red>Sorry, Not a valid session. Try logging in again!</font>");
				rd.include(request, response);

			}
		}
		catch(IOException e){
			PrintWriter out = response.getWriter();
			out.println("<html><body bgcolor=\"#E6E6FA\">There are no items to show - No purchases");

			//Back to Transactions page
			out.println("<form action=\"Transactions.jsp\">");
			out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Transactions\">");
			out.println("</form><br/><br/>");
			
			out.println("<form action=\"Options.jsp\"><br/>");
			out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Options\">");
			out.println("</form><br/><br/>");


			out.println("<form action=\"SignOutServlet\" method=\"post\"><br/>");
			out.println("<input type=\"submit\" name=\"Sign Out\" value=\"Sign Out\">");
			out.println("</form><br/><br/>");

			out.println("</body></html>");

		}
	}

}
