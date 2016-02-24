
/**
 * Write a description of class StringUtility1Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class StringUtility1Tester
{
    public static void main(String[] args) {
       StringUtility1 stringUtil = new StringUtility1();
        
       System.out.println("Should return 'n'.");
       System.out.println(stringUtil.middleLetter("Beginner"));
       
       System.out.println("Should return 'i'.");
       System.out.println(stringUtil.middleLetter("Poridge"));        
        
    }
}
