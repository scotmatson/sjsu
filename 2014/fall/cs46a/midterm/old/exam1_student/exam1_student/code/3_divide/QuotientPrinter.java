import java.util.Scanner;


public class QuotientPrinter
{
    public static void main(String[] args)
    {
        double num1;
        double num2;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter a double: ");
        num1 = in.nextDouble();
        
        System.out.print("Enter another double: ");
        num2 = in.nextDouble();
        
        // Prints the quotient of the smaller number by the larger
        if (num1 > num2) { System.out.println(num2/num1); }
        else { System.out.println(num1/num2); }
    }
}
