public class Tester
{
    public static void main(String[] args)
    {
        HashSet hs = new HashSet();

        Potion[] p = new Potion[10];
        p[0] = new Potion(10.0, 2);
        p[1] = new Potion(10.0, 3);
        p[2] = new Potion(13.0, 1);
        p[3] = new Potion(15.0, 1);
        p[4] = new Potion(10.0, 2);
        p[5] = new Potion(10.0, 2);
        p[6] = new Potion(10.0, 3);
        p[7] = new Potion(23.0, 4);
        p[8] = new Potion(25.0, 1);
        p[9] = new Potion(20.0, 2);

        for(Potion pt : p ) hs.add(pt);

        System.out.println("Actual: " + hs.containsBool(p[0]));
        System.out.println("Expected: true");

        System.out.println("Actual: " + hs.containsBool(new Potion(123.0, 1)));
        System.out.println("Expected: false");

        System.out.println("Actual: " + hs.containsBool(p[1]));
        System.out.println("Expected: true");

        hs.remove(p[9]);
        System.out.println("Actual: " + hs.containsBool(p[9]));
        System.out.println("Expected: false");

        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.39");

        int startPosition = hs.contains(p[1]);
        hs.reallocate();

        System.out.printf("Actual: %.2f\n", hs.calculateLoad());
        System.out.println("Expected: 0.20");

        int newPosition = hs.contains(p[1]);
        System.out.println("Actual: " + (startPosition == newPosition));
        System.out.println("Expected: false");

    }

}