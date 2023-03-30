import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

	/*
	    ==============MILESTONE 5================
		This class will need to be modified in order to add requests to the cloud controller request queue
		1- method to send accept message back to client
		2- method to send reject message back to client
	 */



	static ServerSocket serverSocket;
	static Socket socket;
	static DataInputStream inputStream;
	static DataOutputStream outputStream;

	public Server(){}

	public static void run() {

		String messageIn = "";
		String messageOut = "";
		Scanner keyInput;

		try {

			System.out.println("----------$$$ This is server side $$$--------");
			System.out.println("wating for client to connect...");
			// creating the server
			serverSocket = new ServerSocket(9806);
			// sever accepts connection request from client
			socket = serverSocket.accept();
			System.out.println("client is connected!");
			System.out.println("go to client side and send me a message");

			// server reads a message message from client
			inputStream = new DataInputStream(socket.getInputStream());

			// server sends a message to client
			outputStream = new DataOutputStream(socket.getOutputStream());

			// as long as message is not exit keep reading and sending message to client
			while (!messageIn.equals("exit")) {

				// extract the message from client
				messageIn = inputStream.readUTF();
				// server prints the message received from client to console
				System.out.println("message received from client: " + "\"" + messageIn + "\"");

				// ********************************************************
				// server reads a message from keyboard
				System.out.println("Enter a message you want to send to client side: ");
				keyInput = new Scanner(System.in);
				messageOut = keyInput.nextLine();
				// server sends the message to client
				outputStream.writeUTF(messageOut);
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
