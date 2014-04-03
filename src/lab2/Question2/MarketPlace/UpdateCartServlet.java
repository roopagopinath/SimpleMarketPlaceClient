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
 * Servlet implementation class AddToCartServlet
 */
public class UpdateCartServlet extends HttpServlet {
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
		try{
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

			//The logic below is to identify which Ad the user has selected to add to cart
			int count = (int) request.getSession().getAttribute("count");

			int index = -1;
			for(int i = 0; i < count; i++ )
			{
				if(request.getParameter("Add"+i) != null){
					index = i;
					break;
				}			
			}
			
			String itemIdString = (String)request.getSession().getAttribute("itemID"+index);
			
			if(itemIdString == null){
				throw new MyCustomException("Sorry another user has bought this item. Please try again.", "/DisplayAdServlet");
			}

			int itemID = Integer.parseInt(itemIdString);
			String userID = (String) request.getSession().getAttribute("userID"+index);
			System.out.println("The advertised user ID is " + userID);
			System.out.println("The logged in user ID is " + loginCookie.getValue());
			if(loginCookie.getValue().equals(userID) ){
				throw new MyCustomException("You are trying to add the item advertized by you! Action not allowed.", "/DisplayAdServlet");
			}

			int quantity;
			boolean addToCart = true;
			if(request.getParameter("quant"+index) != null)
			{
				quantity = Integer.parseInt(request.getParameter("quant"+index));
			}
			else
			{
				quantity = Integer.parseInt(request.getParameter("quant_del"+index));
				addToCart = false;
			}
			float priceFinal=0;

			boolean status = proxy.updateShoppingCart(loginCookie.getValue(),userID, itemID, quantity,addToCart);
			String[] msg;
			if(status == true){
				msg = proxy.viewCart(loginCookie.getValue());
			}
			else{
				msg = null;
			}

			out.println("<html> <body bgcolor=\"#E6E6FA\">");
			out.println("<p align=\"right\" ><table><tr><td>Signed in User:</td><td>"+loginCookie.getValue() + "</td></tr></table></p>");
			out.println("Shopping Cart!! ");
			out.println("<br/><br/>");

			if(msg == null)
			{
				out.println("Unable to fetch your shopping cart! Try again. ");
			}
			else {
				request.getSession().setAttribute("count", msg.length);

				out.println("Items in your shopping cart! ");
				out.println("<br/><br/>");


				for(int i=0; i< msg.length; i++)
				{
					String[] m = msg[i].split(":");
					String textToDisplay = m[0] + " Advertised by " + m[3] + ": Description : " + m[1] + ". It costed $ " + m[2]+ "."; 
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
					request.getSession().setAttribute("userID"+i, m[3]);
					request.getSession().setAttribute("item_name"+i, m[0]);
					request.getSession().setAttribute("item_desc"+i, m[1]);
					request.getSession().setAttribute("price"+i, m[2]);
					request.getSession().setAttribute("quantity"+i, m[4]);
					request.getSession().setAttribute("itemID"+i, m[5]);

				}

				//To go ahead with payment
				out.println("<form action=\"BuyItemServlet\" method=\"post\"><br/>");
				out.println("You need to pay $ " + priceFinal);
				out.println("<input type=\"submit\" name=\"Proceed to Pay\" value=\"Proceed to Pay\">");
				out.println("</form><br/><br/>");
			}
			//To go back to display Ads
			out.println("<form action=\"DisplayAdServlet\" method=\"post\">");
			out.println("<input type=\"submit\" value=\"Go to Ads\">");
			out.println("</form><br/><br/>");

			out.println("<form action=\"Options.jsp\" method=\"post\">");
			out.println("<input type=\"submit\" name=\"Back\" value=\"Back to Options\">");
			out.println("</form><br/><br/>");

			//Option To sign out
			out.println("<form action=\"SignOutServlet\" method=\"post\"><br/>");
			out.println("<input type=\"submit\" name=\"Sign Out\" value=\"Sign Out\">");
			out.println("</form><br/><br/>");

			request.getSession().setAttribute("priceFinal", priceFinal);

			out.println("</html> </body>");
		}
		else
		{
			throw new MyCustomException("Sorry, Not a valid session. Try logging in again!", "/SignUpIn.jsp");
		}
		}
		catch(MyCustomException e){
			RequestDispatcher rd = getServletContext().getRequestDispatcher(e.getPageName());
			out.println("<font color=red>" +e.getLocalizedMessage() +"</font>");
			rd.include(request, response);
			
		}
	}

}

class MyCustomException extends Exception{
	String msg;
	String pageName;
	public MyCustomException(String msg, String pageName) {
		this.msg = msg;
		this.pageName = pageName;
	}
	
	public String getPageName()
	{
		return pageName;
	}
	
	@Override
	public String getLocalizedMessage() {		
		return msg;		
	}
}
