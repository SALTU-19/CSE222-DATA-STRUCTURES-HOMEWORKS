/**
 * implements Branches functions
 */
public class Branches {
	private String name;
	
	private container<OfficeChairs> chairs;
	
	private container<OfficeDesks> desks;

	private container<OfficeCabinets> cabinets;
	
	private container<BookCases> bookcases;

	private container<MeetingTables> meetingtables;

	/**
	 * it is Branches constructor
	 * @param name it is name of the Branch
	 */
	public Branches(String name) {
		setName(name);
		chairs = new container<>();
		desks = new container<>();
		cabinets = new container<>();
		bookcases = new container<>();
		meetingtables = new container<>();
		
	}
	/**
	 * it returns the name of the Branch
	 */
	public String getName() {
		return name;
	}
	/**
	 * it sets the name of the Branch
	 * @param name it is name of the Branch
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * it returns meeting tables of the Branch
	 */
	public container<MeetingTables> getMeetingtables() {
		return meetingtables;
	}
	/**
	 * it returns bookcases of the Branch
	 */
	public container<BookCases> getBookcases() {
		return bookcases;
	}
	/**
	 * it returns office cabinets of the Branch
	 */
	public container<OfficeCabinets> getCabinets() {
		return cabinets;
	}
	/**
	 * it returns office desks of the Branch
	 */
	public container<OfficeDesks> getDesks() {
		return desks;
	}
	/**
	 * it returns office chairs of the Branch
	 */
	public container<OfficeChairs> getChairs() {
		return chairs;
	}
	public boolean equals(Object o) {
	
		Branches branch = (Branches)o; 
		if(this.getName().equals(branch.getName())) {
			return true;
		}
		return false;
	}
	/**
	 * it returns the information of the products in this branch
	 */
	public String getInformation() {
		int i;
		String information = "";
		for(i=0;i<chairs.size();i++) {
			information += chairs.at(i).toString() + "\n";	
		}
		for(i=0;i<desks.size();i++) {
			information += desks.at(i).toString() + "\n";	
		}
		for(i=0;i<cabinets.size();i++) {
			information += cabinets.at(i).toString() + "\n";	
		}
		for(i=0;i<bookcases.size();i++) {
			information += bookcases.at(i).toString() + "\n";	
		}
		for(i=0;i<meetingtables.size();i++) {
			information += meetingtables.at(i).toString() + "\n";	
		}
		return information;
	}
	@Override
	public String toString() {
		return "Name:" + getName();
	}
	
	

	
	
	
}
