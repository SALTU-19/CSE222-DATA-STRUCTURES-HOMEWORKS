/**
 * This is office cabinet models enum class
 */
public enum OfficeCabinetModels implements Models {
	WOODENCABINET,METALCABINET,LARGECABINET,SMALLCABINET,GLASSCABINET,SQUARECABINET,ROUNDCABINET,PHONECABINET,SOUNDPROOFCABINET,ACOUSTICCABINET,GOLDENCABINET,OPENCABINET;
	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
	
		return this.name();
	}

}
