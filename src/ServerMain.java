public class ServerMain {
    /*
     ==============MILESTONE 5================
     Functionality needed to be added to this class:
     ~Optional~ Seperate cloud Controller login for the serverside. No sign up page, just username, password, login button that brings user to CloudController page
     1 creation and instantiation of server object
      */
    public static void main(String[] args) {

        CloudControl controller = new CloudControl();

        Server server = new Server();
        server.run();





    }



}
