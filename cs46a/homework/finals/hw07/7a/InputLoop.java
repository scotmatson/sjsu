
/**
 * Performs various calculations on a set of user defined integers.
 * 
 * @author (Scot Matson) 
 * @version (20141015)
 * 
 */
import java.util.Scanner;

public class InputLoop
{   
    public static void main(String[] args) {
        int num = -1;
        boolean hasMax = false;
        int max = -1;
        int secondMax = -1;
        int oddSum = 0;
        boolean hasTwo = false;

        Scanner in = new Scanner(System.in); 
        System.out.print("Enter an integer or Q to quit: ");
        if (in.hasNextInt()) {
            while(in.hasNextInt()) {
                num = in.nextInt();

                //Tracking the second largest integer of the set
                if (!hasMax) { //If we don't yet have a max value to test against
                    max = num; //Set the max value
                    secondMax = num; //Also set the secondMax value
                    hasMax = true; //Modify our boolean, we no longer want to enter this conditional
                }
                else if (num >= max) { //Now we continue to test our current max against the inbound integer
                    secondMax = max; //Storing the old max
                    max = num; //Storing the new max
                }
                else if (num <= max && num >= secondMax) { secondMax = num; }

                //The sum of all odd numbers
                if (num % 2 == 1 || num % 2 == -1) { //Testing against both neg/pos values
                    oddSum += num;
                }

                //Checking if a two is included in the set
                if (num == 2) {
                    hasTwo = true;
                }

                System.out.print("Enter an integer or Q to quit: ");

            }
            System.out.println(secondMax);
            System.out.println(oddSum);
            if (hasTwo) { System.out.print("yes"); }
            else if (!hasTwo) System.out.print("no");
        }
        else {
            System.out.println("no input");
        }
    }
}