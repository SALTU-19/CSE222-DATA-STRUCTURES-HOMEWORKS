import java.util.NoSuchElementException;

/**
 * implements BranchEmployees functions
 */
public class BranchEmployees implements Person {
	private String name;
	private String surname;
	private String mail;
	private String password;
	private String information;
	private Company company;
	private Branches branch;
	
	/**
	 * it is BranchEmployees constructor
	 * @param Name it is name of the branch employee
	 * @param Surname it is surname of the branch employee
	 * @param Mail it is mail of the branch employee
	 * @param Password it is password of the branch employee
	 * @param Information it is branch name of the branch employee
	 * @param company it is company of the branch employee
	 */
	
	public BranchEmployees(String Name,String Surname,String Mail,String Password,String Information,Company company) {
		this.name = Name;
		this.surname = Surname;
		this.mail = Mail;
		this.password = Password;
		this.information = Information;
		this.company = company;
		if(company != null) {
			for(int i=0;i<company.getBranches().size();i++) {
				if(company.getBranches().get(i).getName().equals(this.getInformation())) {
					this.branch = company.getBranches().get(i);
				}
			}
		}
	}
	/**
	 * it returns the name of the branch employee
	 */
	@Override
	public String getName() {
		
		return name;
	}
	/**
	 * it returns the branch of the branch employee
	 */
	public Branches getBranch() {
		return branch;
	}
	/**
	 * it sets the name of the branch employee
	 * @param name it is name of the branch employee
	 */
	@Override
	public void setName(String Name) {
		
		this.name = Name;
	}
	/**
	 * it returns the surname of the branch employee
	 */
	@Override
	public String getSurname() {
		
		return surname;
	}
	/**
	 * it sets the surname of the branch employee
	 * @param name it is surname of the branch employee
	 */
	@Override
	public void setSurname(String Surname) {
		
		this.surname = Surname;
	}
	/**
	 * it returns the mail of the branch employee
	 */
	@Override
	public String getMail() {
		
		return mail;
	}
	/**
	 * it sets the mail of the branch employee
	 * @param name it is mail of the branch employee
	 */
	@Override
	public void setMail(String Mail) {
		
		this.mail = Mail;
	}
	/**
	 * it returns the password of the branch employee
	 */
	@Override
	public String getPassword() {
		
		return password;
	}
	/**
	 * it sets the password of the branch employee
	 * @param name it is password of the branch employee
	 */
	@Override
	public void setPassword(String Password) {
		
		this.password = Password;
	}
	/**
	 * it adds the office chair of the branch
	 * @param model which model will be added
	 * @param color which color will be added
	 * @return true if the chair added succesfully
	 */
	public boolean addChair(String model,String color) {
		if(!OfficeChairs.chair_model_control(model) &&  !OfficeChairs.chair_color_control(color)) {
			return false;
		}
		int index=0;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getChairs().add(new OfficeChairs(model,color,getInformation()))) {
			
			for(int i=0;i<branch.getChairs().size();i++) {
				if(branch.getChairs().get(i).equals(new OfficeChairs(model,color,getInformation()))) {
					
					branch.getChairs().get(i).setQuantity(branch.getChairs().get(i).getQuantity()+1);
				}
			}
		}
		return true;
	
	}
	/**
	 * it adds the office chair of the branch with quantity
	 * @param model which model will be added
	 * @param color which color will be added
	 * @param quantity how many chairs will be added
	 * @return true if chairs added succesfully
	 */
	public boolean addChair(String model,String color,int quantity) {
		if(!OfficeChairs.chair_model_control(model) &&  !OfficeChairs.chair_color_control(color)) {
			return false;
		}
		for(int i=0;i<quantity;i++) {
			addChair(model,color);
		}
		return true;
	}
	/**
	 * it removes the office chair of the branch with quantity
	 * @param model which model will be removed
	 * @param color which color will be removed
	 * @param quantity how many chairs will be removed
	 * @return false if the chairs are not been in company 
	 */
	public boolean removeChair(String model,String color,int quantity) {
		if(!OfficeChairs.chair_model_control(model) &&  !OfficeChairs.chair_color_control(color)) {
			return false;
		}
		int index=0;
		boolean flag=false;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		for(int i=0;i<branch.getChairs().size();i++) {
			if(branch.getChairs().get(i).equals(new OfficeChairs(model,color,getInformation()))) {
				if(!(branch.getChairs().get(i).getQuantity() < quantity)) {
						branch.getChairs().get(i).setQuantity(branch.getChairs().get(i).getQuantity()-quantity);
						flag = true;
				}
			}
		}
		return flag;
	}
	/**
	 * it adds the office Desk of the branch
	 * @param model which model will be added
	 * @param color which color will be added
	 * @return true if the Desk added succesfully
	 */
	public boolean addDesk(String model,String color) {
		if(!OfficeDesks.desk_model_control(model) &&  !OfficeDesks.desk_color_control(color)) {
			return false;
		}
		int index=0;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getDesks().add(new OfficeDesks(model,color,getInformation()))){
			for(int i=0;i<branch.getDesks().size();i++) {
				if(branch.getDesks().get(i).equals(new OfficeDesks(model,color,getInformation()))) {
					branch.getDesks().get(i).setQuantity(branch.getDesks().get(i).getQuantity()+1);
				}
			}
		}
		return true;
	}
	/**
	 * it adds the office Desk of the branch with quantity
	 * @param model which model will be added
	 * @param color which color will be added
	 * @param quantity how many Desks will be added
	 * @return true if Desks added succesfully
	 */
	public boolean addDesk(String model,String color,int quantity) {
		if(!OfficeDesks.desk_model_control(model) &&  !OfficeDesks.desk_color_control(color)) {
			return false;
		}
		for(int i=0;i<quantity;i++) {
			addDesk(model,color);
		}
		return true;
	}
	/**
	 * it removes the office Desk of the branch with quantity
	 * @param model which model will be removed
	 * @param color which color will be removed
	 * @param quantity how many Desks will be removed
	 * @return false if the Desks are not been in company 
	 */
	public boolean removeDesk(String model,String color,int quantity) {
		if(!OfficeDesks.desk_model_control(model) &&  !OfficeDesks.desk_color_control(color)) {
			return false;
		}
		int index=0;
		boolean flag=false;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		for(int i=0;i<branch.getDesks().size();i++) {
			if(branch.getDesks().get(i).equals(new OfficeDesks(model,color,getInformation()))) {
				if(!(branch.getDesks().get(i).getQuantity()<quantity)) {
					branch.getDesks().get(i).setQuantity(branch.getDesks().get(i).getQuantity()-quantity);
					flag = true;
				}
			}
		}
		return flag;
	}
	/**
	 * it adds the office Cabinet of the branch
	 * @param model which model will be added
	 * @return true if the Cabinet added succesfully
	 */
	public boolean addCabinet(String model) {
		if(!OfficeCabinets.cabinet_model_control(model)) {
			return false;
		}
		int index=0;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getCabinets().add(new OfficeCabinets(model,getInformation()))) {
			for(int i=0;i<branch.getCabinets().size();i++) {
				if(branch.getCabinets().get(i).equals(new OfficeCabinets(model,getInformation()))) {
					branch.getCabinets().get(i).setQuantity(branch.getCabinets().get(i).getQuantity()+1);
				}
			}
		}
		return true;
	}
	/**
	 * it adds the office Cabinet of the branch with quantity
	 * @param model which model will be added
	 * @param quantity how many Cabinets will be added
	 * @return true if Cabinets added succesfully
	 */
	public boolean addCabinet(String model,int quantity) {
		if(!OfficeCabinets.cabinet_model_control(model)) {
			return false;
		}
		for(int i=0;i<quantity;i++) {
			addCabinet(model);
		}
		return true;
	}
	/**
	 * it removes the office Cabinet of the branch with quantity
	 * @param model which model will be removed
	 * @param quantity how many Cabinets will be removed
	 * @return false if the Cabinets are not been in company 
	 */
	public boolean removeCabinet(String model,int quantity) {
		if(!OfficeCabinets.cabinet_model_control(model)) {
			return false;
		}
		int index=0;
		boolean flag=false;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getCabinets().add(new OfficeCabinets(model,getInformation()))) {
			for(int i=0;i<branch.getCabinets().size();i++) {
				if(branch.getCabinets().get(i).equals(new OfficeCabinets(model,getInformation()))) {
					if(branch.getCabinets().get(i).getQuantity()>= quantity) {
						branch.getCabinets().get(i).setQuantity(branch.getCabinets().get(i).getQuantity()-quantity);
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	/**
	 * it adds the Meeting table of the branch
	 * @param model which model will be added
	 * @param color which color will be added
	 * @return true if the Meeting table added succesfully
	 */
	public boolean addMeetingtable(String model,String color) {
		if(!MeetingTables.meetingtable_model_control(model) &&  !MeetingTables.meetingtable_color_control(color)) {
			return false;
		}
		int index=0;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getMeetingtables().add(new MeetingTables(model,color,getInformation()))) {
			for(int i=0;i<branch.getMeetingtables().size();i++) {
				if(branch.getMeetingtables().get(i).equals(new MeetingTables(model,color,getInformation()))) {
					branch.getMeetingtables().get(i).setQuantity(branch.getMeetingtables().get(i).getQuantity()+1);
				}
			}
		}
		return true;
	}
	/**
	 * it adds the Meeting table of the branch with quantity
	 * @param model which model will be added
	 * @param color which color will be added
	 * @param quantity how many Meeting tables will be added
	 * @return true if Meeting tables added succesfully
	 */
	public boolean addMeetingtable(String model,String color,int quantity) {
		if(!MeetingTables.meetingtable_model_control(model) &&  !MeetingTables.meetingtable_color_control(color)) {
			return false;
		}
		for(int i=0;i<quantity;i++) {
			addMeetingtable(model,color);
		}
		return true;
	}
	/**
	 * it removes the Meeting table of the branch with quantity
	 * @param model which model will be removed
	 * @param color which color will be removed
	 * @param quantity how many Meeting tables will be removed
	 * @return false if Meeting tables are not been in company 
	 */
	public boolean removeMeetingtable(String model,String color,int quantity) {
		if(!MeetingTables.meetingtable_model_control(model) &&  !MeetingTables.meetingtable_color_control(color)) {
			return false;
		}
		int index=0;
		boolean flag = false;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getMeetingtables().add(new MeetingTables(model,color,getInformation()))) {
			for(int i=0;i<branch.getMeetingtables().size();i++) {
				if(branch.getMeetingtables().get(i).equals(new MeetingTables(model,color,getInformation()))) {
					if(branch.getMeetingtables().get(i).getQuantity()>=quantity) {
						branch.getMeetingtables().get(i).setQuantity(branch.getMeetingtables().get(i).getQuantity()-quantity);
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	/**
	 * it adds the Bookcase of the branch
	 * @param model which model will be added
	 * @return true if the Bookcase added succesfully
	 */
	public boolean addBookcase(String model) {
		if(!BookCases.bookcase_model_control(model)) {
			return false;
		}
		int index=0;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getBookcases().add(new BookCases(model,getInformation()))) {
			for(int i=0;i<branch.getBookcases().size();i++) {
				if(branch.getBookcases().get(i).equals(new BookCases(model,getInformation()))) {
					branch.getBookcases().get(i).setQuantity(branch.getBookcases().get(i).getQuantity()+1);
				}
			}
		}
		return true;
	}
	/**
	 * it adds the Bookcase of the branch with quantity
	 * @param model which model will be added
	 * @param quantity how many Bookcases will be added
	 * @return true if Bookcases added succesfully
	 */
	public boolean addBookcase(String model,int quantity) {
		if(!BookCases.bookcase_model_control(model)) {
			return false;
		}
		for(int i=0;i<quantity;i++) {
			addBookcase(model);
		}
		return true;
	}
	/**
	 * it removes the Bookcase of the branch with quantity
	 * @param model which model will be removed
	 * @param quantity how many Bookcases will be removed
	 * @return false if Bookcases are not been in company 
	 */
	public boolean removeBookcase(String model,int quantity) {
		if(!BookCases.bookcase_model_control(model)) {
			return false;
		}
		int index=0;
		boolean flag = false;
		KWLinkedList<Branches> branches= getCompany().getBranches();
		for(int i=0;i<branches.size();i++) {
			if(branches.get(i).getName().equals(getInformation())) {
				index = i;
			}
		}
		
		if(!getCompany().getBranches().get(index).getBookcases().add(new BookCases(model,getInformation()))) {
			for(int i=0;i<branch.getBookcases().size();i++) {
				if(branch.getBookcases().get(i).equals(new BookCases(model,getInformation()))) {
					if(branch.getBookcases().get(i).getQuantity()>=quantity) {
						branch.getBookcases().get(i).setQuantity(branch.getBookcases().get(i).getQuantity()-quantity);
						flag = true;
					}
				}
			}
		}
		return flag;
	}
	/**
	 * it returns the branch name of the branch employee
	 */
	public String getInformation() {
		return information;
	}
	/**
	 * it sets the branch name of the branch employee
	 * @param information it is branch name of the branch employee
	 */
	public void setInformation(String information) {
		this.information = information;
	}
	/**
	 * it returns the company of the branch employee
	 */
	public Company getCompany() {
		return company;
	}

	public boolean equals(Object o) {
		
		BranchEmployees employee = (BranchEmployees)o;
		/*if(this.getMail().equals(employee.getMail())) {
			return true;
		}*/
		if(this.getName().equals(employee.getName()) && this.getSurname().equals(employee.getSurname())) {
			return true;
		}
		return false;
	}
	/**
	 * it returns the customer of the company
	 */
	public void printCustomers() {
		for(int i=0;i<getCompany().getCustomers().size();i++) {
			System.out.println(getCompany().getCustomers().get(i));
		}
	}
	/**
	 * it search customer of the company with ID 
	 * @param ID it is the ID of the customer
	 */
	public Customer search_customer(int ID) {
		for(int i=0;i<getCompany().getCustomers().size();i++) {
			if(getCompany().getCustomers().get(i).getID() == ID) {
				return getCompany().getCustomers().get(i);
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return "Name:" + getName() + " " + getSurname() + "\t" + "Mail:" + getMail() + "\t" + "Branch:" + getInformation();
	}
	/**
	 * it adds messages to administrator of the company
	 * @param message it is message to add administrator 
	 */
	public void addMessages(String message) {
		if(message == null) {
			throw new NoSuchElementException();
		}
		
		if(this.getCompany().getAdmin().getMessages().get(0).equals("")) {
			this.getCompany().getAdmin().getMessages().remove("");	
			this.getCompany().getAdmin().getMessages().add(message);
			
		}
		else {
			this.getCompany().getAdmin().getMessages().add(message);
		}
	}
}









