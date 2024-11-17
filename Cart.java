package MODEL;

public class Cart{

	public int cart_id;
    public int customer_id;
	public int product_id;
	public String product_name;
	public int product_price;
	public String product_image;
	public int quantity;
	public Cart(int cart_id, int customer_id, int product_id, String product_name, int product_price,
			String product_image, int quantity) {
		super();
		this.cart_id = cart_id;
		this.customer_id = customer_id;
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_image = product_image;
		this.quantity = quantity;
	}
	


	
    
	

}
