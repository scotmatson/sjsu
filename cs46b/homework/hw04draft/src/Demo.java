/**
* Created by scot on 3/13/15.
*/
public class Demo
{
    public static void main(String[] args)
    {
        SlotMachine sm = new SlotMachine(4, "lemon", "apple", "cherry", "thing4", "thing5");
        sm.outcomes.add("outcome1");
        sm.outcomes.add("outcome2");
        sm.outcomes.add("outcome3");
        sm.outcomes.add("outcome4");
        sm.outcomes.add("outcome5");

        sm.printOutcomes();
    }
}