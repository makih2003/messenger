
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;


/**
 * The GUIMessanger class simulates the message system
 * User can signin, login, read, and send messages
 * @author Maki Hosokawa
 * 
 */
public class GUIMessenger extends Application{
	private BorderPane root;
	private Text header;
	private TextField usernameBox;
	private Text enterName;
	private PasswordField passwordBox;
	private TextField passwordDisplayBox;
	private Text password;
	private Button loginButton;
	private Button signinButton;
	private Button curUserButton;
	private Button logoutButton;
	private Button nextButton;
	private TextArea readarea;
	private Button loadAllButton;
	private Button loadUnreadButton;
	private TextField messageBox;
	private RadioButton smile;
	private RadioButton written;
	private Button sendButton;
	private ToggleGroup buttonGroup;
	private Messenger mgr;
	private String activeUser = "";
	private TextArea sendMessageArea;
	private ArrayList<Message> mg;
	private TabPane tabPane;
	private Tab t2;
	private Tab t3;
	private CheckBox c;
	private int readmsg = 1;
	
	
	public void messangerStart() {
		mgr = new Messenger();
	}
	
	
	public static void main(String[] args) {
		 launch(args);
	}
	
	@Override
	 public void start(Stage primaryStage) {
		messangerStart();
		root = new BorderPane();
		Font f = new Font(17);
		header = new Text("Please Login / Sign-in");
		header.setFont(f);
		HBox top = new HBox(10, header);
		top.setAlignment(Pos.CENTER);
		
		// Login / SignIn Tab (1st Tab)
		enterName = new Text("Username:   ");
		f = new Font(15);
		enterName.setFont(f);
		usernameBox = new TextField();
		HBox usernameContent = new HBox(enterName, usernameBox);
		usernameContent.setAlignment(Pos.CENTER);
		
		password = new Text("Password:    ");
		password.setFont(f);
		passwordBox = new PasswordField();
		passwordDisplayBox = new TextField();
		c = new CheckBox("Show Password");
		HBox.setMargin(c, new Insets(0,0,0,10));
		
		passwordDisplayBox.managedProperty().bind(c.selectedProperty());
		passwordDisplayBox.visibleProperty().bind(c.selectedProperty());
		passwordBox.managedProperty().bind(c.selectedProperty().not());
		passwordBox.visibleProperty().bind(c.selectedProperty().not());
		passwordDisplayBox.textProperty().bindBidirectional(passwordBox.textProperty());
	
		HBox passwordContent = new HBox(password, passwordBox, passwordDisplayBox);
		passwordContent.setAlignment(Pos.CENTER);
		
		loginButton = new Button("Login");
		signinButton = new Button("Sign-in");
		HBox.setMargin(signinButton, new Insets(0,0,0,20));
	
		HBox topButtons = new HBox(loginButton, signinButton);
		topButtons.setAlignment(Pos.CENTER);
		
		curUserButton = new Button("Active User");
		curUserButton.setDisable(true);
		HBox.setMargin(curUserButton, new Insets(0,0,0,20));
		logoutButton = new Button("Logout");
		logoutButton.setDisable(true);
		HBox.setMargin(logoutButton, new Insets(0,0,0,20));
		
		HBox bottomButtons = new HBox(curUserButton, logoutButton);
		bottomButtons.setAlignment(Pos.CENTER);
		
		VBox t1Content = new VBox(usernameContent, passwordContent, c, topButtons, bottomButtons);
		t1Content.setAlignment(Pos.CENTER);
		t1Content.setSpacing(10);
		
		loginButton.setOnAction(new UserSelectEventHandler());
		signinButton.setOnAction(new UserSigninEventHandler());
		curUserButton.setOnAction(new SetHeaderTextEventHandler());
		logoutButton.setOnAction(new LogoutEventHandler());
		
		Tab t1 = new Tab("Login / Sign-in", t1Content);
		
		// ReadMessages Tab (2nd Tab)
		readarea = new TextArea("No Message Displayed");
		readarea.setFont(Font.font("monospace"));
		readarea.setEditable(false);
		nextButton = new Button("Next");
		nextButton.setDisable(true);
		HBox subT2Content1 = new HBox(5, readarea, nextButton); 
		subT2Content1.setAlignment(Pos.CENTER);
		loadAllButton = new Button("Load All Messages");
		loadUnreadButton = new Button("Load Unread Messages");
		HBox subT2Content2 = new HBox(5, loadAllButton, loadUnreadButton);
		subT2Content2.setAlignment(Pos.CENTER);
		subT2Content2.setPadding(new Insets(5, 0, 0, 0));
		
		BorderPane t2Content = new BorderPane();
		t2Content.setCenter(subT2Content1);
		t2Content.setBottom(subT2Content2);
		t2 = new Tab("Read Messages", t2Content);
		t2Content.setPadding(new Insets(5)); 
		
		LoadMsgEventHandler lm = new LoadMsgEventHandler();
		loadAllButton.setOnAction(lm);
		loadUnreadButton.setOnAction(lm);
		nextButton.setOnAction(new NextMsgEventHandler());
		t2.setDisable(true);
		
		// SendMessage Tab (3rd Tab)
		Text to = new Text("To:  ");
		messageBox = new TextField();
		HBox h1 = new HBox(to, messageBox);
		h1.setPadding(new Insets(0, 0, 5, 0));
		
		sendMessageArea = new TextArea();
		sendMessageArea.setFont(Font.font("monospace"));
		
		Text messageType = new Text("Message Type  ");
		smile = new RadioButton("Smile");
		written = new RadioButton("Written");
		sendButton = new Button("Send");
		buttonGroup = new ToggleGroup();
		smile.setToggleGroup(buttonGroup);
		written.setToggleGroup(buttonGroup);
		written.setSelected(true);
		HBox h3 = new HBox(messageType, smile, written, sendButton);
		h3.setAlignment(Pos.CENTER);
		h3.setPadding(new Insets(5, 0, 0, 0));
		HBox.setMargin(sendButton, new Insets(0,0,0,40));
		
		sendButton.setOnAction(new SendMsgEventHandler());
		smile.setOnAction(new PutSmileEventHandler());
		written.setOnAction(new PutSmileEventHandler());
		
		VBox t3Content = new VBox(h1, sendMessageArea, h3);
		t3Content.setPadding(new Insets(5));
		
		t3 = new Tab("Send Message", t3Content);
		
		t3.setDisable(true);
		
		tabPane = new TabPane();
		root.setTop(top);
		tabPane.getTabs().addAll(t1, t2, t3);
		root.setCenter(tabPane);
			
		Scene scene = new Scene(root);
		primaryStage.setTitle("Messenger JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private void resetTextAreas() {
		usernameBox.setText("");
		passwordBox.setText("");
		messageBox.setText("");
		sendMessageArea.setText("");
	}
	
	private class LogoutEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			resetTextAreas();
			activeUser = "";
			t2.setDisable(true);
			t3.setDisable(true);
			header.setText("Logout Success");
			loginButton.setDisable(false);
			signinButton.setDisable(false);
			curUserButton.setDisable(true);
			logoutButton.setDisable(true);
			usernameBox.setDisable(false);
			passwordBox.setDisable(false);
			passwordDisplayBox.setDisable(false);
			c.setDisable(false);
		}
	}
	
	private class SetHeaderTextEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(!activeUser.equals("")) {
				header.setText("Current User: " + activeUser);
			}
		}
	}
	
	
	private class UserSigninEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			boolean isUserAdded = mgr.addUser(usernameBox.getText(), passwordBox.getText());
			
			if(isUserAdded) {
				header.setText("Current user: " + usernameBox.getText());
				activeUser = usernameBox.getText();
				readarea.setText("No Message Displayed");
				nextButton.setDisable(true);
				tabPane.getSelectionModel().select(t2);
				resetTextAreas();
				t2.setDisable(false);
				t3.setDisable(false);
				loginButton.setDisable(true);
				signinButton.setDisable(true);
				curUserButton.setDisable(false);
				logoutButton.setDisable(false);
				usernameBox.setDisable(true);
				passwordBox.setDisable(true);
				passwordDisplayBox.setDisable(true);
				c.setDisable(true);
			}else {
				Font f = new Font(15);
				header.setText("Invalid User Name / Password must be longer than 6 characters");
				header.setFont(f);
			}
		}
	}
	
	
	private class UserSelectEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			boolean isValidInfo = mgr.isValidInfo(usernameBox.getText(), passwordBox.getText());
			
			if(isValidInfo) {
				header.setText("Current user: " + usernameBox.getText());
				activeUser = usernameBox.getText();
				readarea.setText("No Message Displayed");
				nextButton.setDisable(true);
				tabPane.getSelectionModel().select(t2);	
				resetTextAreas();
				t2.setDisable(false);
				t3.setDisable(false);
				loginButton.setDisable(true);
				signinButton.setDisable(true);
				curUserButton.setDisable(false);
				logoutButton.setDisable(false);
				usernameBox.setDisable(true);
				passwordBox.setDisable(true);
				passwordDisplayBox.setDisable(true);
				c.setDisable(true);
			} else {
				header.setText("Incorrect Username / Password");
			}
		}
	}
	
	private class LoadMsgEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			readmsg = 1;
			if(!activeUser.equals("")) {
				if(e.getSource() == loadAllButton) {
					mg = mgr.getReceiveMessages(activeUser);
					if(mg.size() == 0) {
						header.setText("" + mg.size() + " message(s) loaded");
						readarea.setText("No Message Displayed");
					}else {
						mg.get(0).setMessageStatus(Message.Status.read);
						readarea.setText(mg.get(0).toString());
						header.setText("" + mg.size() + " message(s) loaded");
					}
				}else {
					mg = mgr.getReceiveMessages(activeUser, Message.Status.unread);
					if(mg.size() == 0) {
						header.setText("" + mg.size() + " message(s) loaded");
						readarea.setText("No Message Displayed");
					}else {
						mg.get(0).setMessageStatus(Message.Status.read);
						readarea.setText(mg.get(0).toString());
						header.setText("" + mg.size() + " message(s) loaded");
					}
				}
				
				
				if(mg.size() > 1) {
					nextButton.setDisable(false);
				}else {
					nextButton.setDisable(true);
				}
			}
		}
	}
	
	private class NextMsgEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(readmsg < mg.size()) {
				mg.get(readmsg).setMessageStatus(Message.Status.read);
				readarea.setText(mg.get(readmsg).toString());
				readmsg ++;
				if(readmsg >= mg.size()) {
					nextButton.setDisable(true);
				}
			}
		}
	}
	
	private class SendMsgEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(!activeUser.equals("")) {
				if(mgr.isUserExist(messageBox.getText())) {
					if(written.isSelected()) {
						mgr.sendMessage(activeUser,messageBox.getText(), sendMessageArea.getText());
						header.setText("Message Successfully Sent");
					}else {
						mgr.sendSmile(activeUser,messageBox.getText());
						header.setText("Smile Successfully Sent");
					}
					
				}else {
					header.setText("Recipient Username Not Found");
				}
			}
		}
	}
	
	private class PutSmileEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			if(!activeUser.equals("")) {
				if(smile.isSelected()) {
					sendMessageArea.setText(SmileMessage.SMILE);
					sendMessageArea.setEditable(false);
				}else {
					sendMessageArea.setText("");
					sendMessageArea.setEditable(true);
				}
			}
		}
	}
}

