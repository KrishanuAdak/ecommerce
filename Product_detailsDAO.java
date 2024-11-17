package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MODEL.Product_Image_details;
import MODEL.Product_details;

public class Product_detailsDAO {
	public ArrayList<Product_details> showDetailsById(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<Product_details> list=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from product_details where product_id=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int details_id=rs.getInt(1);
			int product_id=rs.getInt(2);
			String name=rs.getString(3);
			int price=rs.getInt(4);
			String origin=rs.getString(5);
			String usage=rs.getString(6);
			String description=rs.getString(7);
			Product_details p=new Product_details(details_id, product_id, name, price, origin, usage, description);
			list.add(p);
			
		}
		return list;
		
	}
	public ArrayList<Product_Image_details> showImagesById(int id) throws ClassNotFoundException, SQLException
	{
		ArrayList<Product_Image_details> list=new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
	    String sql="select * from product_image_details where product_id=?";
	    PreparedStatement ps=con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			int image_id=rs.getInt(1);
			String img1=rs.getString(2);
			String img2=rs.getString(3);
			String img3=rs.getString(4);
			int pr_id=rs.getInt(5);
			String img4=rs.getString(6);
			Product_Image_details details=new Product_Image_details(image_id, img1, img2, img3, pr_id,img4);
			list.add(details);
			
		}
		return list;
	   
	
	}

}
