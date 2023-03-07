import javax.swing.*;
import javax.swing.Action;
import java.awt.Desktop.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

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
