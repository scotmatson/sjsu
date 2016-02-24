public class Tester
{
    public static void main(String[] args)
    {
        YoshiIslandTaxCalculator y = new YoshiIslandTaxCalculator();

        System.out.printf("Actual: %.2f%n", y.calculateTax(10.0));
        System.out.println("Expected: 0.70");

        System.out.printf("Actual: %.2f%n", y.calculateTax(100.0));
        System.out.println("Expected: 8.00");

        System.out.printf("Actual: %.2f%n", y.calculateTax(1000.0));
        System.out.println("Expected: 71.00");

        System.out.printf("Actual: %.2f%n", y.calculateTax(00.0));
        System.out.println("Expected: 0.00");

        System.out.printf("Actual: %.2f%n", y.calculateTax(53.0));
        System.out.println("Expected: 3.71");

        System.out.printf("Actual: %.2f%n", y.calculateTax(86.0));
        System.out.println("Expected: 6.02");

        System.out.println("Actual: " + y.toString());
        System.out.println("Expected: YoshiIslandTaxCalculator[taxRate=0.07]");
    }

}