package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import DAO.CartDAO;
import DAO.CouponDAO;
import DAO.CustomerDAO;

/**
 * Servlet implementation class CouponServlets
 */
public class CouponServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CouponServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	HttpSession session=request.getSession();
		String getValue=request.getParameter("off");
		int r=Integer.parseInt(getValue);
		System.out.println("r"+r);
		session.setAttribute("value",r);
		CustomerDAO dd=new CustomerDAO();
		CartDAO d=new CartDAO();
		int i;
		try {
			String name=(String)session.getAttribute("username");
			String forStore="Flag";
			i = dd.getIdOfCustomer(name);
	
			int x=d.getSumOfAllProducts(i);
		
			int couponSum=(int) session.getAttribute("SUM_CART");
			if(x>2000)
			{
			int total=(couponSum*r)/100;
			System.out.println("discount of coupoon:"+total); 
			int total_sum=(couponSum-total);
			System.out.println("Total Sum after discount"+total_sum);
		    session.setAttribute("Total_sum_of", total_sum);
			session.setAttribute("FOR_STORE_1", forStore);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("Error Less");
		RequestDispatcher rd=request.getRequestDispatcher("Cart.jsp");
		rd.forward(request, response);
//		CustomerDAO dao=new CustomerDAO();
//		try {
//			int id=dao.getIdOfCustomer("username");
//			System.out.println("coupon id"+id);
//		} catch (ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
         
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
