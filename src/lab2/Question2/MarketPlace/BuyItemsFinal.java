package lab2.Question2.MarketPlace;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import lab2.Question2.MarketPlace.MarketPlace;

/**
 * Servlet implementation class BuyItemsFinal
 */
public class BuyItemsFinal extends HttpServlet {
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
			

			boolean status = proxy.buyProduct(loginCookie.getValue());
			String msg;
			
			if(status == true){
				msg = "Congratulations! You bought the product/products successfully!";
			}
			else{
				msg = "There was an error while processing your transaction. Please try again.";
			}
			out.println("<html> <body bgcolor=\"#E6E6FA\">");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Options.jsp");
			out.println("<h3>" +msg +"</h3>");
			rd.include(request, response);
			out.println("</html> </body>");
			}
			else {
				throw new Exception();
			}

		}
		catch(Exception e){
			e.printStackTrace();
			PrintWriter out = response.getWriter();
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/SignUpIn.jsp");
			out.println("<font color=red>Sorry, Not a valid session. Try logging in again!</font>");
			rd.include(request, response);
		}

	}

	
}
