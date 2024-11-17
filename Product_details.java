package MODEL;

public class Product_details {
	public int id;
	public int product_id;
	public String product_name;
	public int product_price;
	public String product_origin;
	public String product_usage;
	public String product_description;
	public Product_details(int id, int product_id, String product_name, int product_price, String product_origin,
			String product_usage, String product_description) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_origin = product_origin;
		this.product_usage = product_usage;
		this.product_description = product_description;
	}
	

}
