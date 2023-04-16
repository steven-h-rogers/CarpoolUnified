import java.sql.*;

public class UserDBAccess {
    private static Connection conn;

    public static void init() throws ClassNotFoundException {

        DBConnection.init("carpool");
    }


    public static Boolean usernameTaken(String username) throws SQLException{

        conn = DBConnection.getMyConnection();
        String query = ("SELECT userID FROM user WHERE username = ?;");
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        if (rs.next() == false){
            return false;
        }
        else return true;



    }











    private static DummyUser buildUser(ResultSet rs) throws SQLException{

        int userId = rs.getInt("userID");
        String username = rs.getString("username");
        String password = rs.getString("password");
        String fname = rs.getString("firstName");
        String lname = rs.getString("lastName");
        Boolean isDonor = rs.getBoolean("isDonor");
        Boolean hasDonation = rs.getBoolean("hasActiveDonation");
        Timestamp timestamp = rs.getTimestamp("created");

        DummyUser user = new DummyUser(userId,username,password,fname,lname,isDonor,hasDonation,timestamp);
        return user;


    }

}
