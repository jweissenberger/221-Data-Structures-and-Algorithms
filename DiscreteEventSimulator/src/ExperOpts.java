import java.io.*;
import java.util.Properties;

/**
 * Class reads the Java Properties file for the simulation experiment
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public class ExperOpts{
    private int seed = 0;                          // random number seed
    private int numUgrad = 0;                      // number of undergrads
    private int numGrad = 0;                       // number of grads
    private double ugradArrivalRate = Double.NaN;  // undergrad arrival rate
    private double ugradServiceRate = Double.NaN;  // undergrad service rate
    private double gradArrivalRate = Double.NaN;   // grad arrival rate
    private double gradServiceRate = Double.NaN;   // grad service rate
    private String message = "error: ";            // message about the experiment settings

    /**
     * Constructor for ExperOpts, reads the Properties file stored in args[0]
     * @param args  args[0] stores the name of the Properties file
     */
    public ExperOpts(String[] args) {
        Properties prop = new Properties();
        String configFile = args[0];
        try{
            InputStream is = new FileInputStream(configFile);

            // load the properties (configuration) file
            prop.load(is);

            // get the random number seed
            seed = Integer.parseInt(prop.getProperty("seed","1848"));
            // get the undergrad info
            numUgrad = Integer.parseInt(prop.getProperty("num.ugrad","0"));
            ugradArrivalRate = Double.parseDouble(prop.getProperty("arrival.ugrad","0"));
            ugradServiceRate = Double.parseDouble(prop.getProperty("service.ugrad","0"));

            // get the grad info
        }
        catch (IOException e){
            System.err.println("Error in configuration file " +  args[0]);
            // e.printStackTrace();
        }

        message = "experiment settings u: " + numUgrad + " (" + ugradArrivalRate + "/" + ugradServiceRate + "), g: "
                + numGrad + " (" + gradArrivalRate + "/" + gradServiceRate + ")";
    }


    /**
     * return the random number seed
     * @return seed
     */
    public int getSeed(){
        return seed;
    }

    /**
     * return the number of undergrad students
     * @return number of undergrads
     */
    public int getNumUgrad(){
        return numUgrad;
    }

    /**
     * return the undergrad arrival rate
     * @return undergrad arrival rate
     */
    public double getUgradArrivalRate(){
        return ugradArrivalRate;
    }


    /**
     * return the undergrad service rate
     * @return undergrad service rate
     */
    public double getUgradServiceRate(){
        return ugradServiceRate;
    }


    /**
     * return a message (String) about experiment parameters
     * @return String of the experiment parameters
     */
    public String getMessage(){
        return message;
    }


    /**
     * return the number of grad students
     * @return number of grads
     */
    public int getNumGrad(){
        return numGrad;
    }


    /**
     * return the grad arrival rate
     * @return grad arrival rate
     */
    public double getGradArrivalRate(){
        return gradArrivalRate;
    }

    /**
     * return the grad service rate
     * @return grad service rate
     */
    public double getGradServiceRate(){
        return gradServiceRate;
    }
}
