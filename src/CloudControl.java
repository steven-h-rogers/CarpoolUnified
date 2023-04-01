import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    /*
         ==============MILESTONE 5================

    Functionality needed to be added to this class:
    1-needs a modular queue of requests to be loaded in so that the controller can accept/reject as requests come in
    2-RequestInfoLabel needs to display information about the current request
    3-If CC accepts request, a message is sent to the client that says "request approved"
    4-If CC rejects request, a message is sent to the client that says "request denied"

    **note**
    Somehow, the Server object must connect to this gui so that it can load the requestInfo into the queue
     */


public class CloudControl implements ActionListener {
    JFrame frame = new JFrame("Cloud Controller");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JLabel logoLabel;
    private JButton AcceptButton;
    private JButton RejectButton;
    private JLabel RequestInfoLabel;
    private JButton DisconnectButton;

    public CloudControl(){
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //Adds Button Functionalities
        AcceptButton.addActionListener(this);
        RejectButton.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }





}
