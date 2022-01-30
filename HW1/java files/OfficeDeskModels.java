/**
 * This is office desk models enum class
 */
public enum OfficeDeskModels implements Models {
	WOODENDESK,METALDESK,L_OFFICEDESK,COMPUTERDESK,GOLDENDESK;

	
	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
		return this.name();
	}

}
