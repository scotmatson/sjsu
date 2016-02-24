public class Tester
{
    public static void main(String[] args)
    {
        Order o1 = new Order(123, 456, "Motherboard MX237", "Computers");

        System.out.println("Actual: " + o1.GetFormattedOrder(new AtlantaWarehouseFormatter()));
        System.out.println("Expected: 123-456-Mot");
        System.out.println("Actual: " + o1.GetFormattedOrder(new ChicagoWarehouseFormatter()));
        System.out.println("Expected: C_456_123");
        System.out.println("Actual: " + o1.GetFormattedOrder(new SanJoseWarehouseFormatter()));
        System.out.println("Expected: MotherboardMX237456-Computers-123");


        Order o2 = new Order(555, 222, "Shampoo", "Bath");

        System.out.println("Actual: " + o2.GetFormattedOrder(new AtlantaWarehouseFormatter()));
        System.out.println("Expected: 555-222-Sha");
        System.out.println("Actual: " + o2.GetFormattedOrder(new ChicagoWarehouseFormatter()));
        System.out.println("Expected: B_222_555");
        System.out.println("Actual: " + o2.GetFormattedOrder(new SanJoseWarehouseFormatter()));
        System.out.println("Expected: Shampoo222-Bath-555");


        Order o3 = new Order(777, 888, "Masking Tape", "Office");

        System.out.println("Actual: " + o3.GetFormattedOrder(new AtlantaWarehouseFormatter()));
        System.out.println("Expected: 777-888-Mas");
        System.out.println("Actual: " + o3.GetFormattedOrder(new ChicagoWarehouseFormatter()));
        System.out.println("Expected: O_888_777");
        System.out.println("Actual: " + o3.GetFormattedOrder(new SanJoseWarehouseFormatter()));
        System.out.println("Expected: MaskingTape888-Office-777");

    }

}