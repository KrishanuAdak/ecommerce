package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import DAO.CartDAO;
import DAO.ProductDAO;
import MODEL.Cart;
import MODEL.Product;

/**
 * Servlet implementation class productServlets
 */
public class productServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher rd=null;
		String search=request.getParameter("search");
		System.out.println("Search bar is"+search);
        
		response.sendRedirect("SearchBar.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String product_id=request.getParameter("product_id");
		String customer_id=request.getParameter("customer_id");
		
		CartDAO cart=new CartDAO();
		try {
			int r=cart.getQuantityByProduct(Integer.parseInt(product_id), Integer.parseInt(customer_id));
			cart.setQuantityForCartItem(r, r);
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
			String sql="update cart_table set quantity=? where product_id=? and customer_id=?";
//			  Cart c=new Cart(0,Integer.parseInt(id),i_id,null, 0,"",Integer.parseInt(quantity));
			PreparedStatement ps=con.prepareStatement(sql);
			if(r>0)
			{
				session.removeAttribute("Error-cart-msg");
			ps.setInt(1, r+1);
		    ps.setInt(2, Integer.parseInt(product_id));
			ps.setInt(3,Integer.parseInt(customer_id)); 
			int x=ps.executeUpdate();
		    System.out.println("Updated in cart");
			}
			response.sendRedirect("Cart.jsp");

//		String quantity=request.getParameter("quantity");
//		String id=request.getParameter("product_id");
//		String cus_id=request.getParameter("customer_id");
//		int i_id=Integer.parseInt(cus_id);
//		String store="for_store";		
//		CartDAO dao=new CartDAO();
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");		
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
//			String sql="update cart_table set quantity=? where product_id=? and customer_id=?";
//			  Cart c=new Cart(0,Integer.parseInt(id),i_id,null, 0,"",Integer.parseInt(quantity));
//			PreparedStatement ps=con.prepareStatement(sql);
//			ps.setInt(1, Integer.parseInt(quantity));
//		    ps.setInt(2, Integer.parseInt(id));
//			ps.setInt(3,i_id); 
//			int r=ps.executeUpdate();
//			int sum=0;
//		    if(r>0)
//		    {
//		    	System.out.println("UPDATED"+quantity+" "+id);
//		    }
//			Set<Cart> lists=dao.showProducts(i_id);
//			for(Cart o:lists)
//			{
//				sum=sum+(o.product_price)*(Integer.parseInt(quantity));
//			}
//			System.out.println("sum of product_serv;"+sum);
//			session.setAttribute("SUM_CART", sum);
//			session.setAttribute("FOR_STORE", store);
//			response.sendRedirect("Cart.jsp");



		    
		} 
		catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	}

}
