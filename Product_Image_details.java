package MODEL;

public class Product_Image_details extends Product {
	public int id;
	public String image1;
	public String image2;
	public String image3;
	public String image4;

//	public Product_Image_details(int product_id, String product_name, String product_desc, String product_cat,int price, String i) {
//		     super(product_id, product_name, product_desc, product_cat, price, i);
//
//	}
  public Product_Image_details(int id,String image1,String image2,String image3,int product_id,String image4)
  {
	  super(product_id, image3, image3, image3, product_id, image3);
	  this.id=id;
	  this.image1=image1;
	  this.image2=image2;
	  this.image3=image3;
	  this.image4=image4;
	  
	  
  }
}
