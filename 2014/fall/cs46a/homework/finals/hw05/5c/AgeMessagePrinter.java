/**
 * Author: Scot Matson
 * Date: 10/2/14
 * Type: Final
 * Assn: 5c
 * Course: cs46a - 01
 * Description: Asks the user for name and age and prints a message 
 * based on age
 */

import java.util.Scanner;

public class AgeMessagePrinter
{
    public static void main(String[] args)
    {   
        String name = null;
        int age = 0;
        String statement = null;
        Scanner in = new Scanner(System.in);
  
        System.out.print("What is your name? ");
        name = in.nextLine();
        
        System.out.print("How old are you " + name + "? ");
        age = in.nextInt();
        
        if (age >= 65) statement = " you qualify for Medicare";
        else if (age >= 35) statement = " you could be president";
        else if (age > 16) statement = " you are at that in between age";
        else if (age >= 0) statement = " you are still quite young";
        else statement = " you haven't been born yet!";
        
        System.out.println(name + statement);
    }
}
