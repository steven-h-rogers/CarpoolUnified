public class Requests {

    public Job jobRequest;

    public Donation donRequest;

    public int sentinel = 0;

    public class Donation {
        public Vehicle vehicle;
        public int duration;

        public Donation(Vehicle vehicle, int duration){
            this.vehicle = vehicle;
            this.duration= duration;

        }

    }
    public Requests(Job job){

        if(this.sentinel == 0){
            this.jobRequest = job;
        }
        this.sentinel = 1;
    }

    public Requests(Donation donation){
        if(this.sentinel == 0){
            this.donRequest = donation;
        }
        this.sentinel = 1;
    }



}
