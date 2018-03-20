import java.util.Random;

/**
 * Class represents an undergraduate customer, extends
 * Student class.
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public class Ugrad extends Student{
    /**
     * Constructor for Ugrad class
     * @param id  identication number of the student
     * @param arrivalRate  average arrival rate of student
     * @param serviceRate  average service time of student
     */
    public Ugrad(int id, double arrivalRate, double serviceRate){
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
