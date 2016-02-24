import java.util.Arrays;
public class ScoreManagerTester
{
    public static void main(String[] args)
    {
        int[] grades = {90, 50, 89, 80, 90, 92, 70,
            95, 75, 80, 85, 80, 93, 40, 59, 65, 20,
            0, 100, 82, 45, 79, 80, 80, 76, 80, 90};
        
        String name = "exam1";
        ScoreManager manager = new ScoreManager(name, grades);
        System.out.println( "mode for " + name + ": " +   manager.mode());
        System.out.println("Expected: 80");
 
        int[] grades2 = { 50, 89, 72, 90, 72, 70,
            95, 75, 80, 85, 72, 93, 40, 59, 65, 20,
            0, 100, 82, 45, 72, 50, 72, 80, 76, 80, 72};
            
        name = "exam2";
        ScoreManager manager2 = new ScoreManager(name, grades2);
        System.out.println( "mode for " + name + ": " +   manager2.mode());
        System.out.println("Expected: 72");   
        
        int[] count = manager.letterCounts();
        System.out.println(Arrays.toString(count));
        System.out.println("Expected: [6, 1, 4, 9, 7]"); 
        System.out.println("A's: " + count[ScoreManager.INDEX_A]);
        System.out.println("Expected: 7"); 
        System.out.println("B's: " + count[ScoreManager.INDEX_B]);
        System.out.println("Expected: 9"); 
        
        count = manager2.letterCounts();
        System.out.println( Arrays.toString(count));
        System.out.println("Expected: [7, 1, 9, 6, 4]");   
        System.out.println("D's: " + count[ScoreManager.INDEX_D]);
        System.out.println("Expected: 1"); 

    }
}