/**
 * This is office desk colors enum class
 */
public enum OfficeDeskColors implements Colors {
	WHITE,BLACK,RED,BLUE;

	
	/**
	 * it returns the color name
	 */
	@Override
	public String getColor() {
		return this.name();
	}

}
