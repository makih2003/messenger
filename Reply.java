/**
 * Each Reply object has a msg(Message) that this Reply is answering to
 * @author Maki Hosokawa
 */
public class Reply extends Message{
	private Message msg;
	
	/**
	 * constructor that makes a Reply object
	 * @param text 
	 * @param senderUserName
	 * @param recUserName
	 * @param m msg(Message) that this Reply is answering
	 */
	public Reply(String text, String senderUserName, String recUserName, Message m) {
		super(text, senderUserName, recUserName);
		
		if(m == null) {
			throw new NullPointerException("Parameter cannot be null");
		}
		
		msg = m;
	}
	
	/**
	 * make a string that has all the information of the Reply and the messages that this Reply is answering
	 * @Override
	 */
	public String toString() {
		String str = super.toString();
		str += "------------------------ Replying To ------------------------\n";
		str += msg.toString();
		return str;
	}
}