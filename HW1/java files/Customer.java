/**
 * implements Customer functions
 */
public class Customer implements Person {
	private String name;
	private String surname;
	private String mail;
	private String password;
	private static int customernumber = 0;
	private int ID;
	private Company company;
	private container<Order> orders;
	
	/**
	 * it is Customer constructor
	 * @param name it is name of the Customer
	 * @param surname it is surname of the Customer
	 * @param mail it is mail of the Customer
	 * @param password it is password of the Customer
	 * @param company it is company of the Customer
	 */
	@SuppressWarnings("static-access")
	public Customer(String name,String surname,String mail,String password,Company company) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.customernumber++;
		this.ID = customernumber;
		this.company = company;
		this.orders = new container<>();
	}
	/**
	 * it returns the company of the Customer
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * it returns the name of the Customer
	 */
	@Override
	public String getName() {
		
		return name;
	}
	/**
	 * it returns the name of the number of the customer
	 */
	public static int getCustomerNumber() {
		
		return customernumber;
	}
	/**
	 * it sets the name of the Customer
	 * @param Name it is name of the Customer
	 */
	@Override
	public void setName(String Name) {
		
		this.name = Name;
	}
	/**
	 * it returns the surname of the Customer
	 */
	@Override
	public String getSurname() {
		
		return surname;
	}
	/**
	 * it sets the surname of the Customer
	 * @param Surname it is surname of the Customer
	 */
	@Override
	public void setSurname(String Surname) {
		
		this.surname = Surname;
	}
	/**
	 * it returns the mail of the Customer
	 */
	@Override
	public String getMail() {
		
		return mail;
	}
	/**
	 * it sets the mail of the Customer
	 * @param Mail it is mail of the Customer
	 */
	@Override
	public void setMail(String Mail) {
		
		this.mail = Mail;
	}
	/**
	 * it returns the password of the Customer
	 */
	@Override
	public String getPassword() {
		
		return password;
	}
	/**
	 * it sets the password of the Customer
	 * @param Password it is password of the Customer
	 */
	@Override
	public void setPassword(String Password) {
		
		this.password = Password;
	}
	/**
	 * it returns the ID of the Customer
	 */
	public int getID() {
		return ID;
	}
	/**
	 * asks whether the chair is available in the company
	 * @param model it is model of the chair
	 * @param color it is color of the chair
	 * @param chair it is the chair which will be searched
	 */
	public OfficeChairs search_chair(String model, String color,OfficeChairs chair) {
		for(int i=0;i<getCompany().getBranches().size();i++) {
			for(int j=0;j<getCompany().getBranches().at(i).getChairs().size();j++) {
				if(getCompany().getBranches().at(i).getChairs().at(j).equals(new OfficeChairs(model,color,null))) {
					chair = getCompany().getBranches().at(i).getChairs().at(j);
					return chair;
				}
			}
		}
		return null;
	}
	/**
	 * asks whether the desk is available in the company
	 * @param model it is model of the desk
	 * @param color it is color of the desk
	 * @param desk it is the desk which will be searched
	 */
	public OfficeDesks search_desk(String model, String color,OfficeDesks desk) {
		for(int i=0;i<getCompany().getBranches().size();i++) {
			for(int j=0;j<getCompany().getBranches().at(i).getDesks().size();j++) {
				if(getCompany().getBranches().at(i).getDesks().at(j).equals(new OfficeDesks(model,color,null))) {
					desk = getCompany().getBranches().at(i).getDesks().at(j);
					return desk;
				}
			}
		}
		return null;
	}
	/**
	 * asks whether the cabinet is available in the company
	 * @param model it is model of the cabinet
	 * @param cabinet it is the cabinet which will be searched
	 */
	public OfficeCabinets search_cabinet(String model,OfficeCabinets cabinet) {
		for(int i=0;i<getCompany().getBranches().size();i++) {
			for(int j=0;j<getCompany().getBranches().at(i).getCabinets().size();j++) {
				if(getCompany().getBranches().at(i).getCabinets().at(j).equals(new OfficeCabinets(model,null))) {
					cabinet = getCompany().getBranches().at(i).getCabinets().at(j);
					return cabinet;
				}
			}
		}
		return null;
	}
	/**
	 * asks whether the bookcase is available in the company
	 * @param model it is model of the bookcase
	 * @param bookcase it is the bookcase which will be searched
	 */
	public BookCases search_bookcase(String model,BookCases bookcase) {
		for(int i=0;i<getCompany().getBranches().size();i++) {
			for(int j=0;j<getCompany().getBranches().at(i).getBookcases().size();j++) {
				if(getCompany().getBranches().at(i).getBookcases().at(j).equals(new BookCases(model,null))) {
					bookcase = getCompany().getBranches().at(i).getBookcases().at(j);
					return bookcase;
				}
			}
		}
		return null;
	}
	/**
	 * asks whether the meeting table is available in the company
	 * @param model it is model of the meeting table
	 * @param color it is color of the meeting table
	 * @param table it is the meeting table which will be searched
	 */
	public MeetingTables search_desk(String model, String color,MeetingTables table) {
		for(int i=0;i<getCompany().getBranches().size();i++) {
			for(int j=0;j<getCompany().getBranches().at(i).getMeetingtables().size();j++) {
				if(getCompany().getBranches().at(i).getMeetingtables().at(j).equals(new MeetingTables(model,color,null))) {
					table = getCompany().getBranches().at(i).getMeetingtables().at(j);
					return table;
				}
			}
		}
		return null;
	}
	/**
	 * asks whether the meeting table is available in the company
	 * @param adress it is adress of the customer
	 * @param number it is number of the customer
	 * @param product it is product which is buyed
	 * @param quantity it is quantity of product
	 */
	public boolean addOrder(String adress,String number,String product,int quantity) {
		Order order = new Order(name+" "+surname,adress, number, product, quantity);
		System.out.println(order);
		return this.orders.add(order);
	}
	/**
	 * it returns orders of this customer
	 */
	public container<Order> getOrder(){
		return orders;
	}
	/**
	 * it prints orders of this customer
	 */
	public void printOrders() {
		if(orders.size() != 0) {
			for(int i=0;i<orders.size();i++) {
				System.out.println("\n" + orders.at(i)+ "\n");
			}
		}
		else {
			System.out.println("\nThere is no order\n");
		}
	}

	public boolean equals(Object o) {
		Customer customer = (Customer)o;
		if(this.getMail().equals(customer.getMail())) {
			return true;
		}
		if(this.getName().equals(customer.getName()) && this.getSurname().equals(customer.getSurname())) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return "Name: "+ getName() + " Surname: " + getSurname() + " Mail: " + getMail() + " ID: " + getID(); 
	}
	

}
