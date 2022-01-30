import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class Customer extends AbstractUser {

	private static int id = 30000000;
	/**
	 * Consturcter
	 * @param name
	 * @param password
	 */
	public Customer(String name,String password) {
		super(name,password);
		setID(id);
		id++;
	}
	/**
	 * 
	 * @param products
	 * @param category
	 */
	public void Category(BinaryTree<Product> products,String category) {
		
		if(products == null) {

			return;
		}
		if(products.getData().getCategory().contains(category)) {
			System.out.println(products.getData());
		}
		
		Category(products.getLeftTree(), category);
		Category(products.getRightTree(), category);
		
	}
	/**
	 * 
	 * @param products products
	 * @param filtre
	 */
	public void Filtre(BinaryTree<Product>products,double filtre,double filtre2) {
		if(products == null) {

			return;
		}
		if(products.getData().getPrice() < filtre2 && products.getData().getPrice() > filtre) {
			System.out.println(products.getData());
		}
		
		Filtre(products.getLeftTree(), filtre,filtre2);
		Filtre(products.getRightTree(), filtre,filtre2);		
	}
	/**
	 * search product
	 * @param product product name
	 * @param option which option to sort
	 * @return products
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public BinarySearchTree<Product> searchProduct(String product,int option) throws IOException {
		BinarySearchTree<Product> products = new BinarySearchTree<Product>();
		File csvFile = new File("products.txt");
		String category;
		boolean flag = false;
		double filtre;
		if (csvFile.isFile()) {
	
			BufferedReader csvReader = new BufferedReader(new FileReader("products.txt"));
			String row;
			while (true) {
				row = csvReader.readLine();
				if(row != null){
					String[] data = row.split(";");
					if(data[1].contains(product)) {

						Product product1 = new Product(data[0],data[1],data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]),data[5],data[6]);
						product1.setCompare(option);
						if(products.add(product1)) {
							
							flag = true;
						}
						continue;
					}
					else if(data.length > 5 && data[5].contains(product)) {
						Product product1 = new Product(data[0],data[1],data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]),data[5],data[6]);
						product1.setCompare(option);
						if(products.add(product1)) {
							
							flag = true;
						}
						continue;
					}
				}
				else {
					
					break;
				}
			}


		}
		if(flag == false) {

			return null;
		}
		products.printTree();
		return products;
	}
	/**
	 * search trader 
	 * @param trader trader name
	 * @return true or false
	 * @throws IOException
	 */
	public boolean searchTrader(String trader) throws IOException {
		boolean flag= false;
		File csvFile = new File("products.txt");
		Hashtable<Product, String> products = new Hashtable<>();
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader("products.txt"));
			String row;
			while (true) {
				row = csvReader.readLine();
				if(row != null){
					String[] data = row.split(";");
					if(data[6].equals(trader)) {
						
						Product product1 = new Product(data[0],data[1],data[2],Double.parseDouble(data[3]),Double.parseDouble(data[4]),data[5],data[6]);
						flag = true;
						products.put(product1, data[6]);
					}
				}
				else {
					csvReader.close();
					break;
				}
			}
		}
		if(flag == false)
			return false;
		

		Enumeration<Product> keys = products.keys();
		 
		while(keys.hasMoreElements()){
		    System.out.println(keys.nextElement());
		}
		
		return true;
	}
	/**
	 * 
	 * @param products searched products
	 * @param ID product ID
	 * @throws IOException
	 */
	public void giveOrder(BinaryTree<Product> products,String ID) throws IOException {
		if(products == null) {
			
			return;
		}
		if(products.getData().getID().equals(ID)) {
			File file = new File("orders.txt");
			BufferedWriter write = new BufferedWriter(new FileWriter("orders.txt",true));			
			if(file.isFile()) {
				write.append(products.getData().getID() + ";" +products.getData().getName()+ ";" + products.getData().getCategory()+ ";" + Double.toString(products.getData().getPrice())+ ";" + Double.toString(products.getData().getDiscounted())+ ";" + products.getData().getDescribtion()+ ";" + products.getData().getTrader() + ";" + Integer.toString(getID()) + "\n");
			}
			write.close();
		}

		
		giveOrder(products.getLeftTree(), ID);
		giveOrder(products.getRightTree(), ID);		
	}
}
