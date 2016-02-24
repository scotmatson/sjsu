/*
 * This class should test the Comparable interface on
 * Order objects.
 */
public class Tester
{

    public static void main(String[] args)
    {
        Order a = new Order(123, 11111, "Keyboard KB280I", "Electronics");
        Order b = new Order(123, 11112, "Mouse M280I", "Electronics");
        Order c = new Order(555, 12345, "Pride and Prejudice", "Books");
        Order d = new Order(555, 77777, "The Shining", "Books");
        Order e = new Order(555, 77777, "The Shining", "Books");

        System.out.println("Actual: " + (a.compareTo(b) < 0));
        System.out.println("Expected: true");
        System.out.println("Actual: " + (b.compareTo(c) < 0));
        System.out.println("Expected: true");
        System.out.println("Actual: " + (d.compareTo(c) > 0));
        System.out.println("Expected: true");
        System.out.println("Actual: " + (d.compareTo(a) > 0));
        System.out.println("Expected: true");
        System.out.println("Actual: " + (c.compareTo(c) == 0));
        System.out.println("Expected: true");
        System.out.println("Actual: " + (e.compareTo(e) == 0));
        System.out.println("Expected: true");
    }
}