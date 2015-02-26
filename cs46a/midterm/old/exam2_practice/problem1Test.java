
/**
 * Write a description of class problem1Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class problem1Test
{
    public static void main(String[] args)
    {
        String explodeThis = "Three, Two, One, Kaboom!";
        System.out.println("Should return an array of characters.");
        String exploded[] = Problem1.explode(explodeThis);
        int i;
        for (i = 0; i < exploded.length; ++i)
        {
            System.out.print(exploded[i]);
        }

        System.out.println();
        String countUCTest = "TeStfoRUppeR";
        System.out.println("Should return 5");
        System.out.println("countUCTest has UC * " + Problem1.count(countUCTest));
        
        String indexTest = "Lucky 7, that is the ticket! Or was it 13?";
        System.out.println("Should return a 6");
        System.out.println("first digit is at: " + Problem1.index(indexTest));
        
        System.out.println("Should return 39");
        System.out.println("Second digit is at: " + Problem1.index2(indexTest));
        
        String justVowels = "A zebra is a horse, of course, of course.";
        System.out.println("Should return: Aeaiaoeooueooue");
        System.out.println("All vowels is: " + Problem1.findall(justVowels));
        
    }
}
