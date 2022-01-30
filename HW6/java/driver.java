
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

public class driver {


	public static void main(String[] args) throws IOException {
		
		
		// company is created
		Company company = new Company();
		
		//Customer and Trader is registered
		company.register("Atakan", "123456", 1);
		company.register("Samet", "123456", 2);
		//password must be given 6 character
		if(company.register("Okan", "123", 1) == -1) {
			System.out.println("The password is invalid!");
		}
		
		//Customer and Trader is logined
		Trader trader = (Trader) company.LogIn("10000000", "200000",2);
		Customer customer = (Customer) company.LogIn("30000000", "123456", 1);
		
		
		//Trader addProduct function
		Product product = new Product("123", "Asfefwdge", "Baby Care:Infant Wear:Baby Boy's Clothes: Shorts", 200.0, 200.0, "short", "Alisha");
		if(trader.addProduct(product)) {
			System.out.println("The product has been added!");
		}
		product = new Product("SRTEH2FF9KEDEFGF", "Asfefwdge", "Baby Care:Infant Wear:Baby Boy's Clothes: Shorts", 200.0, 200.0, "short", "Alisha");
		if(!trader.addProduct(product)) {
			System.out.println("The product has not been added because the product has already been this company!");
		}
		//Trader removeProduct function
		if(trader.removeProduct("SRTEH2FF9KEDEFGF")) {
			System.out.println("The product has been removed!");
		}
		if(!trader.removeProduct("123")) {
			System.out.println("The product has not been removed because the product has not been this company!");
		}		
		
		//Trader editProduct function
		if(trader.editProduct("SRTEH2FF9KEDEFGF",100000.0,1)) {
			System.out.println("The product has been edited!");
		}
		if(!trader.editProduct("123",100000,1)) {
			System.out.println("The product has not been edited because the product has not been this company!");
		}
		
		
		

		//Customer searchtrader function this function search product to trader name
		customer.searchTrader("Alisha");
		if(customer.searchTrader("asdsf")) {
			System.out.println("This trader is not been in company");
		}
			

		
		//Customer search function decrasing order the name
		BinaryTree<Product> products = customer.searchProduct("Shorts",1);
		
		//Customer category function. this functions divide products to category
		customer.Category(products, "Clothing");
		
		//Customer filtre function. this functions filtre products to price
		customer.Filtre(products, 200,300);
		
		//Customer give order function	
		customer.giveOrder(products, "SRTEH2FF9KEDEFGF");
		customer.giveOrder(products, "SRTEH2FGBDJGX8FW");
		
		//Trader printorder function print order and return order
		Queue<Order> orders = trader.printOrder();
		
		//Trader approveorder function approve order and remove this products
		trader.approveOrder(orders);
	
		
	}

}
