import java.util.EnumSet;
/**
 * implements BookCases functions
 */
public class BookCases implements Products {

	private String color;
	private String model;
	private int quantity;
	private String branchname;
	
	/**
	 *  BookCases constructer
	 *  @param Model which model name
	 *  @param branchname to which branch it will be added
	 */
	public BookCases(String Model,String branchname) {
		this.model = Model;
		this.setBranchname(branchname);
		this.quantity = 1;
	}
	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
		
		return model;
	}
	/**
	 * it returns the color name
	 */
	@Override
	public String getColor() {
		return color;
	}
	/**
	 * it sets the model name
	 * @param Model set the model name
	 */
	@Override
	public void setModel(String Model) {
		this.model = Model;
	}
	/**
	 * it sets the color name
	 * @param Color set the color name
	 */
	@Override
	public void setColor(String Color) {
		this.color = Color;
		
	}
	@Override
	public String toString() {
		return getQuantity() + " " + getModel();
	}
	public boolean equals(Object o) {
		BookCases bookcase = (BookCases)o;
		if(this.getModel().equals(bookcase.getModel())) {
			return true;
		}
		return false;
	}
	/**
	 * it returns quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * it sets quantity
	 * @param quantity set the quantity of this product
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * it controls the model name is true
	 * @param model model name
	 * @return false if the model is not been in bookcase models
	 */
	public static boolean bookcase_model_control(String model) {
		boolean modelFlag = false;
		for (BookCaseModels info : EnumSet.allOf(BookCaseModels.class)) {
		    if(info.getModel().equals(model)) {
		    	modelFlag = true;
		    }
		}
		return modelFlag;
	}
	/**
	 * it prints bookcase models
	 */
	public static void printModels() {
		for (BookCaseModels info : EnumSet.allOf(BookCaseModels.class)) {
		    System.out.println(info);
		}
		
	}
	/**
	 * it returns branch name 
	 */
	public String getBranchname() {
		return branchname;
	}
	/**
	 * it sets branch name
	 * @param branchname which branch name   
	 */
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

}
