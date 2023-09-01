/**
 * The SmileMessage class that always set the text to a Smile
 * status will be unread
 * @author Maki Hosokawa
 */
public class SmileMessage extends Message{
	public static final String SMILE =  "***  ***\n"
			  							+"***  ***\n"
										+"***  ***\n"
										+ "		  \n"
										+ "*      *\n"
										+ " *    *\n"
										+ "  ****\n";
										
	
	/**
	 * This constructor creates a Message whose text is always a smile
	 * @param sender
	 * @param recipient
	 */
	public SmileMessage(String sender, String recipient) {
		super(SMILE, sender, recipient);
	}
	
	/**
	 * make a string containing the status, sender, and :) in text
	 * @return the summary of the message in one line
	 * @Override
	 */
	public String getPreview() {
		String preview = "Status: " + getMessageStatus() + " Sender: " + getSenderUserName() + " Message: :)";
		return preview;
	}
}