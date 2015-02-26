
/**
 * Write a description of class StringUtility2Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StringUtility2Tester
{
    public static void main(String[] args) {
        StringUtility2 stringUtil = new StringUtility2();
        
        System.out.println("simple");
        System.out.println("Expecting: $1mple");
        System.out.println(stringUtil.getReplacement("simple"));
    }
}
