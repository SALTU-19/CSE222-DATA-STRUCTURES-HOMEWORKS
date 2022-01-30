
/**
 * implements Order functions
 */
public class Order {
	private String name;
	private String adress;
	private String number;
	private String product;
	private int quantity;
	
	/**
	 * it is Order constructor
	 * @param name it is name of the Customer
	 * @param adress it is adress of the Customer
	 * @param number it is number of the Customer
	 * @param product it is product which is buyed
	 * @param quantity it is quantity of the product
	 */
	public Order(String name,String adress,String number,String product,int quantity) {
		this.adress = adress;
		this.number = number;
		this.product = product;
		this.quantity = quantity;
		this.name = name;
	}
	/**
	 * it returns the adress of the order
	 */
	public String getAdress() {
		return adress;
	}
	/**
	 * it sets the adress of the order
	 * @param adress it is adress of the order
	 */
	public void setAdress(String adress) {
		this.adress = adress;
	}
	/**
	 * it returns the number of the order
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * it sets the number of the order
	 * @param number it is number of the order
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * it returns the product of the order
	 */
	public String getProduct() {
		return product;
	}
	/**
	 * it sets the product of the order
	 * @param product it is product of the order
	 */
	public void setProduct(String product) {
		this.product = product;
	}
	/**
	 * it returns the quantity of the product
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * it sets the quantity of the product
	 * @param quantity it is the quantity of the product
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * it returns the name of the customer
	 */
	public String getName() {
		return name;
	}
	/**
	 * it sets the name of the customer
	 * @param name it is the name of the customer
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Name: "+ getName() + "\nAdress: " + getAdress() + "\nNumber: " + getNumber() + "\nProduct: " + getQuantity() + " " + getProduct();
	}
}
