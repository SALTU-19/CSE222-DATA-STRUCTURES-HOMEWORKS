/**
 * This is meeting table colors enum class
 */
public enum MeetingTableColors implements Colors {
	WHITE,BLACK,RED,BLUE;
	/**
	 * it returns the color name
	 */
	@Override
	public String getColor() {
		
		return this.name();
	}

}
