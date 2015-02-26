
public class NumberTester
{
    public static void main(String[] args)
    {
        Number number = new Number(1235.6);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: average");
        
        number = new Number(-0.9999);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: small");  
        
        number = new Number(0.9999);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: small");  

        number = new Number(1000000);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: average"); 
        
        number = new Number(1);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: average"); 
        
        number = new Number(1000000.01);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: large"); 
        
        number = new Number(-1000000.01);
        System.out.println(number.getMagnitude());
        System.out.println("Expected: large"); 
        
    }
}
