
public class Order {
	private String customerID;
	private Product product;
	
	/**
	 * constructer
	 * @param customerID
	 * @param product
	 */
	public Order(String customerID, Product product) {
		super();
		this.customerID = customerID;
		this.product = product;
	}
	/**
	 * 
	 * @return
	 */
	public String getCustomerID() {
		return customerID;
	}
	/**
	 * 
	 * @param customerID
	 */
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	/**
	 * 
	 * @return
	 */
	public Product getProduct() {
		return product;
	}
	/**
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
