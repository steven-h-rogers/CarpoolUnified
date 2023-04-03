import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminVCC {

    JFrame frame = new JFrame("Cloud Controller");
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton DiscButton;
    private JLabel logoLabel;
    private JButton AcceptButton;
    private JLabel RequestInfo;
    private JButton DeclineButton;
    public Server server;

    AdminVCC(Server server){
        frame.setContentPane(BackgroundPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.server = server;

    }

    public void actionPerformed(ActionEvent e) {
        //
        String messageIn = "";
        String messageOut = "";
        //
        Object source = e.getSource();
        if (source == AcceptButton) {
            server.isAccepted = true;
            Requests requests = server.recieved;

            frame.dispose();
        }
        if (source == DeclineButton) {
            server.isAccepted = false;
            frame.dispose();
        }
    }




}
