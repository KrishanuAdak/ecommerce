package MODEL;

public class CustomerAddress {
	public int id;
	public int customer_id;
	public int pincode;
	public String address1;
	public String village;
	public String landmark;
	public String state;
	public CustomerAddress(int id, int customer_id, int pincode, String address1, String village, String landmark,
			String state) {
		super();
		this.id = id;
		this.customer_id = customer_id;
		this.pincode = pincode;
		this.address1 = address1;
		this.village = village;
		this.landmark = landmark;
		this.state = state;
	}
	

}
