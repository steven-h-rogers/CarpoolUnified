import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.Year;
import java.util.Random;
import java.util.Scanner;

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

            Random randomizer = new Random();
            int userNum = randomizer.nextInt(10000);
            int jobNum = randomizer.nextInt(10000);
            int vin = randomizer.nextInt(100000);
            String userID = ""+userNum;
            String VIN = ""+vin;
            String carmake = MakeTF.getText();
            String carmodel = ModelTF.getText();
            String caryear = YearTF.getText();
            String carplateNum = PlateTF.getText();
            String stateReg = StateTF.getText();
            String vehicleEntry = userID+","+VIN+","+carmake+","+carmodel+","+caryear+","+carplateNum+","+stateReg;
            System.out.println(vehicleEntry);

            String content = "";
            // just reading and saving
            try {
                File myObj = new File("src/db/" + "vehicle.txt");
                // Get the absolute path of file f
                String absolute = myObj.getAbsolutePath();
                System.out.println(absolute);
                Scanner myReader = new Scanner(myObj);

                int i = 0;
                String line;

                while (myReader.hasNextLine()) {
                    line = myReader.nextLine();
                    content += line + "\n";
                    //content += "\n";

                    i++;
                }


                System.out.println(content);

                myReader.close();

                // just writing
                try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                        new FileOutputStream("src/db/vehicle.txt"), "utf-8"))) {

                    writer.write(content + vehicleEntry);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            } catch (FileNotFoundException ppp) {
                //System.out.println("An error occurred.");
                ppp.printStackTrace();
            }









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
