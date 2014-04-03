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
 * Servlet implementation class viewCartServlet
 */
public class ViewCartServlet extends HttpServlet {
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
				
        float priceFinal = 0;
		String[] msg = proxy.viewCart(loginCookie.getValue());
		out.println("<html> <body bgcolor=\"#E6E6FA\">");
		out.println("<p align=\"right\" ><table><tr><td>Signed in User:</td><td>"+loginCookie.getValue() + "</td></tr></table></p>");
		out.println("Shopping Cart!! ");
		out.println("<br/><br/>");

		if(msg == null)
		{
			out.println("Your shopping cart is empty !!! ");
		}
		else {
			request.getSession().setAttribute("count", msg.length);

			out.println("Items in your shopping cart! ");
			out.println("<br/><br/>");

			for(int i=0; i< msg.length; i++)
			{
				String[] m = msg[i].split(":");
				String textToDisplay = " Product "+ m[0] + " Advertised by " + m[3] + ": Description : " + m[1] + ". It costed $ " + m[2]+ "."; 
				out.println("<form action=\"UpdateCartServlet\" method=\"post\">");
				out.println((i+1) +". " + textToDisplay );
				out.println(" <select name = \"quant_del"+i+"\"> ");
				for(int j=Integer.parseInt(m[4]); j>=1; j--)
				{
					out.println("<option>"+ j + "</option>");
				}
				out.println(" </select> such items are added ");
				out.println("<br/>");
				out.println("<input type=\"submit\" name=\"Add"+i+"\" value=\"Remove Items\">");
				out.println("</form><br/>");
				out.println("<br/>");
				priceFinal = priceFinal + (Float.parseFloat(m[2])*Float.parseFloat(m[4]));
				
				request.getSession().setAttribute("advertizement_userID"+i, m[3]);
				request.getSession().setAttribute("item_name"+i, m[0]);
				request.getSession().setAttribute("item_desc"+i, m[1]);
				request.getSession().setAttribute("price"+i, m[2]);
				request.getSession().setAttribute("quantity"+i, m[4]);
				request.getSession().setAttribute("itemID"+i, m[5]);

			}

			out.println("<form>");
			out.println("You need to pay $ " + priceFinal);
			out.println("</form>");

			//To go ahead with payment
			out.println("<form action=\"BuyItemServlet\" method=\"post\"><br/>");
			out.println("<input type=\"submit\" name=\"Proceed to Pay\" value=\"Proceed to Pay\">");
			out.println("</form><br/><br/>");
		}
		//To go back to shopping cart
		out.println("<form action=\"DisplayAdServlet\" method=\"post\">");
		out.println("<input type=\"submit\" value=\"Back to Ads\">");
		out.println("</form><br/><br/>");

		out.println("<form action=\"Options.jsp\">");
		out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Options\">");
		out.println("</form><br/><br/>");

		//Option To sign out
		out.println("<form action=\"SignOutServlet\" method=\"post\"><br/>");
		out.println("<input type=\"submit\" name=\"Sign Out\" value=\"Sign Out\">");
		out.println("</form><br/><br/>");

//		request.getSession().setAttribute("item_name",item_name);
//		request.getSession().setAttribute("quantity", quantity);
		request.getSession().setAttribute("priceFinal", priceFinal);

		out.println("</html> </body>");
		}
		else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUpIn.jsp");
			out.println("<font color=red>Sorry, Not a valid session. Try logging in again!</font>");
			rd.include(request, response);

		}

	}


}


