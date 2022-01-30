import java.util.EnumSet;
/**
 * implements OfficeChairs functions
 */
public class OfficeChairs implements Products {
	private String color;
	private String model;
	private int quantity;
	private String branchname;
	
	/**
	 *  OfficeChairs constructer
	 *  @param Model which model name
	 *  @param Color which model name
	 *  @param branchname to which branch it will be added
	 */
	public OfficeChairs(String Model,String Color,String branchname) {
		this.model = Model;
		this.color = Color;
		this.quantity = 1;
		this.branchname = branchname;
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
		return getQuantity() + " " + getColor() + " " + getModel();
	}
	public boolean equals(Object o) {
		OfficeChairs chair = (OfficeChairs)o;
	
		if(this.getModel().equals(chair.getModel()) && this.getColor().equals(chair.getColor())) {
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
	 * @return false if the model is not been in chair models
	 */
	public static boolean chair_model_control(String model) {
		boolean modelFlag = false;
		for (OfficeChairModels info : EnumSet.allOf(OfficeChairModels.class)) {
		    if(info.getModel().equals(model)) {
		    	modelFlag = true;
		    }
		}
		return modelFlag;
	}
	/**
	 * it controls the color name is true
	 * @param color color name
	 * @return false if the color is not been in chair colors
	 */
	public static boolean chair_color_control(String color) {
		boolean colorFlag = false;
		for (OfficeChairColors info : EnumSet.allOf(OfficeChairColors.class)) {
		    if(info.getColor().equals(color)) {
		    	colorFlag = true;
		    }
		}
		return colorFlag;
	}
	/**
	 * it prints chair models
	 */
	public static void printModels() {
		for (OfficeChairModels info : EnumSet.allOf(OfficeChairModels.class)) {
		    System.out.println(info);
		}
	}
	/**
	 * it prints chair colors
	 */
	public static void printColors() {
		for (OfficeChairColors info : EnumSet.allOf(OfficeChairColors.class)) {
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
