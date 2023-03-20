public class DummyUser {

    //public int userID;
    public String username;
    public String password;
    public String fname;
    public String lname;
    public Boolean isDonor;
    public Vehicle vehicle;
    public Job job;
    boolean hasActiveDonation;

    public DummyUser(String username, String password)
    {
    this.username = username;
    this.password = password;

    this.fname = "Dummy";
    this.lname = "User";
    this.isDonor = false;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public Boolean getIsDonor()
    {
        return this.isDonor;
    }
    public Vehicle getVehicle()
    {
        return this.vehicle;
    }
    public Job getJob()
    {
        return this.job;
    }


    public void setVehicle(Vehicle vehicle)
    {
        this.vehicle = vehicle;
        this.isDonor = true;
    }

    public void setJob(Job job)
    {
        this.job = job;
        this.isDonor = false;
    }

    public void setActive(Boolean status)
    {
        this.hasActiveDonation = status;
    }

    public void setIsDonor(Boolean status)
    {
        this.isDonor = status;
    }

}
