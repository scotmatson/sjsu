
/**
 * Write a description of class InputLoop here.
 * 
 * @author (Scot Matson) 
 * @version (20141015)
 */
import java.util.Scanner;

public class InputLoop
{   
    public static void main(String[] args) {
        
        int num;
        Scanner in = new Scanner(System.in); 
        
        System.out.print("Enter an integer or Q to quit: ");
        while(in.hasNextInt()) {
            num = in.nextInt();
            System.out.println(num);
            System.out.print("Enter an integer or Q to quit: ");
        }
    }
}