/**
 * 
 * @author alien
 * 
 */
public class AbstractUser implements User {
	private int ID;
	private String password;
	private String name;
	/**
	 * 
	 * @param name set name user
	 * @param password set password user
	 */
	public AbstractUser(String name,String password) {
		super();
		setName(name);
		setPassword(password);
	}
	/**
	 * 
	 * @return ID
	 */
	protected int getID() {
		return ID;
	}
	/**
	 * 
	 * @param iD ID
	 */
	protected void setID(int iD) {
		ID = iD;
	}
	/**
	 * 
	 * @return password
	 */
	protected String getPassword() {
		return password;
	}
	/**
	 * 
	 * @param password password
	 */
	protected void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 
	 * @return name
	 */
	protected String getName() {
		return name;
	}
	/**
	 * 
	 * @param name name
	 */
	protected void setName(String name) {
		this.name = name;
	}
	
}
