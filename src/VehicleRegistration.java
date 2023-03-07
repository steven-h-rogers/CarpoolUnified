import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleRegistration implements ActionListener {
    JFrame frame = new JFrame("Registration");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Workspace;
    private JTextField MakeTF;
    private JLabel MakeLabel;
    private JLabel ModelLabel;
    private JButton registerButton;
    private JLabel ConfirmPasswordLabel;
    private JPanel Header;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JButton TutorialButton;
    private JButton AboutButton;
    private JButton AccountButton;
    private JTextField ModelTF;
    private JTextField YearTF;
    private JTextField PlateTF;
    private JTextField StateTF;
    private JPasswordField PwordTF;
    private JPanel back;

    public VehicleRegistration(DummyUser user)
    {
        frame.setContentPane(back);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        this.user = user;


        TutorialButton.addActionListener(this);
        AboutButton.addActionListener(this);
        AccountButton.addActionListener(this);
        registerButton.addActionListener(this);
        HomeButton.addActionListener(this);



    }



    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if(source == registerButton)
        {
            String password = String.valueOf(PwordTF.getPassword());
            if (password.equals(user.getPassword()))
            //and if all fields are legitimate
            {
                String make = MakeTF.getText();
                String model = ModelTF.getText();
                int year = Integer.parseInt(YearTF.getText());
                String plateNum = PlateTF.getText();
                String stateRegistered = StateTF.getText();

                Vehicle dummyVehicle = new Vehicle(user,make,model,year,plateNum,stateRegistered);
                user.setVehicle(dummyVehicle);
                user.setIsDonor(true);
                HowLong howLongPage = new HowLong(user);
                System.out.println("VREG");
                frame.dispose();

            }
        }
        if(source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }

    }
}
