
/**
 * Write a description of class StringFun here.
 * 
 * @author (Scot Matson) 
 * @version (20140901)
 */
public class StringFun {
  public static void main(String[] args) {
    String word = "create"; 
       // do not change the line above here
       // your code goes below here
    int strDblLength = 0;
    String strUpperCase = "";
    String strTransmorgify = "";
    
    strDblLength = word.length() * 2;
    strUpperCase = word.toUpperCase();
    strTransmorgify = word.replace("a", "4");
    strTransmorgify = strTransmorgify.replace("t", "7");
    strTransmorgify = strTransmorgify.replace("c", "(");
    strTransmorgify = strTransmorgify.replace("e", "3");
    
    System.out.println(strDblLength);
    System.out.println(strUpperCase);
    System.out.println(strTransmorgify);
  }
}
