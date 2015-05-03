public class Tester2
{
    public static void main(String[] args)
    {
        Weapon p1 = new Weapon(10, 1, 0.1);
        Weapon p2 = new Weapon(10, 1, 0.1);

        Weapon p3 = new Weapon(25, 2, 0.1);

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