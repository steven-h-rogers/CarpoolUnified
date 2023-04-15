import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Donor  {


    //should get information from vehicle owner, to be stored in file
    //vc controller will get time completion, gui completion time algorithm

    //account page will hold a terminate button
    int donationID;
    DummyUser donor;
    DummyUser renter;
    int userID;
    String plateNumber;
    String stateRegistered;
    LocalDateTime startTime;
    LocalDateTime endTime;
    int estimatedStay;
    int duration;
    boolean isActive;
    int priority;

    private java.time.LocalTime LocalTime;
    LocalTime vehicleResidencyTime = LocalTime;

    //this constructor will be used to generate Donation objects from queries
    public Donor(int donationID, int donorID, String plateNumber, String stateRegistered, int priority,
                 boolean isActive, LocalDateTime startTime, LocalDateTime endTime, int estimatedStay, int duration){

        this.donationID= donationID;
        this.userID = donorID;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.priority = priority;
        this.isActive = isActive;
        this.startTime = startTime;
        this.endTime = endTime;
        this.estimatedStay = estimatedStay;
        this.duration = duration;

    }

    public Donor (DummyUser user){

    }
    public void setPriority(int priority) {
        this.priority = priority;
    }

    void terminateDonation() {
        // detect time user will have


    }

    void update(){

    }

}
