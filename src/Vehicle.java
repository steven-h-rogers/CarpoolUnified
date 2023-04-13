public class Vehicle {

    public DummyUser user;
    public String userId;
    public String make ;
    public String model ;
    public int year;
    public String plateNumber ;
    public String stateRegistered;


    public Vehicle(DummyUser user, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
    }

    public Vehicle(String userID, String make, String model, int year, String plateNumber, String stateRegistered)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.plateNumber = plateNumber;
        this.stateRegistered = stateRegistered;
        this.userId = userID;
    }




}
