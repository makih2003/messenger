import java.util.ArrayList;

/**
 * The Messenger class contains all of the information about users and the messages they send to other
 * Each Messenger object contains an ArrayList that represents the username of people who use the server, 
 * and an ArrayList that contains all Messages sent
 * @author Maki Hosokawa
 *
 */
public class Messenger {
	private ArrayList<User> usersInfo;
	private ArrayList<Message> messageSent;
	
	
	/**
	 * This constructor constructs a Messenger that initializes both ArrayList to be empty
	 */
	public Messenger() {
		usersInfo = new ArrayList<User>();
		messageSent = new ArrayList<Message>(); 
	}
	
	/**
	 * This method adds the parameter to usersInfo ArrayList
	 * It throws NullPointerException if null is passed to its parameter
	 * returns true if user added successfully, false otherwise
	 * @param username
	 * @param password
	 */
	public boolean addUser(String username, String password) {
		if(username == null || password == null) {
			throw new NullPointerException("parameter cannot be null"); 
		}
		
		if(password.length() < 7 || isUserExist(username)) {
			return false;
		}
		
		for(int i = 0; i < usersInfo.size(); i++) {
			if(usersInfo.get(i).getUsername().equals(username)) { 
				return false;
			}
		}
		
		usersInfo.add(new User(username, password));
		return true;
	}
	
	
	/**
	 * This method checks if both username AND password are valid
	 * It throws NullPointerException if null is passed to its parameter
	 * returns true if both username AND password are valid, false otherwise
	 * @param username
	 * @param password
	 */
	public boolean isValidInfo(String username, String password) {
		if(username == null || password == null) {
			throw new NullPointerException("parameter cannot be null"); 
		}
		
		for(int i = 0; i < usersInfo.size(); i++) {
			if(usersInfo.get(i).getUsername().equals(username) && usersInfo.get(i).getPassword().equals(password)) { 
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method checks if username already exists
	 * It throws NullPointerException if null is passed to its parameter
	 * returns true if the username already exists, false otherwise
	 * @param username
	 */
	public boolean isUserExist(String username) {
		if(username == null) {
			throw new NullPointerException("parameter cannot be null"); 
		}
		
		for(int i = 0; i < usersInfo.size(); i++) {
			if(usersInfo.get(i).getUsername().equals(username)) { 
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method creates and adds a message to the ArrayList using the information in the parameter
	 * Status will be unread
	 * It throws NullPointerException if null is passed to its parameter
	 * @param sender sender's username
	 * @param receiver receiver's username
	 * @param text text of the Message
	 */
	public void sendMessage(String sender, String receiver, String text) {
		if(sender == null || receiver == null || text == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		boolean isSenderFound = false;
		boolean isRecFound = false;
		for(int i = 0; i < usersInfo.size() && (!isSenderFound || !isRecFound); i++) {
			if(usersInfo.get(i).getUsername().equals(sender)) {
				isSenderFound = true;
			}
			
			if(usersInfo.get(i).getUsername().equals(receiver)) {
				isRecFound = true;
			}
		}
		
		if(!isSenderFound || !isRecFound) {
			throw new IllegalArgumentException("sender or/and receiver were not in the list");
		}
		
		Message m1 = new Message(text,sender,receiver);
		messageSent.add(m1);
	}
	
	
	/**
	 * returns an ArrayList of Messages that contains messages sent to username(parameter)
	 * It throws NullPointerException if null is passed to its parameter
	 * @param username
	 * @return receivedMessages an ArrayList of Messages that contains the messages sent to username(parameter)
	 */
	public ArrayList<Message> getReceiveMessages(String username){
		if(username == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		ArrayList<Message> receivedMessages = new ArrayList<Message>();
		for(int i = 0; i < messageSent.size(); i++) {
			String rec = messageSent.get(i).getRecUserName();
			if(rec.equals(username)) {
				receivedMessages.add(messageSent.get(i));
			}
		}
		return receivedMessages;
	}
	
	/**
	 * returns an ArrayList of Messages that contains messages sent to username(parameter) with msgStatus (Status of the Message)
	 * this method throws NullPointerException if null is passed to its parameter
	 * @param username
	 * @return receivedMessages an ArrayList of Messages that contains the messages sent to username(parameter) with msgStatus (Status of the Message)
	 */ 
	public ArrayList<Message> getReceiveMessages(String username, Message.Status msgStatus){
		if(username == null || msgStatus == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		ArrayList<Message> receivedMessages = new ArrayList<Message>();
		for(int i = 0; i < messageSent.size(); i++) {
			String rec = messageSent.get(i).getRecUserName();
			if(rec.equals(username) && messageSent.get(i).getMessageStatus() == msgStatus) {
				receivedMessages.add(messageSent.get(i));
			}
		}
		return receivedMessages;
		
	}
	
	
	/**
	 * send a smile message
	 * this method throw NullPointerException when null is passed to its parameter
	 * @param from sender
	 * @param to recipient
	 */
	public void sendSmile(String from, String to) {
		if(from == null || to == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		SmileMessage sm = new SmileMessage(from, to);
		messageSent.add(sm);
	}
	
	/**
	 * returns the ArrayList of users information
	 * @return the ArrayList of users information
	 */
	public ArrayList<User> getUsersInfo(){
		ArrayList<User> temp = new ArrayList<User>(usersInfo);
		return temp;
	}
	
}
