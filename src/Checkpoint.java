import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Checkpoint {
    String FILE_NAME = generateFileName();

    String DIVIDER = "-   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -   -";
    String HEADING_STRING = "";
    String TIME_STRING = "";
    String USERS_STRING = "";
    String VEHICLES_STRING = "";
    String JOBS_STRING = "";

    String FILE_STRING =
            HEADING_STRING
            + TIME_STRING
            + USERS_STRING
            + VEHICLES_STRING
            + JOBS_STRING;

    public Checkpoint() {
        this.printFile();
    }


    public String captureHeading() {

        this.HEADING_STRING += "CARPOOL (c) 2023";
        this.HEADING_STRING += "\n";
        this.HEADING_STRING += "Created By: Asm, Steven, Maya, Maria, Fairooz";
        this.HEADING_STRING += "\n";
        this.HEADING_STRING += this.DIVIDER;
        this.HEADING_STRING += "\n";

        return this.HEADING_STRING;
    }

    public String generateFileName(){
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E-MMM-dd-yyyy-HH-mm-ss");
        String formattedDate = myDateObj.format(myFormatObj);

        return "checkpoint-" + formattedDate.toLowerCase() + ".txt";

    }

    public String captureTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);

        this.TIME_STRING += "Time of Capture: "+ formattedDate;
        this.TIME_STRING += "\n";
        this.TIME_STRING += this.DIVIDER;
        this.TIME_STRING += "\n";

        return this.TIME_STRING;

    }

    public String captureUsers() {
        this.USERS_STRING += "USERS:";
        this.USERS_STRING += "\n";

        //loop through users retrieved from database in the future
        for (int i = 0; i < 3; i++) {
            this.USERS_STRING += i + ". ";
            this.USERS_STRING += "Sem";
            this.USERS_STRING += "\n";
        }


        this.USERS_STRING += this.DIVIDER;
        this.USERS_STRING += "\n";

        return this.USERS_STRING;
    }

    public String captureVehicles() {
        this.VEHICLES_STRING += "VEHICLES:";
        this.VEHICLES_STRING += "\n";


        //loop through vehicles retrieved from database in the future
        for (int i = 0; i < 3; i++) {
            this.VEHICLES_STRING += i + ". ";
            this.VEHICLES_STRING += "Toyota";
            this.VEHICLES_STRING += "\n";
        }



        this.VEHICLES_STRING += this.DIVIDER;
        this.VEHICLES_STRING += "\n";

        return this.VEHICLES_STRING;
    }

    public String captureJobs() {
        this.JOBS_STRING += "JOBS:";
        this.JOBS_STRING += "\n";


        //loop through vehicles retrieved from database in the future
        for (int i = 0; i < 3; i++) {
            this.JOBS_STRING += i + ". ";
            this.JOBS_STRING += "Assigned by";
            this.JOBS_STRING += "\n";
        }



        this.JOBS_STRING += this.DIVIDER;
        this.JOBS_STRING += "\n";

        return this.JOBS_STRING;
    }

    public String capture() {
        String c_heading = captureHeading();
        String c_time = captureTime();
        String c_users = captureUsers();
        String c_vehicles = captureVehicles();
        String c_jobs = captureJobs();

        String c_output = c_heading + c_time + c_users + c_vehicles + c_jobs;


        this.FILE_STRING = c_output;
        return c_output;
    }

    public String printFile() {
        capture();
        System.out.println(this.FILE_STRING);

        return this.FILE_STRING;
    }

    public void exportFile() throws IOException {

        //check if folder exists, if not, create it
//        File theDir = new File("/checkpoints");
//        if (!theDir.exists()){
//            theDir.mkdirs();
//        }

        //Path path = Paths.get("checkpoints/" + this.FILE_NAME);
        String contents = this.FILE_STRING;


        try(FileWriter writer = new FileWriter(this.FILE_NAME)) {
            writer.write(contents);
            writer.close();
            System.out.println("Exported to: " + this.FILE_NAME);

        }
        catch(IOException e){
            // Handle the exception
            e.printStackTrace();

        }

//        try {
//            Files.writeString(path, contents, StandardCharsets.UTF_8);
//
//            File output = new File("checkpoints/" + this.FILE_NAME);
//            FileWriter writer = new FileWriter(output);
//
//            writer.write("This text was written with a FileWriter");
//            writer.flush();
//            writer.close();
//        } catch (IOException ex) {
//            // Handle exception
//
//
//        }
    }



    public static void main(String[] args) throws IOException {

        Checkpoint cp1 = new Checkpoint();

        cp1.exportFile();

    }
}