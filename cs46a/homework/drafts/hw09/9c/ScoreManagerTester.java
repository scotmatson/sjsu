public class ScoreManagerTester
{
    public static void main(String[] args)
    {
        int[] grades = {90, 50, 89, 80, 90, 92, 70,
            95, 75, 80, 85, 80, 93, 40, 59, 65, 20,
            82, 45, 79, 50, 80, 80, 76, 80, 90};
        
        String name = "exam1";
        ScoreManager manager = new ScoreManager(name, grades);
        System.out.println( manager.getName() 
        + " " + manager.countTarget(90));
        System.out.println("Expected: exam1 3");
        System.out.println(manager.getName() + " " + manager.countTarget(76));
        System.out.println("Expected: exam1 1");
        
    }
}