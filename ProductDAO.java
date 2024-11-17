package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.Product;
import MODEL.Product_Details_Search;
import MODEL.Product_Fashion;
import MODEL.Product_details;

public class ProductDAO {
	public ArrayList<Product> viewProducts() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> lists=new ArrayList<>();
		Product p;
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product";
		PreparedStatement ps=con.prepareStatement(sql);
	
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String cat=rs.getString(1);
			String desc=rs.getString(2);
			String name=rs.getString(3);
			int price=rs.getInt(4);
			int id=rs.getInt(5);
			String ima=rs.getString(6);
			p=new Product(id,name,desc,cat,price,ima);
			lists.add(p);
		}
		return lists;
		
		
	}
	public ArrayList<Product> getById(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> lists=new ArrayList<>();
		System.out.println("hey");
		Product p=null;
		String sql="select * from product where product_id=?";
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String cat=rs.getString(1);
			String desc=rs.getString(2);
			String name=rs.getString(3);
			int price=rs.getInt(4);
			String ima=rs.getString(6);

			p=new Product(id,name,desc,cat,price,ima);
			lists.add(p);
		}
		return lists;


	}
	public ArrayList<Product_Fashion> viewProductsShirts() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product_Fashion> lists=new ArrayList<>();
		Product_Fashion p;
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product_fashion";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String cat=rs.getString(1);
			String desc=rs.getString(2);
			String name=rs.getString(3);
			int price=rs.getInt(4);
			int id=rs.getInt(5);
			String ima=rs.getString(6);
			p=new Product_Fashion(id,name,cat,desc,price,ima);
			lists.add(p);
		}
		return lists;		
	}
//	public int delete(int id) throws ClassNotFoundException, SQLException
//	{
//		String sql="delete from product where product_id=?";
//		Class.forName("com.mysql.cj.jdbc.Driver");		
//		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
//		PreparedStatement ps=con.prepareStatement(sql);
//		ps.setInt(1,id);
//		int r=ps.executeUpdate();
//		return r;
//	}
	public ArrayList<Product> showElectronicProducts() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product where product_category like '%ele%'";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Product p;
		while(rs.next())
		{
			String name=rs.getString("product_name");
			String image=rs.getString("image");
			String desc=rs.getString("product_desc");
			int price=rs.getInt("product_price");
			int id=rs.getInt("product_id");
			String cat=rs.getString("product_category");
			p=new Product(id,name,cat,desc,price,image);
			lists.add(p);
			System.out.println(lists.size());
			
		}
	
		return lists;
	}
	public ArrayList<Product> showFashionProducts() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product where product_category like '%fash%'";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Product p;
		while(rs.next())
		{
			String name=rs.getString("product_name");
			String image=rs.getString("image");
			String desc=rs.getString("product_desc");
			int price=rs.getInt("product_price");
			int id=rs.getInt("product_id");
			String cat=rs.getString("product_category");
			p=new Product(id,name,cat,desc,price,image);
			lists.add(p);
			System.out.println(lists.size());
			
		}
	
		return lists;
	}
	public ArrayList<Product> showDecorProducts() throws ClassNotFoundException, SQLException
	{
		ArrayList<Product> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product where product_category like '%decor%'";
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		Product p;
		while(rs.next())
		{
			String name=rs.getString("product_name");
			String image=rs.getString("image");
			String desc=rs.getString("product_desc");
			int price=rs.getInt("product_price");
			int id=rs.getInt("product_id");
			String cat=rs.getString("product_category");
			p=new Product(id,name,cat,desc,price,image);
			lists.add(p);
			System.out.println(lists.size());
			
		}
	
		return lists;
	}
	public ArrayList<Product_Details_Search> getProductBySearch(String search) throws ClassNotFoundException, SQLException
	{
		ArrayList<Product_Details_Search> lists=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select p.product_price,p.image,d.product_name,d.product_origin from product p inner join product_details d on p.product_id=d.product_id where d.product_name like ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, "%"+search+"%");

		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			String name=rs.getString("product_name");
			String image=rs.getString("image");

			int price=rs.getInt("product_price");
	
			String origin=rs.getString("product_origin");

			Product_Details_Search p=new Product_Details_Search(name,origin,price,image);
			lists.add(p);
		
		}
		return lists;
		
	}
	public int getIdOfProduct(String name) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select product_id from product where product_name like ?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, "%"+name+"%");
		ResultSet rs=ps.executeQuery();
		int r=0;
		while(rs.next())
		{
			r=rs.getInt("product_id");
		}
		return r;
		
	}
	
	
	


}
