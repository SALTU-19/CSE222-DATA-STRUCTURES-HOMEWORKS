import java.io.IOException;
import java.util.Queue;
import java.util.Scanner;

public class tester {

	public static void main(String[] args) throws IOException {
		int selection=0;
		String name,password;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Alaca Shop");
		Company company = new Company();

		while(selection != 5) {
			System.out.println("1.Register as trader\n2.Register as customer \n3.Log In as trader\n4.Log In as customer\n5.Quit");
			selection = scan.nextInt();
			scan.nextLine();
			switch (selection) {
				case 1:
					System.out.println("Please enter a name:");
					name = scan.nextLine();
					System.out.println("Please enter a password(This must be greater than 6 character):");
					password = scan.nextLine();
					int ID = company.register(name, password, 2);
					if(ID != -1) {
						System.out.println("Registiration is valid!");
						System.out.println("Your ID is: " + ID);
						System.out.println("Please take note your ID!");
					}
					else {
						System.out.println("Registiration is invalid! Because password hasn't 6 character");
					}
					break;
				case 2:
					System.out.println("Please enter a name:");
					name = scan.nextLine();
					System.out.println("Please enter a password(This must be greater than 6 character):");
					password = scan.nextLine();
					ID = company.register(name, password, 1);
					if(ID != -1) {
						System.out.println("Registiration is valid!");
						System.out.println("Your ID is: " + ID);
						System.out.println("Please take note your ID!");
					}
					else {
						System.out.println("Registiration is invalid! Because password hasn't 6 character");
					}					
					break;
				case 3:
					System.out.println("Please enter your ID:");
					name = scan.next();
					System.out.println("Please enter your password:");
					password = scan.next();					
					Trader trader = (Trader)company.LogIn(name, password, 2);
					if(trader != null) {
						trader(trader);
					}
					else {
						System.out.println("Your ID or password wrong!");
					}
					break;
				case 4:
					System.out.println("Please enter your ID:");
					name = scan.next();
					System.out.println("Please enter your password:");
					password = scan.next();					
					Customer customer = (Customer)company.LogIn(name, password, 1);
					if(customer != null) {
						customer(customer);
					}
					else {
						System.out.println("Your ID or password wrong!");
					}
					break;
		
				default:
					break;
			}
		}

	}
	public static void trader(Trader trader) throws IOException {
		int selection=0,option;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome !");
		String ID,name,category,describtion;
		double price,discounted_price;
		while(selection != 5) {
			System.out.println("Which operation do you want to run ? ");
			System.out.println("1.Add product\n2.Remove Product\n3.Edit Product\n4.Approve Order\n5.Return menu");
			selection = scan.nextInt();
			scan.nextLine();
			switch (selection) {
			case 1:
				System.out.println("Please enter an product ID:");
				ID = scan.next();
				scan.nextLine();
				System.out.println("Please enter an product name:");
				name = scan.nextLine();
				System.out.println("Please enter an product category(e. g. book:childbook:babybook ):");
				category = scan.nextLine();
				System.out.println("Please enter an product price:");
				price = scan.nextDouble();
				System.out.println("Please enter an product discounted_price:");
				discounted_price = scan.nextDouble();
				scan.nextLine();
				System.out.println("Please enter an product describtion:");
				describtion = scan.nextLine();
				Product product = new Product(ID, name, category, price, discounted_price, describtion, trader.getName());
				if(trader.addProduct(product)) {
					System.out.println("This product have been added!");
				}
				else {
					System.out.println("This product have already been added!");
				}
				break;
			case 2:
				System.out.println("Please enter an product ID:");
				ID = scan.next();
				scan.nextLine();
				if(trader.removeProduct(ID)) {
					System.out.println("This product have been removed!");
				}
				else {
					System.out.println("This product has not been in your envanter!");
				}
				break;
				
			case 3:
				System.out.println("Please enter an product ID:");
				ID = scan.next();
				scan.nextLine();
				System.out.println("Please enter a new  product price:");
				price = scan.nextDouble();
				scan.nextLine();
				if(trader.editProduct(ID, price, 1)) {
					System.out.println("This product have been edited!");
				}
				else {
					System.out.println("This product has not been in your envanter!");
				}
				break;
				
			case 4:
				Queue<Order> orders = trader.printOrder();
				if(orders == null) {
					System.out.println("There is no order!");
				}
				else {
					System.out.println("Do you want to approve product ?(Yes: 1 , No: 2) ");
					option = scan.nextInt();
					scan.nextLine();
					if(option == 1)
						trader.approveOrder(orders);
				}
				break;
			case 5:
				break;

			default:
				break;
			}
		}
		
	}
	public static void customer(Customer customer) throws IOException{
		int selection=0,selection2=0,option=0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome !");
		String name,category,ID;
		double filtre,filtre2;
		while(selection != 3) {
			System.out.println("Which operation do you want to run ? ");
			System.out.println("1.Search Product\n2.Print One trader envanter\n3.Quit");
			selection = scan.nextInt();
			scan.nextLine();
			switch (selection) {
			case 1:
				System.out.println("Please enter a name which search ? ");
				name = scan.nextLine();
				System.out.println("How would you like to sort? ");
				System.out.println("1.Name 2.Price 3.Trader name 4. DiscountPercentage");
				selection2 = scan.nextInt();
				scan.nextLine();
				BinarySearchTree<Product> products = customer.searchProduct(name, selection2);
				if(products != null) {
					System.out.println("Would you like to see just once category ? (e.g. Clothing) (Yes:1 No:2)");
					option = scan.nextInt();
					scan.nextLine();
					if(option == 1) {
						System.out.println("Please enter the category name:");
						category = scan.nextLine();
						customer.Category(products, category);
					}
					System.out.println("Would you like to see filtre ? (e.g. Between 200-300 price) (Yes:1 No:2)");
					option = scan.nextInt();
					scan.nextLine();				
					if(option == 1) {
						System.out.println("Please enter the first filtre:");
						filtre = scan.nextDouble();
						scan.nextLine();
						System.out.println("Please enter the second filtre:");
						filtre2 = scan.nextDouble();
						scan.nextLine();
						customer.Filtre(products, filtre, filtre2);
					}
					System.out.println("Would you like to buy ?  (Yes:1 No:2)");
					option = scan.nextInt();
					scan.nextLine();
					if(option == 1) {
						System.out.println("Please enter product ID:");
						ID = scan.nextLine();
						customer.giveOrder(products, ID);
					}
				}
				else {
					System.out.println("The name is not have been this shop!");
				}
				break;
			case 2:
				System.out.println("Please enter a trader name:");
				name = scan.nextLine();
				
				if(!customer.searchTrader(name)){
					System.out.println("Wrong name!");
				}
				
				break;
			case 3:
				break;

			default:
				break;
			}
		}
	}
}
