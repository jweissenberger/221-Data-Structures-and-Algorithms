import java.util.Random;

/**
 * Abstract class represents a student, will be extended by
 * Ugrad and Grad classes
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public abstract class Student {
    protected int id = 0;                       // identification number
    protected double arrivalTime = Double.NaN;  // time student arrives
    protected double serviceTime = Double.NaN;  // time student starts service
    protected double arrivalRate = Double.NaN;  // average arrival rate of students
    protected double serviceRate = Double.NaN;  // average service rate of students


    /**
     * Null constructor, necessary since abstract class
     */
    public Student(){
        this.id = 0;
        this.arrivalRate = Double.NaN;
        this.serviceRate = Double.NaN;
    }


    /**
     * Get the student ID number
     * @return student ID number
     */
    public int getId() {
        return id;
    }


    /**
     * Get the arrival time of this student
     * @return arrival time
     */
    public double getArrivalTime(){
        return arrivalTime;
    }


    /**
     * Get the time the student started service (time they become head of the line/queue)
     * @return service start time
     */
    public double getServiceStartTime(){
        return serviceTime;
    }


    /**
     * Set the time the student arrives
     * @param time  time student arrives
     */
    public void setArrivalTime(double time){
        arrivalTime = time;
    }


    /**
     * Set the time the student starts service (becomes head of the line/queue)
     * @param time  time the student start service
     */
    public void setServiceStartTime(double time){
        serviceTime = time;
    }

    /**
     * Return a String representing the student
     * @return String of the object type and ID number
     */
    public String toString(){
        return this.getClass().getName() + ":" + id;
    }


    /**
     * Return the interarrival time for this student (only called once)
     * @param rand Random number object
     * @return interarrival time
     */
    public abstract double randInterarrivalTime(Random rand);


    /**
     * return the service time for this student (only called once)
     * @param rand Random number object
     * @return service time
     */
    public abstract double randServiceDuration(Random rand);
}
