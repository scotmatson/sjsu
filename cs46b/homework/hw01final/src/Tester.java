/**
 * Created by scot on 1/30/15.
 */
public class Tester {
    public static void main(String[] args)
    {
        WarioLandTaxCalculator w = new WarioLandTaxCalculator();

        System.out.printf("Actual: %.2f%n", w.calculateTax(10.0));
        System.out.println("Expected: 10.10");

        System.out.printf("Actual: %.2f%n", w.calculateTax(100.0));
        System.out.println("Expected: 11.00");

        System.out.printf("Actual: %.2f%n", w.calculateTax(1500.0));
        System.out.println("Expected: 100.00");

        System.out.println("Actual: " + w.toString());
        System.out.println("Expected: WarioLandTaxCalculator[taxRate=0.01]");

        MarioWorldTaxCalculator m = new MarioWorldTaxCalculator(50.0);

        System.out.printf("Actual: %.2f%n", m.calculateTax(20.0));
        System.out.println("Expected: 0.80");

        m = new MarioWorldTaxCalculator(150.0);

        System.out.printf("Actual: %.2f%n", m.calculateTax(53.0));
        System.out.println("Expected: 4.24");

        System.out.printf("Actual: %.2f%n", m.calculateTax(186.0));
        System.out.println("Expected: 14.88");

        System.out.println("Actual: " + m.toString());
        System.out.println("Expected: MarioWorldTaxCalculator[taxRate=0.08]");
    }
}
