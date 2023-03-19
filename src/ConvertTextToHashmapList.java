import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class ConvertTextToHashmapList {

    List<Map<String , String>> UserMapList  = new ArrayList<Map<String,String>>();

    public ConvertTextToHashmapList(String filename) {

        try {
            File myObj = new File("src/db/" + filename);
            // Get the absolute path of file f
            String absolute = myObj.getAbsolutePath();
            System.out.println(absolute);

            Scanner myReader = new Scanner(myObj);

            // we are going to store all the users in an array of hashmaps


            int i = 0;
            String header, userEntry;
            String[] header_attributes = {};
            String[] user_attributes = {};

            HashMap<String, String> User = new HashMap<String, String>();

            while (myReader.hasNextLine()) {

                if (i == 0) { //header
                    header = myReader.nextLine();
                    header_attributes = header.split(",");

                    // length of attributes
                    // System.out.println(header_attributes.length);

                    // printing out each attribute

                    /*
                    for (String attribute : header_attributes){
                        System.out.println(attribute);
                    }
                    */


                } else { //data
                    userEntry = myReader.nextLine();
                    //System.out.println(userEntry);
                    user_attributes = userEntry.split(",");
                    //System.out.println(user_attributes[1]);


                    // clearing the hashmap before entering data
                    User.clear();

                    // making sure each user has a value for each header attribute
                    for (int k = 0; k < header_attributes.length; k++){
                        User.put(header_attributes[k], user_attributes[k]);
                    }

                    // after putting each user's data into user hash map, put
                    // everything into user hashmap list

                    // adding a new user to the hash map list
                    System.out.println(i);
                    System.out.println(User);
                    UserMapList.add(User);

                    //System.out.println(userEntry);
                    //System.out.println(User);
                }
                i++;


            }

            System.out.println(UserMapList);

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public List<Map<String , String>> returnHashmapList(){
        return UserMapList;
    }
    public static void main(String[] args) {
        ConvertTextToHashmapList a = new ConvertTextToHashmapList("vehicle.txt");
    }
}
