package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.CartDAO;

/**
 * Servlet implementation class LogoutServlets
 */
public class LogoutServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LogoutServlets() {
        super();
    
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 PrintWriter out=response.getWriter(); 
	     HttpSession session=request.getSession();
	     session.removeAttribute("username");
	     session.invalidate();
	     out.print("<h1>Logout Successfully</h1>");
	     response.sendRedirect("Login.jsp");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		// TODO Auto-generated method stub
//		doGet(request, response);
		String id=request.getParameter("delete");
		int idx=Integer.parseInt(id);
		System.out.println("product id "+idx);
		String isCheck;
		CartDAO dao=new CartDAO();	
		try 
		{
		int r=dao.deleteCart(idx);
		System.out.println("value of r "+r);
		if(r>0)
		{
			isCheck="Checked";
			 HttpSession session=request.getSession();
			 session.setAttribute("Checked", isCheck);
			
			
			RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
			rd.forward(request, response);
		}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
//	}
	}

}
