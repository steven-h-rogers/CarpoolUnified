import javax.swing.*;
import javax.swing.Action;
import java.awt.Desktop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Path;

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
    private JTextField JobId;
    private JLabel JobIDLabel;
    private JLabel UserIDLabel;
    private JTextField UserId;
    private JLabel SubmissionConfirmLabel;
    private JLabel JobCompletionLabel;

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
            SubmissionConfirmLabel.setText("Submission Complete!");

            //Random randomizer = new Random();
            String userID = UserId.getText();
            String jobID = JobId.getText();
            String jobType= JobType.getSelectedItem().toString();
            String deadline = DurationText.getText();
            String duration = MinutesTF.getText();
            //String completionTime= ""+b;
            //JobCompletionLabel.setText(completionTime);
            String userEntry = userID+","+jobID+","+jobType+","+deadline+","+duration;
            System.out.println(userEntry);

            String content = "";
            // just reading and saving
            try {
                File myObj = new File("src/db/" + "jobs.txt");
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
                        new FileOutputStream("src/db/jobs.txt"), "utf-8"))) {


                    writer.write(content + userEntry);
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



            CalculateJobCompletionTime cj = new CalculateJobCompletionTime();


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
            admin job = new admin();
            List<Map<String , String>> a = null;
            try {
                a = job.calculateJobDurationTimes("jobs.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            int b = Integer.parseInt(a.get(a.size()-1).get("JobCompletionTime"));

            HaveJobLabel.setText("Your job will be completed in "  + b+ " minutes.");
            SubmitButton.setText("Submit");

            //Home homePage = new Home(user);
            //frame.dispose();
        }
    }
}
