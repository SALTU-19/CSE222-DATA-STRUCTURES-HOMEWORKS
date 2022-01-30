
import java.util.Scanner;

public class Driver {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Company company = new Company("Coskun","Saltu","saltu@mail.com","5918");
		Scanner myObj = new Scanner(System.in);
		int selection = 0;
		String name,surname,mail,password;
		while(true) {
			System.out.println("*****Welcome to SALTU FURNITURE*****");
			System.out.println("1.Login ");
			System.out.println("2.Register");
			System.out.println("3.Quit");
			selection = myObj.nextInt();
			switch (selection) {
				case 1:
					LogIn(company);
					break;
				case 2:
					myObj.nextLine();
					System.out.println("Please enter a customer name:");
					name = myObj.nextLine();
					System.out.println("Please enter a customer surname:");
					surname = myObj.nextLine();
					System.out.println("Please enter a customer mail:");
					mail = myObj.nextLine();
					System.out.println("Please enter a customer password:");
					password = myObj.nextLine();
					if(company.addCustomer(name, surname, mail, password, company)) {
						System.out.println("\nIt is done!\n");
					}
					else {
						System.out.println("\nYou are already registered!\n");
					}
					break;
				case 3:
					System.out.println("Quitting...");
					break;
				default:
					System.out.println("Incorrect Value!");
					break;
			}
			if(selection == 3) {
				break;
			}
		
		}
	}
	@SuppressWarnings("resource")
	public static void LogIn(Company company) {
		int selection,index;
		String mail,password;
		Scanner myObj = new Scanner(System.in);
		while(true) {
			System.out.println("1.Login as administrator\n2.Login as employee\n3.Login as customer\n4.Return main menu");
			selection = myObj.nextInt();
			if(selection == 4) {
				break;
			}
			myObj.nextLine();
			System.out.println("Please enter your mail:");
			mail = myObj.nextLine();
			System.out.println("Please enter your password:");
			password =  myObj.nextLine();
			switch (selection) {
				case 1:
					if(company.adminControl(mail,password)) {
						admin(company);
					}

					else {
						System.out.println("Invalid mail or password!");
					}
					break;
				case 2:
					index = company.employeeControl(mail, password);
					if(index != -1) {
						employee(company.getEmployees().get(index));
					}
					else {
						System.out.println("Invalid mail or password!");
					}
					break;
				case 3:
					index = company.customerControl(mail, password);
					if(index != -1) {
						customer(company.getCustomers().get(index));
					}
					else {
						System.out.println("Invalid mail or password!");
					}
					break;
				case 4:
					System.out.println("Returning...");
					break;
				default:
					System.out.println("Incorrect Value!");
					break;
			}

		}
	}
	@SuppressWarnings("resource")
	private static void customer(Customer customer) {
		int selection,selection2;
		Scanner myObj = new Scanner(System.in);
		System.out.println("\nWelcome " + customer.getName() + " " + customer.getSurname() + "\n");
		while(true) {
			System.out.println("1.Print all product in company\n2.Search a product in company\n3.Print my previous orders\n4.Return the top menu");
			selection = myObj.nextInt();
			switch (selection) {
			case 1:
				customer.getCompany().printAllProduct();
				break;
			case 2:
				System.out.println("Which product do you want to buy ?\n\n1.Office Chair\n2.Office Desk\n3.Office Cabinet\n4.Bookcase\n5.Meeting Table");
				selection2 = myObj.nextInt();
				myObj.nextLine();
				switch (selection2) {
					case 1:
						Chair(customer,3);
						break;
					case 2:
						Desk(customer,3);
						break;
					case 3:
						Cabinet(customer,3);
						break;
					case 4:
						Bookcase(customer,3);
						break;
					case 5:
						Meetingtable(customer,3);
						break;
					default:
						System.out.println("Invalid Value!");
						break;
				}
				break;
			case 3:
				customer.printOrders();
			case 4:
				System.out.println("Returning...");
			default:
				break;
			}
			if(selection == 4) {
				break;
			}
		}
		
	}

	@SuppressWarnings({ "resource" })
	public static void admin(Company company)  {
		int selection;
		Administrator admin = company.getAdmin();
		String branchname,name,surname,mail,password,information;
		Scanner myObj = new Scanner(System.in);
		System.out.println("\nWelcome " + admin.getName() + " " + admin.getSurname() + "\n");
		while(true) {
			System.out.println("1.Add branch\n2.Add branchemployee\n3.Remove branch\n4.Remove branchemployee\n5.Print Branches\n6.Print BranchEmployees\n7.Print messages\n8.Return to top menu");
			selection = myObj.nextInt();
			myObj.nextLine();
			switch (selection) {
			case 1:
				System.out.println("Your Branches:");
				admin.printBranches();
				System.out.println("Please enter a branch name:");
				branchname = myObj.nextLine();
				if(admin.addBranche(branchname)) {
					System.out.println("The branch has been added!");
					System.out.println("Your new branches:");
					admin.printBranches();
				}
				else {
					System.out.println("The branch is already been in company!");
				}
				break;
			case 2:
				System.out.println("Your Branchemployees:");
				admin.printEmployees();
				System.out.println("Please enter a employee name:");
				name = myObj.nextLine();
				System.out.println("Please enter a employee surname:");
				surname = myObj.nextLine();
				System.out.println("Please enter a employee mail:");
				mail = myObj.nextLine();
				System.out.println("Please enter a employee password:");
				password = myObj.nextLine();
				System.out.println("Please enter a employee branchname:");
				information = myObj.nextLine();
				boolean flag=false;
				for(int i=0;i<admin.getCompany().getBranches().size();i++) {
					if(admin.getCompany().getBranches().get(i).getName().equals(information)) {
						flag = true;
					}
				}
				if(flag == false) {
					System.out.println("There is no branch with this name!");
				}
				else {
					if(admin.addBranchEmployee(name, surname, mail, password, information, company)) {
						System.out.println("The employee has been added!");
						System.out.println("Your new Branchemployees:");
						admin.printEmployees();
					}
					else {
						System.out.println("The Branchemployee is already been in company!");
					}
				}
				break;
			case 3:
				System.out.println("Your Branches:");
				admin.printBranches();
				System.out.println("Please enter a branch name:");
				branchname = myObj.nextLine();
				if(admin.removeBranche(branchname)) {
					System.out.println("The branch has been removed!");
					System.out.println("Your new branches:");
					admin.printBranches();
				}
				else {
					System.out.println("The branch is not been in company!");
				}
				break;
			case 4:
				System.out.println("Your Branchemployees:");
				admin.printEmployees();
				System.out.println("Please enter a employee name:");
				name = myObj.nextLine();
				System.out.println("Please enter a employee surname:");
				surname = myObj.nextLine();
				if(admin.removeBranchEmployee(name, surname,company)) {
					System.out.println("The employee has been removed!");
					System.out.println("Your new Branchemployees:");
					for(int i=0;i<admin.getCompany().getEmployees().size();i++) {
						System.out.println(admin.getCompany().getEmployees().get(i));
					}
				}
				else {
					System.out.println("The Branchemployee is not been in company!");
				}
				break;
			case 5:
				System.out.println("Your Branches:");
				admin.printBranches();
				break;
			case 6:
				System.out.println("Your Branchemployees:");
				admin.printEmployees();
				break;
			case 7:
				admin.printMessages();
				break;
			case 8:
				System.out.println("Returning...");
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
			if(selection == 8) {
				break;
			}
		}
		
	}
	@SuppressWarnings("resource")
	public static void employee(BranchEmployees employee) {
		int selection,selection2,ID,option;
		Scanner myObj = new Scanner(System.in);
		System.out.println("\nWelcome " + employee.getName() + " " + employee.getSurname() + "\n");
		while(true) {
			System.out.println("1.Add Product to branch\n2.Make sell\n3.Print all product in your branch\n4.Print previous order a customer\n5.Inform the manager\n6.Exit");
			selection = myObj.nextInt();
			switch (selection) {
			case 1:
				System.out.println("Which product do you want to add ?\n\n1.Office Chair\n2.Office Desk\n3.Office Cabinet\n4.Bookcase\n5.Meeting Table");
				selection2 = myObj.nextInt();
				myObj.nextLine();
				switch (selection2) {
					case 1:
						Chair(employee,selection);
						break;
					case 2:
						Desk(employee,selection);
						break;
					case 3:
						Cabinet(employee,selection);
						break;
					case 4:
						Bookcase(employee,selection);
						break;
					case 5:
						Meetingtable(employee,selection);
						break;
					default:
						System.out.println("Invalid Value!");
						break;
				}
				break;
			case 2:
				System.out.println("Which product do you want to sell ?\n\n1.Office Chair\n2.Office Desk\n3.Office Cabinet\n4.Bookcase\n5.Meeting Table");
				selection2 = myObj.nextInt();
				myObj.nextLine();
				switch (selection2) {
					case 1:
						Chair(employee,selection);
						break;
					case 2:
						Desk(employee,selection);
						break;
					case 3:
						Cabinet(employee,selection);
						break;
					case 4:
						Bookcase(employee,selection);
						break;
					case 5:
						Meetingtable(employee,selection);
						break;
					default:
						System.out.println("Invalid Value!");
						break;
				}
				break;
				
			case 3:
				System.out.println("\n" + employee.getBranch().getInformation());
				break;
			case 4:
				employee.printCustomers();
				System.out.println("\nPlease enter a ID");
				ID = myObj.nextInt();
				if(employee.search_customer(ID) != null) {
					employee.search_customer(ID).printOrders();
				}
				break;
			case 5:
				System.out.println("Which product do you want to inform to admin ?\n\n1.Office Chair\n2.Office Desk\n3.Office Cabinet\n4.Bookcase\n5.Meeting Table");
				option = myObj.nextInt();
				switch (option) {
				case 1:
					employee.addMessages("\nBy " + employee.getName() + " " + employee.getSurname() + "\nOffice Chair is missing\n");
					break;
				case 2:
					employee.addMessages("\nBy " + employee.getName() + " " + employee.getSurname() + "\nOffice Desk is missing\n");
					break;
				case 3:
					employee.addMessages("\nBy " + employee.getName() + " " + employee.getSurname() + "\nOffice Cabinet is missing\n");
					break;
				case 4:
					employee.addMessages("\nBy " + employee.getName() + " " + employee.getSurname() + "\nBookcase is missing\n");
					break;
				case 5:
					employee.addMessages("\nBy " + employee.getName() + " " + employee.getSurname() + "\nMeeting Table is missing\n");
				default:
					System.out.println("Invalid Value");
					break;
				}
				System.out.println("\nThis is done\n");
				break;
			case 6:
				break;
			default:
				System.out.println("Invalid Value");
				break;
			}
			if(selection == 6) {
				break;
			}
		}
	}
	@SuppressWarnings("resource")
	public static void Chair(Person person,int flag) {
		Scanner myObj = new Scanner(System.in);
		int quantity,ID;
		String name,surname,password,mail,model,color,adress,number;
		System.out.println("\nWhich Model ? \n");
		OfficeChairs.printModels();
		System.out.println("\nPlease enter the name of model:");
		model = myObj.nextLine();
		if(OfficeChairs.chair_model_control(model)) {
			System.out.println("\nWhich Color ? \n");
			OfficeChairs.printColors();
			System.out.println("\nPlease enter the name of color:");
			color = myObj.nextLine();
			if(OfficeChairs.chair_color_control(color)) {
				if(flag == 1) {
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(employee.addChair(model, color,quantity)) {
						System.out.println("Products have been added!");
					}
				}
				else if(flag == 2) {
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(!employee.removeChair(model, color, quantity)) {
						System.out.println("This product is not been in branch!");
					}
					else {
						System.out.println("\nWhich customer do you want to sell to?\n");
						employee.printCustomers();
						System.out.println("Please enter an ID(If you want to add new customer press '0'): ");
						ID = myObj.nextInt();
						if(ID == 0) {
							myObj.nextLine();
							System.out.println("Please enter a customer name:");
							name = myObj.nextLine();
							System.out.println("Please enter a customer surname:");
							surname = myObj.nextLine();
							System.out.println("Please enter a customer mail:");
							mail = myObj.nextLine();
							System.out.println("Please enter a customer password:");
							password = myObj.nextLine();
							if(employee.getCompany().addCustomer(name, surname, mail, password, employee.getCompany())) {
								ID = Customer.getCustomerNumber();
							}
						}
						if(employee.search_customer(ID) != null) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							employee.search_customer(ID).addOrder(adress, number,new OfficeChairs(model,color,null).toString().substring(2), quantity);
						}
						else {
							if(ID == 0) {
								System.out.println("This person is already been in company!");
							}
							else {
								System.out.println("Invalid Value");
							}
						}
					}
				}
				else {
					Customer customer = (Customer)person;
					searchChair(customer,model,color);
				}
			}
			else {
				System.out.println("Wrong Color name!");
			}
		}
		else {
			System.out.println("Wrong model name!");
		}
	}
	@SuppressWarnings({ "resource", "unused" })
	public static void searchChair(Customer customer,String model,String color) {
		int option,quantity;
		OfficeChairs chair = null;
		Scanner myObj = new Scanner(System.in);
		String adress,number;
		if(customer.search_chair(model, color,chair) != null) {
			chair = customer.search_chair(model, color,chair);
			System.out.println("The product has been found!");
			System.out.println(chair + " in " + chair.getBranchname());
			System.out.println("Do you want to buy ? \n1.Yes\n2.No");
			option = myObj.nextInt();
			switch (option) {
			case 1:
				System.out.println("How many ? ");
				quantity = myObj.nextInt();
				for(int i=0;i<customer.getCompany().getEmployees().size();i++) {
					if(customer.getCompany().getEmployees().get(i).getInformation().equals(chair.getBranchname())){
						if(customer.getCompany().getEmployees().get(i).removeChair(chair.getModel(),chair.getColor(),quantity)) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							customer.addOrder(adress, number, new OfficeChairs(model,color,null).toString().substring(2), quantity);
						}
						else {
							System.out.println("\nThere is not enough product!\n");
						}
					}

				}
				
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Value!");
				break;
			}
		}
		else {
			System.out.println("The product has not been found!");
		}
	}
	@SuppressWarnings("resource")
	public static void Desk(Person person,int flag) {
		Scanner myObj = new Scanner(System.in);
		String model,color,name,surname,mail,password,adress,number;
		int quantity,ID;
		System.out.println("\nWhich Model ? \n");
		OfficeDesks.printModels();
		System.out.println("\nPlease enter the name of model:");
		model = myObj.nextLine();
		if(OfficeDesks.desk_model_control(model)) {
			System.out.println("\nWhich Color ? \n");
			OfficeDesks.printColors();
			System.out.println("\nPlease enter the name of color:");
			color = myObj.nextLine();
			if(OfficeDesks.desk_color_control(color)) {
				if(flag == 1) {
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(employee.addDesk(model, color,quantity)) {
						System.out.println("Products have been added!");
					}
				}
				else if(flag == 2) {
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(!employee.removeDesk(model, color,quantity)) {
						System.out.println("This product is not been in branch!");
					}
					else {
						System.out.println("\nWhich customer do you want to sell to?\n");
						employee.printCustomers();
						System.out.println("Please enter an ID(If you want to add new customer press '0'): ");
						ID = myObj.nextInt();
						if(ID == 0) {
							myObj.nextLine();
							System.out.println("Please enter a customer name:");
							name = myObj.nextLine();
							System.out.println("Please enter a customer surname:");
							surname = myObj.nextLine();
							System.out.println("Please enter a customer mail:");
							mail = myObj.nextLine();
							System.out.println("Please enter a customer password:");
							password = myObj.nextLine();
							if(employee.getCompany().addCustomer(name, surname, mail, password, employee.getCompany())) {
								ID = Customer.getCustomerNumber();
							}
							
						}
						if(employee.search_customer(ID) != null) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							employee.search_customer(ID).addOrder(adress, number,new OfficeDesks(model,color,null).toString().substring(2), quantity);
						}
						else {
							if(ID == 0) {
								System.out.println("This person is already been in company!");
							}
							else {
								System.out.println("Invalid Value");
							}
						}
					}
				}
				else {
					Customer customer = (Customer)person;
					searchDesk(customer,model,color);
				}
			}
			else {
				System.out.println("Wrong Color name!");
			}
		}
		else {
			System.out.println("Wrong model name!");
		}
	}
	public static void searchDesk(Customer customer,String model,String color) {
		int option,quantity;
		OfficeDesks desk = null;
		Scanner myObj = new Scanner(System.in);
		String adress,number;
		if(customer.search_desk(model, color,desk) != null) {
			desk = customer.search_desk(model, color,desk);
			System.out.println("The product has been found!");
			System.out.println(desk + " in " + desk.getBranchname());
			System.out.println("Do you want to buy ? \n1.Yes\n2.No");
			option = myObj.nextInt();
			switch (option) {
			case 1:
				System.out.println("How many ? ");
				quantity = myObj.nextInt();
				for(int i=0;i<customer.getCompany().getEmployees().size();i++) {
					if(customer.getCompany().getEmployees().get(i).getInformation().equals(desk.getBranchname())){
						if(customer.getCompany().getEmployees().get(i).removeDesk(desk.getModel(),desk.getColor(),quantity)) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							customer.addOrder(adress, number, new OfficeDesks(model,color,null).toString().substring(2), quantity);
						}
						else {
							System.out.println("\nThere is not enough product!\n");
						}
					}
				}
	
				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Value!");
				break;
			}
		}
		else {
			System.out.println("The product has not been found!");
		}
	}
	@SuppressWarnings({ "resource" })
	public static void Cabinet(Person person,int flag) {
		Scanner myObj = new Scanner(System.in);
		String model,name,surname,mail,password,number,adress;
		int quantity,ID;
		System.out.println("\nWhich Model ? \n");
		OfficeCabinets.printModels();
		System.out.println("\nPlease enter the name of model:");
		model = myObj.nextLine();
		if(OfficeCabinets.cabinet_model_control(model)) {
			if(flag == 1) {
				System.out.println("How many ?");
				quantity = myObj.nextInt();
				BranchEmployees employee = (BranchEmployees)person;
				if(employee.addCabinet(model,quantity)) {
					System.out.println("Products have been added!");
				}
			}
			else if(flag == 2){
				System.out.println("How many ?");
				quantity = myObj.nextInt();
				BranchEmployees employee = (BranchEmployees)person;
				if(!employee.removeCabinet(model,quantity)) {
					System.out.println("This product is not been in branch!");
				}
				else {
					System.out.println("\nWhich customer do you want to sell to?\n");
					employee.printCustomers();
					System.out.println("Please enter an ID(If you want to add new customer press '0'): ");
					ID = myObj.nextInt();
					if(ID == 0) {
						myObj.nextLine();
						System.out.println("Please enter a customer name:");
						name = myObj.nextLine();
						System.out.println("Please enter a customer surname:");
						surname = myObj.nextLine();
						System.out.println("Please enter a customer mail:");
						mail = myObj.nextLine();
						System.out.println("Please enter a customer password:");
						password = myObj.nextLine();
						if(employee.getCompany().addCustomer(name, surname, mail, password, employee.getCompany())) {
							ID = Customer.getCustomerNumber();
						}
					}
					if(employee.search_customer(ID) != null) {
						myObj.nextLine();
						System.out.println("Please enter an addres:");
						adress = myObj.nextLine();
						System.out.println("Please enter an number:");
						number = myObj.nextLine();
						employee.search_customer(ID).addOrder(adress, number,new OfficeCabinets(model,null).toString().substring(2), quantity);
					}
					else {
						if(ID == 0) {
							System.out.println("This person is already been in company!");
						}
						else {
							System.out.println("Invalid Value");
						}
					}
				}
			}
			else {
				Customer customer = (Customer)person;
				searchCabinet(customer,model);
			}
		}
		else {
			System.out.println("Wrong model name!");
		}
	}
	public static void searchCabinet(Customer customer,String model) {
		int option,quantity;
		OfficeCabinets cabinet = null;
		Scanner myObj = new Scanner(System.in);
		String adress,number;
		if(customer.search_cabinet(model,cabinet) != null) {
			cabinet = customer.search_cabinet(model,cabinet);
			System.out.println("The product has been found!");
			System.out.println(cabinet + " in " + cabinet.getBranchname());
			System.out.println("Do you want to buy ? \n1.Yes\n2.No");
			option = myObj.nextInt();
			switch (option) {
			case 1:
				System.out.println("How many ? ");
				quantity = myObj.nextInt();
				for(int i=0;i<customer.getCompany().getEmployees().size();i++) {
					if(customer.getCompany().getEmployees().get(i).getInformation().equals(cabinet.getBranchname())){
						if(customer.getCompany().getEmployees().get(i).removeCabinet(cabinet.getModel(),quantity)) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							customer.addOrder(adress, number, new OfficeCabinets(model,null).toString().substring(2), quantity);
						}
						else {
							System.out.println("\nThere is not enough product!\n");
						}
					}
				}

				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Value!");
				break;
			}
		}
		else {
			System.out.println("The product has not been found!");
		}
	}
	@SuppressWarnings({ "resource" })
	public static void Bookcase(Person person,int flag) {
		Scanner myObj = new Scanner(System.in);
		String model,name,surname,mail,password,number,adress;
		int quantity,ID;
		System.out.println("\nWhich Model ? \n");
		BookCases.printModels();
		System.out.println("\nPlease enter the name of model:");
		model = myObj.nextLine();
		if(BookCases.bookcase_model_control(model)) {
			if(flag == 1) {
				System.out.println("How many ?");
				quantity = myObj.nextInt();
				BranchEmployees employee = (BranchEmployees)person;
				if(employee.addBookcase(model,quantity)) {
					System.out.println("Products have been added!");
				}
			}
			else if(flag == 2) {
				System.out.println("How many ?");
				quantity = myObj.nextInt();
				BranchEmployees employee = (BranchEmployees)person;
				if(!employee.removeBookcase(model,quantity)) {
					System.out.println("This product is not been in branch!");
				}
				else {
					System.out.println("\nWhich customer do you want to sell to?\n");
					employee.printCustomers();
					System.out.println("Please enter an ID(If you want to add new customer press '0'): ");
					ID = myObj.nextInt();
					if(ID == 0) {
						myObj.nextLine();
						System.out.println("Please enter a customer name:");
						name = myObj.nextLine();
						System.out.println("Please enter a customer surname:");
						surname = myObj.nextLine();
						System.out.println("Please enter a customer mail:");
						mail = myObj.nextLine();
						System.out.println("Please enter a customer password:");
						password = myObj.nextLine();
						if(employee.getCompany().addCustomer(name, surname, mail, password, employee.getCompany())) {
							ID = Customer.getCustomerNumber();
						}
					}
					if(employee.search_customer(ID) != null) {
						myObj.nextLine();
						System.out.println("Please enter an addres:");
						adress = myObj.nextLine();
						System.out.println("Please enter an number:");
						number = myObj.nextLine();
						employee.search_customer(ID).addOrder(adress, number,new BookCases(model,null).toString().substring(2), quantity);
					}
					else {
						if(ID == 0) {
							System.out.println("This person is already been in company!");
						}
						else {
							System.out.println("Invalid Value");
						}
					}
				}
			}
			else {
				Customer customer = (Customer)person;
				searchBookcase(customer,model);
			}
		}
		else {
			System.out.println("Wrong model name!");
		}
	}
	public static void searchBookcase(Customer customer,String model) {
		int option,quantity;
		BookCases bookcase = null;
		Scanner myObj = new Scanner(System.in);
		String adress,number;
		if(customer.search_bookcase(model,bookcase) != null) {
			bookcase = customer.search_bookcase(model,bookcase);
			System.out.println("The product has been found!");
			System.out.println(bookcase + " in " + bookcase.getBranchname());
			System.out.println("Do you want to buy ? \n1.Yes\n2.No");
			option = myObj.nextInt();
			switch (option) {
			case 1:
				System.out.println("How many ? ");
				quantity = myObj.nextInt();
				for(int i=0;i<customer.getCompany().getEmployees().size();i++) {
					if(customer.getCompany().getEmployees().get(i).getInformation().equals(bookcase.getBranchname())){
						if(customer.getCompany().getEmployees().get(i).removeBookcase(bookcase.getModel(),quantity)) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							customer.addOrder(adress, number, new BookCases(model,null).toString().substring(2), quantity);
						}
						else {
							System.out.println("\nThere is not enough product!\n");
						}
					}
				}

				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Value!");
				break;
			}
		}
		else {
			System.out.println("The product has not been found!");
		}
	}
	@SuppressWarnings("resource")
	public static void Meetingtable(Person person,int flag) {
		Scanner myObj = new Scanner(System.in);
		String model,color,name,surname,mail,password,adress,number;
		int quantity,ID;
		System.out.println("\nWhich Model ? \n");
		MeetingTables.printModels();
		System.out.println("\nPlease enter the name of model:");
		model = myObj.nextLine();
		if(MeetingTables.meetingtable_model_control(model)) {
			System.out.println("\nWhich Color ? \n");
			MeetingTables.printColors();
			System.out.println("\nPlease enter the name of color:");
			color = myObj.nextLine();
			if(MeetingTables.meetingtable_color_control(color)) {
				if(flag == 1) {
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(employee.addMeetingtable(model, color,quantity)) {
						System.out.println("Products have been added!");
					}
				}
				else if(flag == 2){
					System.out.println("How many ?");
					quantity = myObj.nextInt();
					BranchEmployees employee = (BranchEmployees)person;
					if(!employee.removeMeetingtable(model, color,quantity)) {
						System.out.println("This product is not been in branch!");
					}
					else {
						System.out.println("\nWhich customer do you want to sell to?\n");
						employee.printCustomers();
						System.out.println("Please enter an ID(If you want to add new customer press '0'): ");
						ID = myObj.nextInt();
						if(ID == 0) {
							myObj.nextLine();
							System.out.println("Please enter a customer name:");
							name = myObj.nextLine();
							System.out.println("Please enter a customer surname:");
							surname = myObj.nextLine();
							System.out.println("Please enter a customer mail:");
							mail = myObj.nextLine();
							System.out.println("Please enter a customer password:");
							password = myObj.nextLine();
							if(employee.getCompany().addCustomer(name, surname, mail, password, employee.getCompany())) {
								ID = Customer.getCustomerNumber();
							}
						}
						if(employee.search_customer(ID) != null) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							employee.search_customer(ID).addOrder(adress, number,new MeetingTables(model,color,null).toString().substring(2), quantity);
						}
						else {
							if(ID == 0) {
								System.out.println("This person is already been in company!");
							}
							else {
								System.out.println("Invalid Value");
							}
						}
					}
				}
				else {
					Customer customer = (Customer)person;
					searchMeetingtable(customer,model,color);
				}
			}
			else {
				System.out.println("Wrong Color name!");
			}
		}
		else {
			System.out.println("Wrong model name!");
		}
	}
	public static void searchMeetingtable(Customer customer,String model,String color) {
		int option,quantity;
		MeetingTables table = null;
		Scanner myObj = new Scanner(System.in);
		String adress,number;
		if(customer.search_desk(model, color,table) != null) {
			table = customer.search_desk(model, color,table);
			System.out.println("The product has been found!");
			System.out.println(table + " in " + table.getBranchname());
			System.out.println("Do you want to buy ? \n1.Yes\n2.No");
			option = myObj.nextInt();
			switch (option) {
			case 1:
				System.out.println("How many ? ");
				quantity = myObj.nextInt();
				for(int i=0;i<customer.getCompany().getEmployees().size();i++) {
					if(customer.getCompany().getEmployees().get(i).getInformation().equals(table.getBranchname())){
						if(customer.getCompany().getEmployees().get(i).removeMeetingtable(table.getModel(),table.getColor(),quantity)) {
							myObj.nextLine();
							System.out.println("Please enter an addres:");
							adress = myObj.nextLine();
							System.out.println("Please enter an number:");
							number = myObj.nextLine();
							customer.addOrder(adress, number, new MeetingTables(model,color,null).toString().substring(2), quantity);
						}
						else {
							System.out.println("\nThere is not enough product!\n");
						}
					}
				}

				break;
			case 2:
				break;
			default:
				System.out.println("Invalid Value!");
				break;
			}
		}
		else {
			System.out.println("The product has not been found!");
		}
	}
}










