/**
 * This is office chair colors enum class
 */
public enum OfficeChairColors implements Colors {
	WHITE,BLACK,RED,YELLOW,BLUE;
	/**
	 * it returns the color name
	 */
	@Override
	public String getColor() {
		
		return this.name();
	}

}
