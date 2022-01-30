import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Company {
	@SuppressWarnings("deprecation")
	private static void readFile(String filename) throws IOException {
		File csvFile = new File(filename);
		ArrayList<Trader> traders = new ArrayList<Trader>();
		int count=0;
		Integer password = new Integer(200000);
		if (csvFile.isFile()) {
			BufferedReader csvReader = new BufferedReader(new FileReader(filename));
			BufferedWriter csvWriter = new BufferedWriter(new FileWriter("products.txt"));
			String row;
			while (true) {
				row = csvReader.readLine();
				if(row != null){
				    String[] data = row.split(";");
				    csvWriter.append(data[0]);
				    csvWriter.append(";");
				    csvWriter.append(data[1]);
				    csvWriter.append(";");
					data[2] = data[2].substring(4,data[2].length()-4);
					String temp[] = data[2].split(" >>");
					for(int i=0;i<temp.length;i++) {
						if(i != 0)
							temp[i] = temp[i].substring(1, temp[i].length());
						if(i != temp.length -1)
							csvWriter.append(temp[i] + ":");
						else
							csvWriter.append(temp[i]);
					}
				 
				    csvWriter.append(";");
				    csvWriter.append(data[3]);
				    csvWriter.append(";");
				    csvWriter.append(data[4]);
				    csvWriter.append(";");
				    csvWriter.append(data[5]);
				    csvWriter.append(";");
				    csvWriter.append(data[6]);
				    if(count != 0) {
					    Trader trader = new Trader(data[6],password.toString());
					    if(!traders.contains(trader))
					    	traders.add(trader);
					    password++;
				    }
				    csvWriter.append("\n");		
				}
				else {
					csvReader.close();
					csvWriter.close();
					break;
				}
				count++;
			}
			BufferedWriter trader = new BufferedWriter(new FileWriter("users.txt"));
			for(Trader i:traders) {
				Integer ID = new Integer(i.getID());
				trader.append(ID.toString() + " ");
				trader.append(i.getName() + " ");
				trader.append(i.getPassword() + "\n");
			}
			trader.close();
		
		}		
	}
	/**
	 * Log in function
	 * @param ID
	 * @param password
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public AbstractUser LogIn(String ID,String password,int type) throws IOException {
		File file = new File("users.txt");
		BufferedReader user = new BufferedReader(new FileReader("users.txt"));
		String row;
		if(file.isFile()) {
			while(true) {
				row = user.readLine();
				if(row != null) {
					String[] data = row.split(" ");
					if(data[0].equals(ID) && data[2].equals(password)) {
						if(type == 1) {
							Customer user1 = new Customer(data[1],password);
							user1.setID(Integer.parseInt(ID));
							return user1;							
						}
						else {
							Trader user1 = new Trader(data[1],password);
							user1.setID(Integer.parseInt(ID));
							return user1;							
						}

					}						
				}
				else {
					user.close();
					break;
				}
			}
			
		}
		else {
			System.out.println("file error!");
		}
		user.close();
		return null;
	}
	/**
	 * Register function
	 * @param name
	 * @param password
	 * @param type
	 * @return
	 * @throws IOException
	 */
	public int register(String name,String password,int type) throws IOException {
		
		if(password.length() < 6) {
			return -1;
		}
		File file = new File("users.txt");

		FileWriter user = new FileWriter("users.txt",true);
		if(file.isFile()) {
			
			if(type == 1) {
				
				Customer customer = new Customer(name, password);
				Integer ID = new Integer(customer.getID());				
				user.write(ID.toString() + " ");
				user.write(customer.getName() + " ");
				user.write(customer.getPassword() + "\n");
				user.close();
				return customer.getID();
			}
			else {
				Trader trader = new Trader(name, password);
				Integer ID = new Integer(trader.getID());
				user.write(ID.toString() + " ");
				user.write(trader.getName() + " ");
				user.write(trader.getPassword() + "\n");
				user.close();
				return trader.getID();
			}
			
		}
		else {
			return -1;
		}
		
	}
	/**
	 * Constructer
	 * @throws IOException
	 */
	public Company() throws IOException{
		readFile("e-commerce-samples.csv");
	}
}
