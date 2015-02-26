import java.util.Arrays;

public class Tester
{
    public static void main(String[] args)
    {
        CellPhone[] phones = new CellPhone[5];
        phones[0] = new CellPhone("HTC", 170.0, 130.0);
        phones[1] = new CellPhone("Nokia", 100.0, 250.0);
        phones[2] = new CellPhone("Apple", 125.0, 600.0);
        phones[3] = new CellPhone("Samsung", 200.0, 400.0);
        phones[4] = new CellPhone("Windows", 150.0, 249.99);

        System.out.println("Actual: " + (phones[3].getId() == null));
        System.out.println("Expected: false");

        System.out.println("Actual: " + phones[1].getName());
        System.out.println("Expected: Nokia");

        System.out.println("Actual: " + (phones[4].toString().contains("Windows")));
        System.out.println("Expected: true");

        System.out.println("Actual: " + (phones[2].toString().contains("Windows")));
        System.out.println("Expected: false");

        System.out.println("Actual: " + (phones[2].getName()));
        System.out.println("Expected: Apple");

        Arrays.sort(phones);

        System.out.println("Actual: " + (phones[0].getName()));
        System.out.println("Expected: HTC");

        System.out.println("Actual: " + ((int)Math.floor(phones[0].getPrice())));
        System.out.println("Expected: 300");

        System.out.println("Actual: " + (phones[4].getName()));
        System.out.println("Expected: Apple");

        phones[3].setName("new name!!!");
        System.out.println("Actual: " + (phones[3].getName()));
        System.out.println("Expected: new name!!!");

        phones[2].setName("aaa");
        System.out.println("Actual: " + (phones[2].getName()));
        System.out.println("Expected: aaa");
    }

}