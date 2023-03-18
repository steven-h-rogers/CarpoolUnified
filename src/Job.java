import java.time.LocalTime;
import java.util.random.RandomGenerator;

public class Job {
    int jobId; // Randomized integer value between 1 to 100000
    DummyUser user;
    String jobType;
    long jobDeadline;
    int redundancy;
    long userDuration;// job duration entered by user
    long actualDuration; // Actual Time to be calculated for job completion
    long startTime;
    long endTime;


    public Job(DummyUser user, String jobType, long deadline, long duration, int redundancy)
    {
        this.jobType = jobType;
        this.jobDeadline = deadline;
        this.userDuration= duration;
        this.redundancy = redundancy;

        RandomGenerator random = new RandomGenerator() {
            @Override
            public long nextLong() {
                return 0;
            }
        };

        // Generate a random integer between 1 and 100 and assign it to the jobId variable
        jobId = random.nextInt(100000) + 1;
    }

    public long calculateDuration(){
      this.actualDuration= endTime-startTime;

        return actualDuration;

    }

    void deliver(){

    }








}
