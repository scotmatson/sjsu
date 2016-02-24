
/**
 * Test the DrinkingGlass class
 */
public class DrinkingGlassTester
{
    public static void main(String[] args)
    {
        DrinkingGlass glass = new DrinkingGlass(2.0);
        System.out.printf("%.2f%n", glass.getVolume());
        System.out.println("Expected: 791.68");
        glass.setHeight(1.0);
        System.out.printf("%.2f%n", glass.getVolume());
        System.out.println("Expected: 99.96");
        
    }
}
