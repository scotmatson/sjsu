public class HighTemperatureMinderTester
{
    public static void main(String[] args)
    {
        int[] temperatures = {-5, 20, 17, -2, 30, 28, -3, -1};
        HighTemperatureMinder minder = new HighTemperatureMinder(temperatures);
        double average = minder.average();
        System.out.println("Average: " + average);
        System.out.println("Expected: 10.5");
        
        temperatures = new int[0];
        minder = new HighTemperatureMinder(temperatures);
        average = minder.average();
        System.out.println("Average: " + average);
        System.out.println("Expected: 0.0");
    }
}