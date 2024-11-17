package MODEL;


import java.sql.Time;
import java.time.LocalTime;
import java.util.*;


public class Order {
	public int order_id;
	public int product_id;
	public String product_name;
	public int product_price;
	public int customer_id;
	public String order_status;
	public Date order_date;

	public Order(int order_id, int product_id, String product_name, int product_price, int customer_id,String status,Date order_date) {
		super();
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.customer_id = customer_id;
		this.order_status=status;
		this.order_date=order_date;
	
	}

}
