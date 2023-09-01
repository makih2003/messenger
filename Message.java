/**
 * Each Message object contains the text of message, the sender's username, the recipient's username, and a status
 * status must be unread, read, or trash
 * @author Maki Hosokawa
 *
 */

public class Message{
	public enum Status {unread, read, trash};
	private String text;
	private String senderUserName;
	private String recUserName;
	private Status messageStatus;
	
	private static int nbrOfMessages = 0;
	private static int nbrOfChars = 0;
	

	/**
	 * This constructor constructs a Message object
	 * It throws NullPointerException if null is passed to its parameter
	 * @param text
	 * @param senderUserName
	 * @param recUserName(recipient username)
	 * @param status the status of the Message
	 */
	public Message(String text, String senderUserName, String recUserName, Status messageStatus) {
		if(text == null || senderUserName == null || recUserName == null || messageStatus == null) {
			throw new NullPointerException("parameter cannot be null");
		}
		
		this.text = text;
		this.senderUserName = senderUserName;
		this.recUserName = recUserName;
		this.messageStatus = messageStatus;
		nbrOfMessages ++;
		nbrOfChars += text.length();
	}
	
	/**
	 * This constructor constructs a Message object
	 * The status will be set to unread
	 * It throws NullPointerException if null is passed to its parameter
	 * @param text
	 * @param senderUserName
	 * @param recUserName(recipient username)
	 */
	public Message(String text, String senderUserName, String recUserName) {
		this(text, senderUserName, recUserName, Message.Status.unread);
	}
	
	/**
	 * get the text
	 * @return text of the current active Message object
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * get the sender's username
	 * @return senderUserName
	 */
	public String getSenderUserName() {
		return senderUserName;
	}
	
	/**
	 * get the recipient's username
	 * @return recUserName
	 */
	public String getRecUserName() {
		return recUserName;
	}
	
	/**
	 * get the status of the Message
	 * @return messageStatus
	 */
	public Status getMessageStatus() {
		return messageStatus;
	}
	
	/**
	 * set the Status of the Message
	 * This method throws NullPointerException if null is passed to its parameter
	 * @param msg Status to give to the current active Message
	 */
	public void setMessageStatus(Status msg) {
		if(msg == null) {
			throw new NullPointerException("parameter cannot be null"); 
		}
		messageStatus = msg;
	}
	
	/**
	 * make a string that has all the information of the Message
	 * @return summary of the Message
	 */
	public String toString() {
		String info = "From: " + senderUserName + "\nTo: " + recUserName + "\nStatus: " + messageStatus
				+ "\n" + text + "\n";
		return info;
	}
	
	/**
	 * calculate the total number of the Message sent
	 * @return the total number of the Message sent
	 */
	public static int getNbrOfMessages() {
		return nbrOfMessages;
	}
	
	/**
	 * calculate the total number of the characters in the Messages
	 * @return the total number of the characters in the Messages
	 */
	public static int getNbrOfChars() {
		return nbrOfChars;
	}
	
	/**
	 * make a string containing the status, sender, and the beginning of the text on one line 
	 * Maximum number of characters is 50 
	 * @return the summary of the message in one line
	 */
	public String getPreview() {
		String preview = "Status: " + messageStatus + " FROM: " + senderUserName + " TEXT: ";
		final int MAXIMUM_TEXT_SIZE = 50;
		String temp = getText();
		if(temp.length() > MAXIMUM_TEXT_SIZE) {
			temp = temp.replaceAll("\n", " ");
			temp = temp.substring(0,MAXIMUM_TEXT_SIZE);
		}else {
			temp = temp.replaceAll("\n", " ");
		}
		
		preview += temp;
		return preview;
	}
}