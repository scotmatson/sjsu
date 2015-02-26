/**
 * Created by scot on 2/17/15.
 */
public class TaxData {

    private int year;
    private double topMarginalRate;
    private double topMarginalThreshold;

    public TaxData(int year, double topMarginalRate, double topMarginalThreshold) {
        this.year = year;
        this.topMarginalRate = topMarginalRate;
        this.topMarginalThreshold = topMarginalThreshold;
    }

    public int getYear() { return year; }
    public double getTopMarginalRate() { return topMarginalRate; }
    public double getTopMarginalThreshold() { return topMarginalThreshold; }
}
