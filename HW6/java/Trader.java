import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Trader extends AbstractUser {
	private static int id = 10000000;
	/**
	 * Constructer
	 * @param name name 
	 * @param password password
	 */
	public Trader(String name,String password) {
		super(name,password);
		setName(name);
		setID(id);
		id++;
	}
	/**
	 * equals
	 */
	@Override
	public boolean equals(Object o) {
		if(getName().equals((((Trader) o).getName()))) {
			return true;
		}
		return false;
	}
	/**
	 * addproduct
	 * @param product given product
	 * @return true or false
	 * @throws IOException
	 */
	public boolean addProduct(Product product) throws IOException {
		File file = new File("products.txt");
		BufferedReader read = new BufferedReader(new FileReader("products.txt"));
		String row;
		if(file.isFile()) {
			while(true) {
				row = read.readLine();
				if(row != null) {
					String[] data = row.split(";");
					if(data[0].equals(product.getID())){
					
						return false;
					}
				}
				else {
					break;
				}
			}
		}
		read.close();

		BufferedWriter write = new BufferedWriter(new FileWriter("products.txt",true));
		int count=0;
		if(file.isFile()) {
			write.append(product.getID() + ";" + product.getName() + ";");
			for(String i:product.getCategory()) {
				if(count != product.getCategory().size() -1)
					write.append(i + ":");
				else
					write.append(i);
				count++;
			}
			write.append(";" + Double.toString(product.getPrice()) + ";" + Double.toString(product.getDiscounted()) + ";" + product.getDescribtion() + ";" +product.getTrader() + "\n");
		}
		write.close();
		return true;
	}
	/**
	 * remove product
	 * @param ID product id 
	 * @return true or false
	 * @throws IOException
	 */
	public boolean removeProduct(String ID) throws IOException {
		boolean flag=false;
		File file = new File("products.txt");
		BufferedReader read = new BufferedReader(new FileReader("products.txt"));
		String row;
		LinkedList<String[]> products = new LinkedList<String[]>();
		if(file.isFile()) {
			while(true) {
				row = read.readLine();
				if(row != null) {
					String[] data = row.split(";");
					if(!data[0].equals(ID)) {
						products.add(data);
					}
					else {
						if(data[6].equals(getName())) {
							flag=true;
						}
						else {
							products.add(data);
						}
					}
				}
				else {
					break;
				}
			}
		}
		read.close();		
		if(flag == false)
			return false;
		else {
			BufferedWriter write = new BufferedWriter(new FileWriter("products.txt"));			
			if(file.isFile()) {
				for(String[] i:products) {
					write.append(i[0] + ";" + i[1] + ";" + i[2] + ";" + i[3] + ";" + i[4] + ";" + i[5] + ";" + i[6] + "\n");
				}
			}
			write.close();
			return true;
		}
	}
	/**
	 * 
	 * @param ID product ID
	 * @param price edit value
	 * @param choice which data edit
	 * @return true or false
	 * @throws IOException
	 */
	public boolean editProduct(String ID,double price ,int choice) throws IOException {
		boolean flag=false;
		File file = new File("products.txt");
		BufferedReader read = new BufferedReader(new FileReader("products.txt"));
		String row;
		LinkedList<String[]> products = new LinkedList<String[]>();
		if(file.isFile()) {
			while(true) {
				row = read.readLine();
				if(row != null) {
					String[] data = row.split(";");
					if(!data[0].equals(ID)) {
						products.add(data);
					}
					else {
						if(data[6].equals(getName())) {
							if(choice == 1)
								data[3] = Double.toString(price);
							else
								data[4] = Double.toString(price);
							products.add(data);
							flag=true;							
						}
						else {
							products.add(data);
						}

					}
				}
				else {
					break;
				}
			}
		}
		read.close();		
		if(flag == false)
			return false;
		else {
			BufferedWriter write = new BufferedWriter(new FileWriter("products.txt"));			
			if(file.isFile()) {
				for(String[] i:products) {
					write.append(i[0] + ";" + i[1] + ";" + i[2] + ";" + i[3] + ";" + i[4] + ";" + i[5] + ";" + i[6] + "\n");
				}
			}
			write.close();
			return true;
		}
	}
	/**
	 * 
	 * @param orders orders which wait approve
	 * @throws IOException
	 */
	public void approveOrder(Queue<Order> orders) throws IOException{
		boolean flag=false;
		File file = new File("orders.txt");
		BufferedReader read = new BufferedReader(new FileReader("orders.txt"));
		String row;
		LinkedList<String[]> temp = new LinkedList<String[]>();
		if(file.isFile()) {
			while(true) {
				row = read.readLine();
				if(row != null) {
					String[] data = row.split(";");
					if(!data[6].equals(getName())) {
						temp.add(data);
					}else {
						flag = true;
					}
				}
				else {
					read.close();
					break;
				}
			}
		}
		if(flag == true) {
			BufferedWriter write = new BufferedWriter(new FileWriter("orders.txt"));
			if(file.isFile()) {
				for(String[] i:temp) {
					write.append(i[0] + ";" + i[1] + ";" + i[2] + ";" + i[3] + ";" + i[4] + ";" + i[5] + ";" + i[6] + ";" + i[7] + "\n");
				}
			}
			write.close();
			for(Order i: orders) {
				
				removeProduct(i.getProduct().getID());
			}
		}
	}
	/**
	 * print waiting orders
	 * @return orders
	 * @throws IOException
	 */
	public Queue<Order> printOrder() throws IOException {
		boolean flag=false;
		File file = new File("orders.txt");
		
		String row;
		Queue<Order> orders = new LinkedList<Order>();
		LinkedList<String[]> temp = new LinkedList<String[]>();
		if(file.isFile()) {
			BufferedReader read = new BufferedReader(new FileReader("orders.txt"));
			while(true) {
				row = read.readLine();
				if(row != null) {
					String[] data = row.split(";");
					if(data[6].equals(getName())) {
						Product product = new Product(data[0], data[1], data[2], Double.parseDouble(data[3]),Double.parseDouble(data[4]), data[5], data[6]);
						Order order = new Order(data[7], product);
						orders.offer(order);
						flag = true;
					}
				}
				else {
					read.close();
					break;
				}
			}
		}

		if(flag == true) {
			for(Order i:orders) {
				System.out.println(i.getProduct());
			}
			return orders;
		}
		else
			return null;
	}
}