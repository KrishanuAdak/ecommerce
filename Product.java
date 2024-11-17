package MODEL;

public class Product {
	public int product_id;
	public String product_name;
	public String product_desc;
	public String product_cat;
	public int price;
	public String image;
	public Product(int product_id, String product_name, String product_desc, String product_cat, int price,String i) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_desc = product_desc;
		this.product_cat = product_cat;
		this.price = price;
		this.image=i;
	}

	
	
	

}
