public class Tester2
{

    public static void main(String[] args)
    {
        HashSet hs = new HashSet();

        Weapon[] p = new Weapon[10];
        p[0] = new Weapon(1.0, 2.0, 3.0);
        p[1] = new Weapon(2.0, 2.0, 2.0);
        p[2] = new Weapon(1.0, 2.0, 3.0);
        p[3] = new Weapon(4.0, 2.0, 4.0);
        p[4] = new Weapon(1.0, 2.0, 5.0);
        p[5] = new Weapon(13.0, 2.0, 6.0); // This is removed second
        p[6] = new Weapon(11.0, 5.0, 7.0);
        p[7] = new Weapon(1.0, 4.0, 8.0); // This is removed first
        p[8] = new Weapon(2.0, 3.0, 9.0);
        p[9] = new Weapon(3.0, 2.0, 3.0); // We check for this, but cannot find it

        for(Weapon pt : p ) hs.add(pt);

        System.out.println("Actual: " + hs.containsBool(p[0]));
        System.out.println("Expected: true");

        System.out.println("Actual: " + hs.containsBool(new Potion(123.0, 1)));
        System.out.println("Expected: false");

        System.out.println("Actual: " + hs.containsBool(p[1]));
        System.out.println("Expected: true");

        hs.remove(p[7]);
        hs.remove(p[5]);

        System.out.println("Failing test");
        System.out.println("Actual: " + hs.containsBool(p[9]));
        System.out.println("Expected: true");

        System.out.println("Actual: " + hs.containsBool(p[5]));
        System.out.println("Expected: false");

        System.out.println("Actual: " + hs.containsBool(p[1]));
        System.out.println("Expected: true");

        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.35");

        hs.reallocate();
        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.17");

        Weapon w1 = new Weapon(4.0, 5.0, 6.0);
        Weapon w2 = new Weapon(3.0, 4.0, 5.0);
        hs.add(w1);
        hs.add(w2);

        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.22");

        int startPosition = hs.contains(w1);
        hs.reallocate();

        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.11");

        // Fail
        int newPosition = hs.contains(w1);

        System.out.println("Actual: " + (startPosition == newPosition));
        System.out.println("Expected: false");
    }

}