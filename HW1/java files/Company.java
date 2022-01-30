import java.util.EnumSet;

/**
 * implements Company functions
 */
public class Company {
	private Administrator admin;
	private container<BranchEmployees> employees;
	private container<Branches> branches;
	private container<Customer> customers;
	
	/**
	 * it is Company constructor
	 */
	public Company() {
		this("Coskun","Saltu","saltu@mail.com","5918");

	}
	/**
	 * it is Company constructor
	 */
	public Company(String name,String surname,String mail,String password){
		admin = new Administrator(name,surname,mail,password,this);
		branches = new container<>();
	    employees = new container<>();
	    customers = new container<>();
		admin.addBranche("Corum");
		admin.addBranche("Yozgat");
		admin.addBranche("Ankara");
		admin.addBranche("Gebze");
		admin.addBranchEmployee("Ahmet", "Cakar", "cakar@mail.com", "cakar123", "Corum",this);
		admin.addBranchEmployee("Rasim Ozan", "Kutahyali", "rok@mail.com", "rok123", "Yozgat",this);
		admin.addBranchEmployee("Sinan", "Engin", "engin@mail.com", "engin123", "Ankara",this);
		admin.addBranchEmployee("Abdulkerim", "Durmaz", "durmaz@mail.com", "durmaz123", "Gebze",this);
		this.addCustomer("Samet", "Nalbant", "nalbant@mail.com", "nalbant123", this);
		this.addProduct();
	}
	/**
	 * it returns the administrator of this company
	 */
	public Administrator getAdmin() {
		
		return admin;
	}
	/**
	 * it adds products automatic
	 */
	private void addProduct() {
		for (OfficeChairModels model : EnumSet.allOf(OfficeChairModels.class)) {
			for (OfficeChairColors color : EnumSet.allOf(OfficeChairColors.class)) {
			    employees.at(0).addChair(model.getModel(), color.getColor(),5);
			}
		}
		for (OfficeDeskModels model : EnumSet.allOf(OfficeDeskModels.class)) {
			for (OfficeDeskColors color : EnumSet.allOf(OfficeDeskColors.class)) {
			    employees.at(1).addDesk(model.getModel(), color.getColor(),5);
			}
		}
		for (MeetingTableModels model : EnumSet.allOf(MeetingTableModels.class)) {
			for (MeetingTableColors color : EnumSet.allOf(MeetingTableColors.class)) {
			    employees.at(2).addMeetingtable(model.getModel(), color.getColor(),5);
			}
		}
		for (OfficeCabinetModels model : EnumSet.allOf(OfficeCabinetModels.class)) {
		    employees.at(3).addCabinet(model.getModel(),5);
		}
		for (BookCaseModels model : EnumSet.allOf(BookCaseModels.class)) {
		    employees.at(3).addBookcase(model.getModel(),5);
		}
		
	}
	/**
	 * it returns employees of this company
	 */
	public container<BranchEmployees> getEmployees() {
		
		return employees;
	}
	/**
	 * it returns branches of this company
	 */
	public container<Branches> getBranches() {
		
		return branches;
	}
	/**
	 * it returns customers of this company
	 */
	public container<Customer> getCustomers() {
		
		return customers;
	}
	/**
	 * it adds customer of the company
	 * @param name customer name
	 * @param surname customer surname
	 * @param mail customer mail
	 * @param password customer password
	 * @param companycustomer company
	 * @return false if the customer added before
	 */
	public boolean addCustomer(String name,String surname,String mail,String password,Company company) {
		return customers.add(new Customer(name, surname, mail, password, company));
	}
	/**
	 * it controls admin in company
	 * @param mail admin mail
	 * @param password admin password
	 * @return false if the admin is not been in this company
	 */
	public boolean adminControl(String mail,String password) {
		
		return mail.equals(this.getAdmin().getMail()) && password.equals(this.getAdmin().getPassword());
	}
	/**
	 * it controls branch employee in company
	 * @param mail branch employee mail
	 * @param password branch employee password
	 * @return -1 if the branch employee is not been in this company
	 */
	public int employeeControl(String mail,String password) {
		for(int i=0;i<this.getEmployees().size();i++) {
			if(mail.equals(this.getEmployees().at(i).getMail()) && password.equals(this.getEmployees().at(i).getPassword())) {
				return i;
			}
		}
		return -1;
		
	}
	/**
	 * it controls customer in company
	 * @param mail customer mail
	 * @param password customer password
	 * @return -1 if the customer is not been in this company
	 */
	public int customerControl(String mail,String password) {
		for(int i=0;i<this.getCustomers().size();i++) {
			if(mail.equals(this.getCustomers().at(i).getMail()) && password.equals(this.getCustomers().at(i).getPassword())) {
				return i;
			}
		}
		return -1;
		
	}
	/**
	 * it prints all products in company 
	 */
	public void printAllProduct() {
		for(int i=0;i<branches.size();i++) {
			System.out.println(branches.at(i).getInformation());
		}
	}
	
	
	
}
