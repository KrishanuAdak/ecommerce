package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import MODEL.Customer;
import MODEL.CustomerAddress;

public class CustomerDAO {

	public int insert(Customer customer) throws ClassNotFoundException, SQLException
	{
		System.out.println("jey");

		String sql="insert into customer (name,email,password,address,customer_id)values (?,?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1, customer.name);
        ps.setString(2, customer.email);
        ps.setString(3, customer.password);
        ps.setString(4, customer.address);
        Random rand=new Random();
        int id=rand.nextInt(9000)+1000;
        ps.setInt(5,id);
        int r=ps.executeUpdate();
		return r;
				
	}
	public boolean login(String email,String password) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from customer where  email=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		boolean b=rs.next();
		return b;
	}
	public String  getAddress(String name) throws ClassNotFoundException, SQLException
	{
		ArrayList<String> li=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select address from customer where name=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,name);
		String s="";
	    ResultSet rs=ps.executeQuery();
	    while(rs.next())
	    {
	    	 s=rs.getString("address");
	    	
	    	
	    }
	    return s; 
	
		
		
	}
	public int getIdOfCustomer(String name) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="Select customer_id from customer where name=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs=ps.executeQuery();
		int r=0;
		while(rs.next())
		{
			r=rs.getInt("customer_id");
		}
		return r;
		
		
	}
	public String isUserFindByPhoneNumber(String phone) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="Select * from customer where phone_number=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, phone);
		ResultSet rs=ps.executeQuery();
		String name="";
		while(rs.next())
		{
			 name=rs.getString("name");
		}
		return name;
	}
	public String getPhoneNumberById(int id) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="Select phone_number from customer where customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		String address="";
		while(rs.next())
		{
			 address=rs.getString("phone_number");					
		}
		return address;
	}
	public ArrayList<CustomerAddress> getDetailsById(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<CustomerAddress> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="Select * from address_customer where customer_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
//		ps.setInt(2, addressid);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int idx=rs.getInt(1);
			int pin=rs.getInt(3);
			String address1=rs.getString(4);
			String vill=rs.getString(5);
			String landmark=rs.getString(6);
			String state=rs.getString(7);	
			CustomerAddress cust=new CustomerAddress(idx,0,pin,address1,vill,landmark,state);
			lists.add(cust);
		}
		return lists;

		
	}
	public ArrayList<CustomerAddress> getAddressIdByCustomerName(int customer_id,int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<CustomerAddress> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="Select *  from address_customer where customer_id=? and id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1,customer_id);
		ps.setInt(2,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int pin=rs.getInt(3);
			String address1=rs.getString(4);
			String vill=rs.getString(5);
			String landmark=rs.getString(6);
			String state=rs.getString(7);
			CustomerAddress cust=new CustomerAddress(0,0,pin,address1,vill,landmark,state);
			lists.add(cust);
			
			
		}
		return lists;
		
	}

}
