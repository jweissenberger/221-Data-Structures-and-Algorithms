
import java.util.*;

/**
 * Simulation driver (main) for CSC 221 project 3 (restaurant simulation)
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public class Simulation{
    public static void main(String[] args){
        ExperOpts experOpts = new ExperOpts(args);

        System.out.println(experOpts.getMessage());

	// create a list, called list,  containing Ugrad and Grad objects
        LinkedList<Student> student = new LinkedList<>();
	// create a queue, called queue, containing Ugrad and Grad objects (the line)
        Queue<Student> queue = new LinkedList<>();
	// create a queue, called calendar, containing the ordered Events
        Queue<Event> calendar = new LinkedList<>();
        Random rand = new Random(experOpts.getSeed());
        Statistic systemDelay = new Statistic();
        // create a Statistic to store delay results for waiting in the queue (line)
        Statistic queueDelay = new Statistic();

        Event currentEvent;
        Student currentStudent = null;
        double time = 0.0;

        // create the Ugrad student objects

        int studentCount = 0;
        for(int i = 0; i < experOpts.getNumUgrad(); i++) {
            student.add(new Ugrad(studentCount, experOpts.getUgradArrivalRate(), experOpts.getUgradServiceRate()));
            time += student.get(studentCount).randInterarrivalTime(rand);
            calendar.offer(new Event(time, EventType.ARRIVAL, student.get(studentCount)));
            studentCount++;
        }

        time = 0.0; // let's reset time to zero for the Grad inter-arrivals
        // create a loop, like the one above, that creates Grad objects and arrivals
        for(int i = 0; i < experOpts.getNumUgrad(); i++) {
            student.add(new Grad(studentCount, experOpts.getGradArrivalRate(), experOpts.getGradServiceRate()));
            time += student.get(studentCount).randInterarrivalTime(rand);
            calendar.offer(new Event(time, EventType.ARRIVAL, student.get(studentCount)));
            studentCount++;
        }

        while(!calendar.isEmpty()) {
            currentEvent = calendar.poll();
            time = currentEvent.getTime();
            currentStudent = currentEvent.getWho();
            // System.out.println("current event: " + currentEvent);
            switch(currentEvent.getType()){
                case ARRIVAL:
                    currentStudent.setArrivalTime(time);
                    // if the queue, then start the service
                    if(queue.isEmpty()){
                        currentStudent.setServiceStartTime(time);
                        calendar.offer(new Event(time + currentStudent.randServiceDuration(rand), EventType.DEPARTURE, currentStudent));
                    }
                    queue.offer(currentStudent);
                    break;
                case DEPARTURE:
                    Student removedStudent = queue.remove();
                    // let's make certain this DEPARTURE event is for the student at the head of the queue...
                    assert(removedStudent == currentStudent);
                    systemDelay.accept(time - currentStudent.getArrivalTime());
                    // if the queue is not empty, start service of next student
                    if(!queue.isEmpty()){
                        Student nextStudent = queue.peek();
                        nextStudent.setServiceStartTime(time);
                        // add calendar event for the nextStudent's DEPARTURE (see above)
                        calendar.offer(new Event(time + nextStudent.randServiceDuration(rand), EventType.DEPARTURE, nextStudent));
                    }
                    break;
                    default:
                        System.out.println("Event? " + currentEvent + " goto http://goo.gl/rxnHB1 for details");
            }
        }

       // print the queue delay, like how it is done below
        System.out.printf("System delay (queue + service) \n  avg: %6.3f(%5.3f),  min: %6.3f, max: %6.3f \n", systemDelay.getAverage(),
                systemDelay.getStandardDeviation(), systemDelay.getMin(), systemDelay.getMax());


        System.out.printf("System delay (queue + service) \n  avg: %6.3f(%5.3f),  min: %6.3f, max: %6.3f", systemDelay.getAverage(),
                systemDelay.getStandardDeviation(), systemDelay.getMin(), systemDelay.getMax());

    }
}
