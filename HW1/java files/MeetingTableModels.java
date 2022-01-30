/**
 * This is meeting table models enum class
 */
public enum MeetingTableModels implements Models {
	ROUNDTABLE,WOODENTABLE,METALTABLE,RECTANGULARTABLE,SMALLTABLE,SQUARETABLE,U_TABLE,ELITTABLE,ANTHRACITETABLE,BIGTABLE;
	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
		
		return this.name();
	}

}
