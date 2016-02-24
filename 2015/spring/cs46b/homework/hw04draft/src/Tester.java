/**
 * Created by scot on 3/13/15.
 */
public class Tester
{
    public static void main(String[] args)
    {
        SlotMachine sm = new SlotMachine(4, "lemon", "apple", "cherry", "thing4", "thing5");

        System.out.println("Actual: " + sm.getNumberOfOutcomes());
        System.out.println("Expected: 625");

        sm = new SlotMachine(3, "lemon", "apple", "cherry", "thing4");

        System.out.println("Actual: " + sm.getNumberOfOutcomes());
        System.out.println("Expected: 64");

        sm = new SlotMachine(5, "a", "b", "c");

        System.out.println("Actual: " + sm.getNumberOfOutcomes());
        System.out.println("Expected: 243");
    }
}