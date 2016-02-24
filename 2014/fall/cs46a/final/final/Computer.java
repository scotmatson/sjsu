/**
 * models a computer with a brand and a clock speed
 */
public class Computer implements Comparable {
    private String brand;
    private int clockSpeed;

    public Computer(String theBrand, int clockSpeed) {
        brand = theBrand;
        this.clockSpeed = clockSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public int getClockSpeed() {
        return clockSpeed;
    }

    public String toString() {
        String s = "[" + getClass().getName() + ":"
                + "brand=" + brand + ","
                + "clockSpeed=" + clockSpeed + "]";
        return s;
    }

    @Override
    public int compareTo(Object o) {
        Computer other = (Computer) o;
        if (getClockSpeed() < other.getClockSpeed()) {
            return -1;
        }
        if (getClockSpeed() > other.getClockSpeed()) {
            return 1;
        }
        if (getClockSpeed() == other.getClockSpeed()) {
            if (getBrand().compareTo(other.getBrand()) < 0) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}