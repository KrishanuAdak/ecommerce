package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Random;

import MODEL.Customer;
import MODEL.Order;
import MODEL.Product;



public class OrderDAO {
	public int insertOrders(Order orders,Product product,Customer customer) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
	    String sql="insert into order_details (order_id,product_id,product_name,product_price,customer_id,order_status,order_date) values (?,?,?,?,?,?,?)";
	    PreparedStatement ps=con.prepareStatement(sql);
	    Random rand=new Random();
	    rand.nextInt(9000);	    
	    ps.setInt(1,orders.order_id);
	   ps.setInt(2,product.product_id);
	   ps.setInt(5,customer.id);
	   ps.setString(3, product.product_name);
	   ps.setInt(4, product.price);
	   ps.setString(6,orders.order_status);
	   ps.setDate(7, (Date) orders.order_date);
	   int r=ps.executeUpdate();
	   return r;
	    
	}
	public ArrayList<Order> ViewOrders(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<Order> li=new ArrayList<>();
        String sql="select * from order_details where customer_id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234"); 
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int cust=rs.getInt("customer_id");
			int ids=rs.getInt("order_id");
			int product_id=rs.getInt("product_id");
			String name=rs.getString("product_name");
			int pri=rs.getInt("product_price");
			Date date=rs.getDate("order_date");

			Order o=new Order(ids,cust,name,product_id,pri,"Confirmed",date);
			li.add(o);
			
		}
		return li;
	}
	public int numberOfOrders(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<Order> li=new ArrayList<>();
        String sql="select count(*) from order_details where customer_id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234"); 
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);

        ResultSet rs=ps.executeQuery();
        int r=0;
        while(rs.next())
        {
        	 r=rs.getInt(1);
        }
        return r;
	}
	


}
