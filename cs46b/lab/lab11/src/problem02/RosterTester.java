package problem02;

public class RosterTester {
    public static void main(String[] args)
    {
        Roster roster = new Roster();

        roster.addGrade("Sam", 7);
        roster.addGrade("Bill", 9);
        roster.addGrade("Sam", 10);

        System.out.println(roster.getAverage("Sam"));
        System.out.println("Expected:  8.5");

        System.out.println(roster.getAverage("Bill"));
        System.out.println("Expected:  9.0");

        System.out.println(roster.getGrade("Sam", 0));
        System.out.println("Expected:  7");

        System.out.println(roster.getGrade("Sam", 1));
        System.out.println("Expected:  10");
    }
}