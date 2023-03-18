import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class userCRUD {
    public static void main(String[] args) {
        try {
            File myObj = new File("src/db/users.txt");
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);

            int i = 0;
            while (myReader.hasNextLine()) {


                if (i == 0) { //header
                    String header = myReader.nextLine();
                    String[] header_attributes = header.split(",");

                    for (String attribute : header_attributes){
                        System.out.println(attribute);
                    }


                } else { //data
                    String userEntry = myReader.nextLine();
                    System.out.println(userEntry);
                }

                i++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
