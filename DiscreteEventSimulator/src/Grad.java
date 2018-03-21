import java.util.Random;

public class Grad extends Student{
    /**
     * Constructor for Grad class
     * @param id  identication number of the student
     * @param arrivalRate  average arrival rate of student
     * @param serviceRate  average service time of student
     */
    public Grad(int id, double arrivalRate, double serviceRate){
        this.id = id;
        this.arrivalRate = arrivalRate;
        this.serviceRate = serviceRate;
    }

    @Override
    public double randInterarrivalTime(Random rand) {
        return ExpoDistribution.next(arrivalRate, rand);
    }

    @Override
    public double randServiceDuration(Random rand) {
        return ExpoDistribution.next(serviceRate, rand);
    }

}
