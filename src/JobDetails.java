import javax.swing.*;
import javax.swing.Action;
import java.awt.Desktop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Scanner;

public class JobDetails implements ActionListener {
    JFrame frame = new JFrame("Job Information");
    DummyUser user;
    private JPanel BackgroundPanel;
    private JPanel Header;
    private JLabel logoLabel;
    private JToolBar Navbar;
    private JButton HomeButton;
    private JLabel HaveJobLabel;
    private JPanel Workspace;
    private JLabel MinutesLabel;
    private JTextField MinutesTF;
    private JButton SubmitButton;
    private JComboBox JobType;
    private JButton SelectFilesButton;
    private JLabel DurationLabel;
    private JTextField DurationText;

    public JobDetails(DummyUser user)
{
    frame.setContentPane(BackgroundPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    this.user = user;

    SelectFilesButton.addActionListener(this);
    HomeButton.addActionListener(this);
    SubmitButton.addActionListener(this);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == HomeButton)
        {
            Home homePage = new Home(user);
            frame.dispose();
        }
        if(source == SelectFilesButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            Action details = fileChooser.getActionMap().get("viewTypeDetails");
            details.actionPerformed(null);
            fileChooser.showOpenDialog(null);

            //this section will store the files that the user
            //selected

        }

        if (source== SubmitButton)
        {
            Random randomizer = new Random();
            int userNum = randomizer.nextInt(10000);
            int jobNum = randomizer.nextInt(10000);
            String userID = ""+userNum;
            String jobID = ""+jobNum;
            String jobType= JobType.getSelectedItem().toString();
            String duration = DurationText.getText();
            String completion = MinutesTF.getText();
            String userEntry = userID+","+jobID+","+jobType+","+duration+","+completion;
            System.out.println(userEntry);


            File myObj = new File("src/db/jobs.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream("src/db/jobs.txt"), "utf-8"))) {
                Path relative = Paths.get("src/db/jobs.txt");
                Scanner myReader = new Scanner(absolute);
               // myReader.useDelimiter("\\Z");
                String content = "";

                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    System.out.println(line);
                    content += line;
                }

                     System.out.println(content);

                writer.write(userEntry);
            } catch (FileNotFoundException ex) {
                throw new RuntimeException(ex);
            } catch (UnsupportedEncodingException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            ArrayList<String> jobSelection = new ArrayList<String>();
            ArrayList<String> timeDuration = new ArrayList<String>();
            ArrayList<String> timeCompletion = new ArrayList<String>();

            /*
            This section will take the job details, store them into
            a job object, stamp the start time, and retrieve stored file information
            to be sent to the CloudController object to assign vehicles to this job

            at the time of submission, the DBAccess object will store the information
            regarding the job into the database. Once a Job is complete, the DB access
            object will be called from the cloud controller to stamp the completion time
            and give a final update to the job
             */


            Home homePage = new Home(user);
            frame.dispose();
        }
    }
}
