import java.util.LinkedList;

public class Product implements Comparable<Product>{
	
	private String ID;
	private String name;
	private LinkedList<String> category;
	private double price;
	private double discounted;
	private String describtion;
	private String trader;
	private int compare;
	private double discountPercentage;
    /**
     * Constructer
     * @param ID
     * @param name
     * @param category
     * @param price
     * @param discounted
     * @param describtion
     * @param trader
     */
	public Product(String ID,String name ,String category, double price, double discounted, String describtion,String trader) {
		super();
		this.category = new LinkedList<String>();
		String data[] = category.split(":");
		for(int i=0;i<data.length;i++) {
			this.category.add(data[i]);
		}
		this.setName(name);
		this.setID(ID);
		this.setPrice(price);
		this.setDiscounted(discounted);
		this.setDescribtion(describtion);
		this.setTrader(trader);
		this.setCompare(1);
		this.discountPercentage=100-((discounted/price)*100);
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 
	 * @return
	 */
	public double getDiscounted() {
		return discounted;
	}
	/**
	 * 
	 * @param discounted
	 */
	public void setDiscounted(double discounted) {
		this.discounted = discounted;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescribtion() {
		return describtion;
	}
	/**
	 * 
	 * @param describtion
	 */
	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}
	/**
	 * 
	 * @return
	 */
	public LinkedList<String> getCategory() {
		return category;
	}
	/**
	 * 
	 * @return
	 */
	public String getTrader() {
		return trader;
	}
	/**
	 * 
	 * @param trader
	 */
	public void setTrader(String trader) {
		this.trader = trader;
	}
	/**
	 * 
	 */
	public int compareTo(Product obj) {
		if(compare == 1) {
			return this.getName().compareTo(obj.getName());
		}
		else if(compare == 2){
			return (int)(this.price - obj.getPrice());
		}
		else if(compare == 3){
			return this.getTrader().compareTo(obj.getTrader());
		}
		else  {
			return (int)(this.discountPercentage - obj.getDiscountPercentage());
		}
	}
	/**
	 * 
	 * @return
	 */
	public String getID() {
		return ID;
	}
	/**
	 * 
	 * @param iD
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * 
	 */
	public String toString() {
		String temp = "ID:" + getID() + "\tName:" + name + "\tCategory:" + category.toString() + "\tPrice:" + Double.toString(price) + "\tDiscounted Price:" + Double.toString(price) + "\tTrader:" + trader;
		return temp;
	}
	/**
	 * 
	 * @return
	 */
	public int getCompare() {
		return compare;
	}
	/**
	 * 
	 * @param compare
	 */
	public void setCompare(int compare) {
		this.compare = compare;
	}
	/**
	 * 
	 * @return
	 */
	public double getDiscountPercentage() {
		return discountPercentage;
	}

	
}
