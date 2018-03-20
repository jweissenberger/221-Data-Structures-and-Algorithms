import java.util.Random;

/**
 * Class contains Normal random distribution
 *
 * @author Nirre Pluf {@literal <pluf@wfu.edu>}
 * @version 0.1, Mar. 8, 2018
 */
public class NormalDistribution{
    public final double mean, sd;

    public NormalDistribution() {
        this(1, 1);
    }

    public NormalDistribution(double mean, double sd) {
        this.mean = mean;
        this.sd = sd;
    }

    public double next(Random rand) {
        return this.mean + this.sd * rand.nextGaussian();
    }

}
