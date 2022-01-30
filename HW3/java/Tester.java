
public class Tester {

	public static void main(String[] args) {
		Company company = new Company("Coskun","Saltu","saltu@mail.com","5918");
		Administrator admin = company.getAdmin();
		BranchEmployees employee = company.getEmployees().get(0);
		Customer customer = company.getCustomers().get(0);
		if(admin.addBranche("Siirt")) {
			
			admin.printBranches();
			System.out.println("Siirt was added!\n");
		}
		if(admin.removeBranche("Siirt")) {
			admin.printBranches();
			System.out.println("Siirt was removed!\n");
		}
		if(!admin.removeBranche("Samsun")) {
			System.out.println("Samsun is not branchname!\n");
		}
		if(admin.addBranchEmployee("Atakan", "Altin", "altin@mail.com", "02315615616", "Corum", company)) {
			admin.printEmployees();
			System.out.println("Atakan Altin was added!\n");
		}
		if(admin.removeBranchEmployee("Atakan", "Altin",company)) {
			admin.printEmployees();
			System.out.println("Atakan Altin was removed!\n");
		}
		if(!admin.removeBranchEmployee("Taha", "Saltu",company)) {
	
			System.out.println("Taha Saltu is not  brancheemployee!\n");
		}
		if(employee.addChair("METALCHAIR", "RED")) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println("Red metalchair was added!");
			
		}
		if(!employee.addChair("chair", "orange")) {
			
			System.out.println("orange chair is not  chair model!");
			
		}
		if(employee.removeChair("METALCHAIR", "RED", 3)) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println(" 3 Red metalchair was removed!");
		}
		if(!employee.removeChair("METALCHAIR", "RED", 100)) {
			
			System.out.println(" 100 Red metalchair is not in branches!");
		}
		if(employee.addDesk("METALDESK", "RED")) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println("Red metaldesk was added!");
			
		}
		if(!employee.addDesk("desk", "orange")) {
			
			System.out.println("orange desk is not  desk model!");
			
		}
		if(employee.removeDesk("METALDESK", "RED", 3)) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println(" 3 Red METALDESK was removed!");
		}
		if(!employee.removeDesk("METALDESK", "RED", 100)) {
			
			System.out.println(" 100 Red metalchair is not in branches!");
		}
		if(employee.addMeetingtable("METALTABLE", "RED")) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println("Red METALTABLE was added!");
			
		}
		if(!employee.addMeetingtable("table", "orange")) {
			
			System.out.println("orange table is not  table model!");
			
		}
		if(employee.removeMeetingtable("METALTABLE", "RED", 3)) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println(" 3 Red METALTABLE was removed!");
		}
		if(!employee.removeMeetingtable("METALTABLE", "RED", 100)) {
			
			System.out.println(" 100 Red METALTABLE is not in branches!");
		}
		if(employee.addCabinet("METALCABINET")) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println("METALCABINET was added!");
			
		}
		if(!employee.addCabinet("whitecabinet")) {
			
			System.out.println("whitecabinet is not  cabinet model!");
			
		}
		if(employee.removeCabinet("METALCABINET", 3)) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println(" 3 Red metalchair was removed!");
		}
		if(!employee.removeCabinet("METALCABINET", 100)) {
			
			System.out.println(" 100  METALCABINET is not in branches!");
		}
		if(employee.addBookcase("METALBOOKCASE")) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println("METALBOOKCASE was added!");
			
		}
		if(!employee.addBookcase("orangebookcase")) {
			
			System.out.println("orangebookcase is not  bookcase model!");
			
		}
		if(employee.removeBookcase("METALBOOKCASE", 3)) {
			System.out.println(employee.getBranch().getInformation());
			System.out.println(" 3 METALBOOKCASE was removed!");
		}
		if(!employee.removeBookcase("METALBOOKCASE", 100)) {
			
			System.out.println(" 100 METALBOOKCASE is not in branches!");
		}
		try {
			employee.addMessages("METAL CHAIR IS DECREASE!");
			//employee.addMessages(null);
		}
		catch(Exception e) {
			System.out.println("Message is null");
		}
		System.out.println("Admin see the message\n"+  admin.getMessages().get(0) + "\n");
		
		customer.addOrder("BILECIK", "05565516", "desk", 6);
		System.out.println("\nOrder was added!");
		OfficeChairs chair = null;
		if(customer.search_chair("METALCHAIR", "RED", chair) != null){
			System.out.println("RED METALCHAIR is found!");
		}
	
		if(customer.search_desk("baddesk", "RED", new OfficeDesks(null, null, null)) == null){
			System.out.println("RED baddesk is not founded!");
		}
		if(customer.search_cabinet("METALCABINET", new OfficeCabinets(null, null)) != null) {
			System.out.println("METALCABINET is found!");
		}
		
		
	
		
			
		
		
	
		
	}

}
