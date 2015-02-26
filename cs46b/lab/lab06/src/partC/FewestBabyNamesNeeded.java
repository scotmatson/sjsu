package partC;


import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class FewestBabyNamesNeeded
{
    public static void main(String[] args)
    {
        if (args.length != 3)
        {
            System.out.println("Usage: java FewestBabyNamesNeeded filename male value");
            System.out.println("or: java FewestBabyNamesNeeded filename female value");
        }
        else {
            String filename = args[0];
            try {
                File file = new File(filename);
                Scanner in = new Scanner(file);

                if (args[1].equalsIgnoreCase("male")) {
                    // Parse data, odd number strings are males, sum total count
                }
                else if (args[1].equalsIgnoreCase("female")) { // if arg[2] is female
                    // Parse data, even number strings are female, sum total count
                }

                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found:  (" + filename + ")");
            }
        }
    }
}