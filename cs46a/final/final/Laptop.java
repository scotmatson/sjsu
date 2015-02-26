/**
 * Created by scot on 12/17/14.
 */
public class Laptop extends Computer {

    private double batteryLife;

    public Laptop (String theBrand, int clockSpeed, double batteryLife) {
        super(theBrand, clockSpeed);
        this.batteryLife = batteryLife;
    }

    public void setBatteryLife (double batteryLife) {
        this.batteryLife = batteryLife;
    }

    public double getBatteryLife () {
        return this.batteryLife;
    }

    public String toString() {
        String s = super.toString() + "batteryLife=" + this.getBatteryLife() + "]";
        return s;
    }
}
