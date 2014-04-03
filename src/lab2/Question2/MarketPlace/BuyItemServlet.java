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
 * Servlet implementation class BuyItemServlet
 */
public class BuyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			out.println("<html> <body bgcolor=\"#E6E6FA\">");
			out.println("<p align=\"right\" ><table><tr><td>Signed in User:</td><td>"+loginCookie.getValue() + "</td></tr></table></p>");
			out.println("<h3>");
			out.println("Dear " + loginCookie.getValue() + " : You are about to pay $"+request.getSession().getAttribute("priceFinal"));
			out.println("</h3>");
			out.println("<br/><form action=\"BuyItemsFinal\" method=\"post\"> Enter Credit Card number <br/><br/>");
			out.println("<input type=\"text\" maxlength=16 pattern=\".{16,16}\" name=\"credit_card_num\"> (Need 16 digit CC Number)");

			out.println("<br/><input type=\"submit\" value=\"Confirm Buying\">");
			out.println("</form><br/><br/>");

			//Back to Ads page
			out.println("<form action=\"DisplayAdServlet\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"Back to Ads\">");
			out.println("</form><br/><br/>");
			
			//Option To sign out
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

}
