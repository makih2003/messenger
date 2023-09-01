/**
 * Each User class object contains username and password
 * @author Maki Hosokawa
 */
public class User{
	private String username;
	private String password;
	
	
	/**
	 * This constructor creates a User object
	 * @param sender
	 * @param recipient
	 */
	public User(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	/**
	 * get the username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * get the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * set new username
	 */
	public void setUsername(String username) {
		if (username == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		this.username = username;
	}
	
	/**
	 * set new password
	 */
	public void setPassword(String password) {
		if (password == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		this.password = password;
	}
}