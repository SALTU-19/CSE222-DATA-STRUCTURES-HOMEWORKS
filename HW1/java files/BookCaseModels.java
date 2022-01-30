/**
 * This is bookcase models enum class
 */
public enum BookCaseModels implements Models {
	WOODENBOOKCASE,METALBOOKCASE,MULTIPURPOSEBOOKCASE,LARGEBOOKCASE,SMALLBOOKCASE,MARBLEBOOKCASE,
	GLASSBOOKCASE,DECORATIVEBOOKCASE,ZIGZAGBOOKCASE,SQUAREBOOKCASE,ROUNDBOOKCASE,COVEREDBOOKCASE;

	/**
	 * it returns the model name
	 */
	@Override
	public String getModel() {
		
		return this.name();
	}

}
