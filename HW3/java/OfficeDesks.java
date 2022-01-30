import java.util.EnumSet;
/**
 * implements OfficeDesks functions
 */
public class OfficeDesks implements Products {
	private String color;
	private String model;
	private int quantity;
	private String branchname;
	
	/**
	 *  OfficeDesks constructer
	 *  @param Model which model name
	 *  @param Color which model name
	 *  @param branchname to which branch it will be added
	 */
	public OfficeDesks(String Model,String Color,String branchname) {
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
		OfficeDesks desk = (OfficeDesks)o;
		if(this.getModel().equals(desk.getModel()) && this.getColor().equals(desk.getColor())) {
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
	 * @return false if the model is not been in desk models
	 */
	public static boolean desk_model_control(String model) {
		boolean modelFlag = false;
		for (OfficeDeskModels info : EnumSet.allOf(OfficeDeskModels.class)) {
		    if(info.getModel().equals(model)) {
		    	modelFlag = true;
		    }
		}
		return modelFlag;
	}
	/**
	 * it controls the color name is true
	 * @param color color name
	 * @return false if the color is not been in desk colors
	 */
	public static boolean desk_color_control(String color) {
		boolean colorFlag = false;
		for (OfficeDeskColors info : EnumSet.allOf(OfficeDeskColors.class)) {
		    if(info.getColor().equals(color)) {
		    	colorFlag = true;
		    }
		}
		return colorFlag;
	}
	/**
	 * it prints desk models
	 */
	public static void printModels() {
		for (OfficeDeskModels info : EnumSet.allOf(OfficeDeskModels.class)) {
		    System.out.println(info);
		}
		
	}
	/**
	 * it prints desk colors
	 */
	public static void printColors() {
		for (OfficeDeskColors info : EnumSet.allOf(OfficeDeskColors.class)) {
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
