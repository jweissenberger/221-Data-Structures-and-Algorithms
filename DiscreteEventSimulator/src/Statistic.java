import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.stream.DoubleStream;

/**
 * Wrapper for DoubleSummaryStatistics that supports standard deviation.
 * details at
 *   https://www.leveluplunch.com/java/tutorials/005-java8-summary-statistics-made-easy/  
 *   https://www.concretepage.com/java/jdk-8/java-8-summary-statistics-example  
 * video at
 *   http://goo.gl/rxnHB1  
 */
public class Statistic {
    private DoubleStream.Builder builder = DoubleStream.builder();
    private double[] values;
    private DoubleSummaryStatistics summary;

    public void accept(double d) {
        builder.accept(d);
    }

    private void close() {
        if (this.values == null) {
            this.values = this.builder.build().toArray();
            this.summary = Arrays.stream(this.values).summaryStatistics();
        }
    }

    public long getCount() {
        this.close();
        return this.summary.getCount();
    }

    public double getMin() {
        this.close();
        return this.summary.getMin();
    }

    public double getMax() {
        this.close();
        return this.summary.getMax();
    }

    public double getAverage() {
        this.close();
        return this.summary.getAverage();
    }

    public double getStandardDeviation() {
        double avg = this.getAverage();
        return Math.sqrt(Arrays.stream(this.values).map((d) -> (d - avg) * (d - avg)).sum()) / Math.sqrt(this.getCount());
    }
}
