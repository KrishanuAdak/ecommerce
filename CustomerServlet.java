package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.CustomerDAO;
import MODEL.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw=response.getWriter();

		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String address=request.getParameter("address");


	
			Customer cust=new Customer(0,name,email,password,address);
			CustomerDAO dao=new CustomerDAO();
			try {
				int r=dao.insert(cust);
				

				if(r>0)
				{
					 HttpSession session1 = request.getSession();
//					 session1.setAttribute("username", name);
//					 session1.setAttribute("email", email);
//					 session1.setAttribute("password", password);		
					  response.sendRedirect("Login.jsp");
					  session1.setMaxInactiveInterval(10);				
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerDAO dao=new CustomerDAO();
		String name=request.getParameter("name");
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
        String  rememberMe=request.getParameter("remember");
        RequestDispatcher rd=null;
		HttpSession session = request.getSession();
		
		try {
			boolean b=dao.login(email,password);
			if(b)
			{	 if(rememberMe!=null && rememberMe.equals("true"))
			      {  
				      System.out.println("Rememeber me");
				      Cookie cookie=new Cookie("USERNAME",name);
				      Cookie cookie1=new Cookie("PASSWORD",password);
				      Cookie cookie2=new Cookie("EMAIL",email);
		              cookie.setMaxAge(60*60*24*5);
		              cookie1.setMaxAge(60*60*24*5);
		              cookie2.setMaxAge(60*60*24*5);
		              response.addCookie(cookie);
		              response.addCookie(cookie1);
		              response.addCookie(cookie2);
	
			      }
			     else {
			    	  Cookie cookie = new Cookie("USERNAME", null);
		              cookie.setMaxAge(0); // delete the cookie
		              response.addCookie(cookie);

				
			     }
		      session.setAttribute("username", name);	
		      session.setAttribute("email", email);
		      session.setAttribute("password", password);
		      session.removeAttribute("Error-msg");
		      response.sendRedirect("Home.jsp");
			}
			else {
			    session.setAttribute("Error-msg", "Username or Password does not match");
			    response.sendRedirect("Login.jsp");
//				response.setContentType("text/html");
//				PrintWriter pw=response.getWriter();
//				pw.println("<h1 style='color:red'>Login failed</h1>");
				
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
