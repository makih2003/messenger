# Messenger App
Messenger app built with JavaFX. In the first tab, the user can sign in, log in, and log out. A username and password are required in order to sign in and log in. In the second tab, they can read messages they have received. There are two buttons, one to display unread messages and the other to display all messages. In the third tab, they can send a message by typing it in or send a default smile message.

## Features
<img width="406" alt="Screenshot 2023-09-01 at 5 02 23 PM" src="https://github.com/makih2003/messenger/assets/139406942/d7c78b7a-6114-4112-8c54-c1627a3249f9">
<br>
Users need to sign in if they have not done so already. The password needs to be longer than 6 characters.
<br><br>

<img width="401" alt="Screenshot 2023-09-01 at 5 06 40 PM" src="https://github.com/makih2003/messenger/assets/139406942/c9262150-f3c5-4342-beec-3fb49825587b">
<br>
It shows an error message on the header if they try to log in to a non-existent account or username/password is incorrect. 
<br><br>

<img width="480" alt="Screenshot 2023-09-01 at 5 16 36 PM" src="https://github.com/makih2003/messenger/assets/139406942/e4d36112-8a6b-4ea0-8f5b-ab8aab1d2be6">
<br>
It shows a different error message on the header if the username is already registered or the password is shorter than 7 characters.
<br><br>
<img width="484" alt="Screenshot 2023-09-01 at 5 22 09 PM" src="https://github.com/makih2003/messenger/assets/139406942/c7adb73c-fa73-485e-949d-9ca1d6df431c">
<br>
After successfully signing in, the second tab (Read Messages tab) and third tab (Send Message) can be accessed. In the second tab, users can see all the messages they have received. When there are no received messages, "No Message Displayed" is shown in the text field, and the "next" button is disabled. On the header, the number of message(s) is displayed. 
<br><br>
<img width="476" alt="Screenshot 2023-09-01 at 5 32 48 PM" src="https://github.com/makih2003/messenger/assets/139406942/2edb3bc2-23e3-4645-98f9-6bd17f3784dc">
<br>
In the third tab, the user can send a message to other users or even themselves. 
<br><br>
<img width="485" alt="Screenshot 2023-09-01 at 5 35 40 PM" src="https://github.com/makih2003/messenger/assets/139406942/0342e4db-cbc7-491c-a697-3389281ad3ac">
<br>
They can send a written message or a default smile message. The default smile message is non-editable.
<br><br>
<img width="404" alt="Screenshot 2023-09-01 at 7 47 17 PM" src="https://github.com/makih2003/messenger/assets/139406942/5af11eba-0a42-4688-9036-f25160a36ee1">
<br>
It shows an error message on the header if the recipient does not exist.
<br><br>
<img width="477" alt="Screenshot 2023-09-01 at 5 42 48 PM" src="https://github.com/makih2003/messenger/assets/139406942/ce66ab67-5728-4960-a481-354ab3386ae3">
<br>
It shows a "Smile Successfully Sent" or "Message Successfully Sent" on the header if the recipient exists.
<br><br>
<img width="481" alt="Screenshot 2023-09-01 at 5 46 22 PM" src="https://github.com/makih2003/messenger/assets/139406942/cf741e83-a19a-41ac-aa56-1a586b0ea916">
<br>
Now if the user goes back to the first tab, they can only press the "Active User" button and the "Logout" button since they have already logged in. The "Active User" button displays the username on the header. To login into another account, they need to logout first.
<br><br>
<img width="479" alt="Screenshot 2023-09-01 at 5 50 05 PM" src="https://github.com/makih2003/messenger/assets/139406942/c7416d27-1e24-47a7-a027-3cc2e722d04b">
<br>
After pressing the "Logout" button, the user can now log in or sign in to another account.
<br><br>
<img width="481" alt="Screenshot 2023-09-01 at 5 59 22 PM" src="https://github.com/makih2003/messenger/assets/139406942/0f447cd4-32eb-44ee-96ec-2adae704b9ff">
<br>
In order to demonstrate sending and receiving messages between two different accounts, let's make another account.
<br><br>
<img width="476" alt="Screenshot 2023-09-01 at 6 01 46 PM" src="https://github.com/makih2003/messenger/assets/139406942/4991b657-d140-41f4-a460-5ac5505b7ad2">
<br>
<img width="484" alt="Screenshot 2023-09-01 at 7 28 06 PM" src="https://github.com/makih2003/messenger/assets/139406942/86c3dc71-cca8-44cb-9e92-d323a42bb18d">
<br>
Let's send 2 different messages to Maki from Chris.
<br><br>
<img width="484" alt="Screenshot 2023-09-01 at 7 33 25 PM" src="https://github.com/makih2003/messenger/assets/139406942/650cafe9-98f8-4b0f-ae4a-a8391a005e5a">
<br>
Go back to the first tab and log in as Maki.
<br><br>

<img width="485" alt="Screenshot 2023-09-01 at 7 31 02 PM" src="https://github.com/makih2003/messenger/assets/139406942/c4c1a72b-78a3-4324-b7f2-058d246a2561">
<br>
<img width="486" alt="Screenshot 2023-09-01 at 7 31 52 PM" src="https://github.com/makih2003/messenger/assets/139406942/4ae22a9d-295b-4640-b588-d1690b94072d">
<br>
The user can see both messages from Chris in the second tab. After reading the messages, its status becomes "read" from "unread".
<br><br>
<img width="484" alt="Screenshot 2023-09-01 at 7 36 53 PM" src="https://github.com/makih2003/messenger/assets/139406942/5d08ea1d-6843-4dd5-b184-ecad8d9e2446">
<br>
Now if the user clicks "Load Unread Messages", there are no messages to display since they read all the messages already.
<br><br>


## Prerequisites
1. Ensure to download JDK from <a href="https://jdk.java.net/20/">Official OpenJDK</a> website. The version "18.0.1.1" or higher is recommended.
2. In order to set up JavaFX environment, follow the instructions of <a href="[https://jdk.java.net/20/](https://openjfx.io/openjfx-docs/#install-javafx)https://openjfx.io/openjfx-docs/#install-javafx">JavaFX</a> website.

