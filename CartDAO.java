package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import MODEL.Cart;
import MODEL.Customer;
import MODEL.Product;

public class CartDAO {
	public int insert(Cart cart,Product product,Customer customer) throws ClassNotFoundException, SQLException
	{
		Product p=null;
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="insert into cart_table values (?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, cart.cart_id);
		ps.setInt(2, customer.id);
		ps.setInt(3, cart.product_id);
		ps.setString(4,product.product_name);
		ps.setInt(5, product.price);
		ps.setString(6,product.image);
		ps.setInt(7, cart.quantity);
		int r=ps.executeUpdate();
		return r;
	}
//	public ArrayList<Cart> getCartProducts() throws ClassNotFoundException, SQLException
//	{
//		Class.forName("com.mysql.cj.jdbc.Driver");		
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
//		ArrayList<Cart> carts=new ArrayList<>(); 
//	
//				Cart c=new Cart(0, null, 0, null, null, null, 0, 0);
//			
//					String query="select * from product where product_id=?";
//					PreparedStatement ps=con.prepareStatement(query);
//					ps.setInt(1, x.product_id);
//					ResultSet rs=ps.executeQuery();
//					while(rs.next())
//					{
//						c.setQuantity(x.getQuantity());
//					  String name=rs.getString("product_name");
//					  String image=rs.getString("product_image");
//					  int price=rs.getInt("product_price")*x.getQuantity();
//					  Random rand=new Random();
//					  int cart_id=rand.nextInt(90000)+10000;
//				      Cart cc=new Cart(0,name,price,image,"","",cart_id,c.getQuantity());
//				      carts.add(cc);
//							  
//					}
//							
//					
//
//			
//		
//	
//		return carts;
	
		
		
//	}
	public Set<Cart> showProducts(int id) throws ClassNotFoundException, SQLException
	{
		Set<Cart> s=new HashSet<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select distinct product_id,product_name,product_price,product_image  from cart_table where customer_id=? ";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int pro_id=rs.getInt("product_id");
			String pro_name=rs.getString("product_name");
			int price=rs.getInt("product_price");
			String image=rs.getString("product_image");
			Cart c=new Cart(0,0,pro_id,pro_name,price,image,1);
			s.add(c);
		}
		return s;
		
	}
	public int deleteCart(int id) throws ClassNotFoundException, SQLException
	{
		String sql="delete from cart_table where product_id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
	    PreparedStatement ps=con.prepareStatement(sql);
	    ps.setInt(1, id);
	    int r=ps.executeUpdate();
	    System.out.print("dleted: "+r);
	    return r;
	}
	public int getRowCount(int id) throws ClassNotFoundException, SQLException
	{
		String sql="select  count(product_id) from cart_table where customer_id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		int r=0;
		while(rs.next())
		{
			 r=rs.getInt(1);
		}
		return r;
	}
	public int getSumOfAllProducts(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select sum(product_price*quantity) from cart_table where customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		int sum=0;
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	sum=rs.getInt(1);
	    }
	    return sum;
	}
	public int setQuantityForCartItem(int product_id,int customer_id) throws ClassNotFoundException, SQLException
	{   Cart c=new Cart(0,product_id,customer_id,null, 0,"",0);
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="update cart_table set quantity=? where product_id=? and customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, c.quantity);
	    ps.setInt(2, product_id);
		ps.setInt(3, customer_id); 
		int r=ps.executeUpdate();
		return r;		
	}
	public int getQuantityByProduct(int product_id,int customer_id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select quantity from cart_table where product_id=? and customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, product_id);
		ps.setInt(2, customer_id);
		ResultSet rs=ps.executeQuery();
		int r=0;
		while(rs.next())
		{
			r=rs.getInt("quantity");
		}
		return r;
	}
	public boolean getByIdFromCart(int id,int cust_id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from cart_table where product_id=? and customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ps.setInt(2, cust_id);
		ResultSet rs=ps.executeQuery();
		boolean b=rs.next();
		return b;
		
		
	}


}
