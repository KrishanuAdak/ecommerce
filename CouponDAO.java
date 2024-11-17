package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MODEL.coupon;

public class CouponDAO {
	public ArrayList<coupon> showCoupons() throws ClassNotFoundException, SQLException
	{
		ArrayList<coupon> lists=new ArrayList<coupon>();
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
        String sql="select * from coupon LIMIT 2";
    	PreparedStatement ps=con.prepareStatement(sql);
    	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		int id=rs.getInt("id");
    		String name=rs.getString("name");
    		String desc=rs.getString("description");
    		int off=rs.getInt("coupon_off");
    		String code=rs.getString("coupon_code");    		
    		coupon coupon=new coupon(id,name,off,code,desc);
    		lists.add(coupon);
    	}
    	return lists;

	}
	public ArrayList<coupon> showFirstOrderCoupon() throws ClassNotFoundException, SQLException
	{
		ArrayList<coupon> lists=new ArrayList<coupon>();
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdatabase?allowPublicKeyRetrieval=true&useSSL=false","root","1234");
		String sql="select * from coupon where coupon_off=50";
    	PreparedStatement ps=con.prepareStatement(sql);
      	ResultSet rs=ps.executeQuery();
    	while(rs.next())
    	{
    		int id=rs.getInt("id");
    		String name=rs.getString("name");
    		String desc=rs.getString("description");
    		int off=rs.getInt("coupon_off");
    		String code=rs.getString("coupon_code");    		
    		coupon coupon=new coupon(id,name,off,code,desc);
    		lists.add(coupon);
    	}
    	return lists;
    	
	}

}
