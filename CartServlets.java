package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.*;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.sql.Date;
import java.util.Random;

import DAO.CartDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import MODEL.Cart;
import MODEL.Customer;
import MODEL.Order;
import MODEL.Product;

/**
 * Servlet implementation class CartServlets
 */
public class CartServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String cust_id=request.getParameter("customer_id");
		int idx=Integer.parseInt(id);
		int pr=Integer.parseInt(price);
		int cus=Integer.parseInt(cust_id);

		
	
	    Random rand=new Random();
	    int order_id=rand.nextInt(90000)+10000;
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis); 
        
	    		

      Order o=new Order(order_id,idx,name,pr,cus,"Confirmed",date);
 Product p=new Product(idx,name,"","",pr,"");
 Customer c=new Customer(cus,"","","","");
 OrderDAO dao=new OrderDAO(); 
 try 
 { 
	 int r=dao.insertOrders(o,p,c);
 if(r>0)
 { 
	 response.sendRedirect("Orders.jsp"); 
 }
 }
 catch (ClassNotFoundException | SQLException e) 
 { // TODO Auto-generated
    e.printStackTrace();
}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		RequestDispatcher rd=null;
		PrintWriter pw=response.getWriter();
	    Map<Integer,Integer> cart_Map=new HashMap<>();	
   
		if(session.getAttribute("username")==null)
		{
			response.sendRedirect("Login.jsp");
		}
		String cust_id=request.getParameter("customer_id");
		int c_id=Integer.parseInt(cust_id);
		String i=request.getParameter("id");
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String img=request.getParameter("image");
		Random rand=new Random();
		int cart_id=rand.nextInt(900)+100;
		int idx=Integer.parseInt(i);
		int pr=Integer.parseInt(price);
        int check=0;
    	CartDAO dao=new CartDAO();
		Cart cart=new Cart(cart_id,c_id,idx,name,pr,img,1);
		Product product=new Product(idx,name,"","",pr,img);
		Customer c=new Customer(c_id,"","","","");

        try {
        	boolean b=dao.getByIdFromCart(Integer.parseInt(i),c_id);
        	if(b)
        	{
        	  	session.setAttribute("Error-cart-msg", "Item already added in your cart!");
			   response.sendRedirect("Cart.jsp");
        		
        	}else {
    			int r=dao.insert(cart,product,c);
        		if(r>0)
    			{
    	
                     response.sendRedirect("Cart.jsp");
                     
    			}
        		
        	}
        	

		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


//		Cart cart=new Cart(cart_id,c_id,idx,name,pr,img,1);
//		Product product=new Product(idx,name,"","",pr,img);
//		Customer c=new Customer(c_id,"","","","");

//		String storing_insert="Added";
//		session.setAttribute("STORED", storing_insert);
		
//		try {
//			if(check==0)
//			{
//			int r=dao.insert(cart,product,c);
//			if(r>0)
//			{
//				  session.setAttribute("STORED", storing_insert);
//                  rd=request.getRequestDispatcher("Cart.jsp");
//                  rd.forward(request, response);
//                 
//			}
//			}
//			else {
//				session.setAttribute("Error-cart-msg", "Item already added in your cart!");
//			      rd=request.getRequestDispatcher("Cart.jsp");
//                  rd.forward(request, response);
//			}
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//	}
	}
//		ArrayList<Cart> carts=new ArrayList<>();
//	
//		Cart c=new Cart(idx,name,pr,img,"","",cart_id,1);
//		ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
//		if(cart_list==null)
//		{
//			carts.add(c);
//			session.setAttribute("cart-list",carts);
//			pw.println("session created and added the product");
//			response.sendRedirect("Cart.jsp");
//		}
//		else {
//			carts=cart_list;
//			boolean b=false;
//			for(Cart x:cart_list)
//			{
//				if(x.product_id==idx)
//				{
//					b=true;
//				    pw.println("<h1 style='color:red'>already existed</h1>");
//				}
//			}
//				
//			
//			    if(!b)
//			   {
//				carts.add(c);
//				response.sendRedirect("Cart.jsp");
//			   }
//			    
//		    
//		
//	    }
//	
//		
//	}
			
		
		
		
		

		
		
		
		

		
	}


