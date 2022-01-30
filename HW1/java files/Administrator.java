
/**
 * implements Administrator functions
 */
public class Administrator implements Person {
	private String name;
	private String surname;
	private String mail;
	private String password;
	private Company company;
	private container<String> messages;
	
	/**
	 * it is administrator constructor
	 * @param name it is name of the administrator
	 * @param surname it is surname of the administrator
	 * @param mail it is mail of the administrator
	 * @param password it is password of the administrator
	 * @param company it is company of the administrator
	 */
	public Administrator(String name,String surname,String mail,String password,Company company) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.company = company;
		this.messages = new container<>();
		this.getMessages().add("");
	}
	/**
	 * it returns the name of the administrator
	 */
	@Override
	public String getName() {
		
		return name;
	}
	/**
	 * it returns the company of the administrator
	 */
	public Company getCompany() {
		return this.company;
	}
	/**
	 * it sets the name of the administrator
	 * @param name it is name of the administrator
	 */
	@Override
	public void setName(String name) {
		
		this.name = name;
	}
	/**
	 * it returns the surname of the administrator
	 */
	@Override
	public String getSurname() {
		
		return surname;
	}
	/**
	 * it sets the name of the administrator
	 * @param Surname it is surname of the administrator
	 */
	@Override
	public void setSurname(String Surname) {
		
		this.surname = Surname;
	}
	/**
	 * it returns the mail of the administrator
	 */
	@Override
	public String getMail() {
		
		return mail;
	}
	/**
	 * it sets the mail of the administrator
	 * @param Mail it is mail of the administrator
	 */
	@Override
	public void setMail(String Mail) {
		
		this.mail = Mail;
	}
	/**
	 * it returns the password of the administrator
	 */
	@Override
	public String getPassword() {
		
		return password;
	}
	/**
	 * it sets the password of the administrator
	 * @param Password it is password of the administrator
	 */
	@Override
	public void setPassword(String Password) {
		
		this.password = Password;
	}
	/**
	 * it print the branch of the company
	 */
	public  void printBranches() {	
		for(int i=0;i<this.getCompany().getBranches().size();i++) {
				System.out.println("\n" + this.getCompany().getBranches().at(i) + "\n");
	
		}
	}
	/**
	 * it print the branchemployee of the company
	 */
	public  void printEmployees() {	
		for(int i=0;i<this.getCompany().getEmployees().size();i++) {
				System.out.println("\n" + this.getCompany().getEmployees().at(i) + "\n");
		
			
		}
	}
	/**
	 * it adds the branch of the company
	 * @param branchname which branch will be added
	 * @return false if the branch added before
	 */
	public boolean addBranche(String branchname) {
	
		return getCompany().getBranches().add(new Branches(branchname));
		
	}
	/**
	 * it removes the branch of the company
	 * @param branchname which branch will be removed
	 * @return false if the branch is not been in company
	 */
	public boolean removeBranche(String branchname)  {

			if(getCompany().getBranches().remove(new Branches(branchname))) {
				for(int i=0;i<getCompany().getEmployees().size();i++) {
					if(getCompany().getEmployees().at(i).getInformation().equals(branchname)) {
						this.removeBranchEmployee(getCompany().getEmployees().at(i).getName(),getCompany().getEmployees().at(i).getSurname(),null);
					}
				}
				return true;
			}
	
			

		return false;
		
		
	}
	/**
	 * it adds the branch employee of the company
	 * @param name branch employee name
	 * @param surname branch employee surname
	 * @param mail branch employee mail
	 * @param password branch employee password
	 * @param information branch employee information
	 * @param company branch employee company
	 * @return false if the branch employee added before
	 */
	public boolean addBranchEmployee(String name,String surname,String mail,String password,String information,Company company) {
		
		
		return getCompany().getEmployees().add(new BranchEmployees(name,surname,mail,password,information,company));
		
	}
	/**
	 * it removes the branch employee of the company
	 * @param name branch  employee name
	 * @param surname branch employee surname
	 * @param company branch employee company
	 * @return false if the branch employee is not been in company
	 */
	public boolean removeBranchEmployee(String name,String surname,Company company) {

			return getCompany().getEmployees().remove(new BranchEmployees(name,surname,null,null,null,null));
		
	}
	/**
	 * it prints messages of the branch employees
	 */
	public void printMessages() {
		for(int i=0;i<getMessages().size();i++) {

				if(!getMessages().at(i).equals(""))
					System.out.println("\n" + getMessages().at(i) + "\n");
				else
					System.out.println("\nThere is no messsage\n");

		}
	}
	@Override
	public String toString() {
		return "Name:" + getName() + " " + getSurname() + "\t" + "Mail:" + getMail();
	}
	public container<String> getMessages() {
		return messages;
	}

	public boolean equals(Object o) {
		
		Administrator admin = (Administrator)o;
		if(this.getMail().equals(admin.getMail())) {
			return true;
		}
		if(this.getName().equals(admin.getName()) && this.getSurname().equals(admin.getSurname())) {
			return true;
		}
		return false;
	}

}
