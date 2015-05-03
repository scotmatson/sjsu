public class Tester
{
    public static void main(String[] args)
    {
        Potion p1 = new Potion(10, 1);
        Potion p2 = new Potion(10, 1);

        Potion p3 = new Potion(15, 3);

        System.out.println("Actual: " + (p1.equals(p2)));
        System.out.println("Expected: true");

        System.out.println("Actual: " + (p1.hashCode() == p2.hashCode()));
        System.out.println("Expected: true");

        System.out.println("Actual: " + (p3.equals(p1)));
        System.out.println("Expected: false");

        System.out.println("Actual: " + (p2.hashCode() == p3.hashCode()));
        System.out.println("Expected: false");

    }
}