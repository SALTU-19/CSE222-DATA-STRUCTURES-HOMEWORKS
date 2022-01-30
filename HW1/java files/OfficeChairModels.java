/**
 * This is office chair models enum class
 */
public enum OfficeChairModels implements Models {
	
	WOODENCHAIR,IRONCHAIR,WIRECHAIR,METALCHAIR,STOOL,FOLDABLECHAIR,LEATHERCHAIR;
	
	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
		
		return this.name();
	}

}