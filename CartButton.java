package Servlets;

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
import java.util.Set;

import DAO.CartDAO;
import DAO.ProductDAO;
import MODEL.Cart;

/**
 * Servlet implementation class CartButton
 */
public class CartButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartButton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String customer_id=request.getParameter("customer_id");
		try {
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		    String sql=" INSERT INTO order_details (order_date,customer_id,product_id, product_name, product_price,order_status,order_time) SELECT curdate(),customer_id,product_id,product_name,product_price,'confirmed',curtime() FROM cart_table where customer_id=?";
		   PreparedStatement ps=con.prepareStatement(sql);
		   ps.setInt(1, Integer.parseInt(customer_id));
		   int r=ps.executeUpdate();
		   if(r>0)
		   {
			   System.out.println("Ordered successfull!");
			   response.sendRedirect("Orders.jsp");
		   }
		   
		
		}
		
		catch (ClassNotFoundException | SQLException e) 
		{
		
			e.printStackTrace();
		}		

		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
			if(r>1)
			{
				session.removeAttribute("Error-cart-msg");
			ps.setInt(1, r-1);
		    ps.setInt(2, Integer.parseInt(product_id));
			ps.setInt(3,Integer.parseInt(customer_id)); 
			int x=ps.executeUpdate();
		    System.out.println("Updated in cart");
			}
//		    ProductDAO dao=new ProductDAO();
//			Set<Cart> lists=dao.showProducts();
//			for(Cart o:lists)
//			{
//				sum=sum+(o.product_price)*(Integer.parseInt(quantity));
//			}
//			System.out.println("sum of product_serv;"+sum);
//			session.setAttribute("SUM_CART", sum);
//			session.setAttribute("FOR_STORE", store);
			response.sendRedirect("Cart.jsp");
			
			
			
			
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		

	}

}
