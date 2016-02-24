
public class BuildingTester
{
   public static void main(String[] args)
   {
       Building b = new Building(10);
       System.out.printf("%.2f\n",b.surfaceArea());
       System.out.println("Expected: 3170.80");
       
       b = new Building(5);
       System.out.printf("%.2f\n",b.surfaceArea());
       System.out.println("Expected: 792.70");
   }
}
