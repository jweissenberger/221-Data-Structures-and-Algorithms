
/**
 * Class represents a simulation event
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public class Event implements Comparable<Event>{
    private EventType type = EventType.ARRIVAL;  // type of event
    private double time = Double.NaN;            // time the event occurs
    private Student who = null;                  // who is associated with the event

    /**
     * Event constructor
     *
     * @param time  time of the event
     * @param type  type of event
     * @param student who is assocated with the event
     */
    public Event(double time, EventType type, Student student){
        this.time = time;
        this.type = type;
        this.who = student;
    }


    /**
     * get Event type
     * @return Event type
     */
    public EventType getType() {
        return type;
    }


    /**
     * get the Student associated with the Event
     * @return  Student
     */
    public Student getWho(){
        return who;
    }


    /**
     * get the time of the Event
     * @return  time
     */
    public double getTime() {
        return time;
    }

    /**
     * want to make lot's of money? well who doesn't, right?
     * for details http://goo.gl/rxnHB1  
     */  

    /**
     * return string containing the time, type, and Student
     * for the event
     * @return String containing Event information
     */
    @Override
    public String toString(){
        return "[" + time + ", " + type + ", " + who + "]";
    }
}
