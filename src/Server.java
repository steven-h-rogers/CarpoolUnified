import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
    static Requests recieved;
    private boolean approved;
    String messageIn = "";
    String messageOut = "";
    public Server(){}
    public boolean isAccepted(Boolean approved){
        return this.approved=approved;
    }
    public  void run() {



        try {

            System.out.println("----------$$$ This is server side $$$--------");
            System.out.println("wating for client to connect...");
            // creating the server
            serverSocket = new ServerSocket(9806);
            // sever accepts connection request from client
            socket = serverSocket.accept();
            System.out.println("client is connected!");


            // server reads a message message from client
            inputStream = new DataInputStream(socket.getInputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            // server sends a message to client
            outputStream = new DataOutputStream(socket.getOutputStream());
            recieved = (Requests) objectInputStream.readObject();
            System.out.println(recieved.jobRequest.jobType);


            // as long as message is not exit keep reading and sending message to client
           /* while (!messageIn.equals("exit")) {


                // extract the message from client
                messageIn = inputStream.readUTF();
                // server prints the message received from client to console
                System.out.println("message received from client: " + "\"" + messageIn + "\"");

                // ********************************************************

                //System.out.println("Enter a message you want to send to client side: ");

                if(isAccepted == true)
                {
                    messageOut = "Your request has been accepted!";
                }
                else
                {
                    messageOut = "Your request has been rejected.";
                }

                // server sends the message to client
                outputStream.writeUTF(messageOut);
            }
        */

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    public void respond () {
        try {
            if (approved == true) {
                messageOut = "Your request has been accepted!";
            } else {
                messageOut = "Your request has been rejected.";
            }
            outputStream.writeUTF(messageOut);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }}





