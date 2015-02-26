/**
 * Author: Scot Matson
 * Date: 09/30/14
 * Type: Draft
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
        Scanner in = new Scanner(System.in);
  
        System.out.print("What is your name? ");
        name = in.nextLine();
        
        System.out.print("How old are you " + name + "? ");
        age = in.nextInt();
        
        System.out.println("Age: " + age);
    }
}
