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
                File inputFile = new File(filename); // get the file
                Scanner in = new Scanner(inputFile, "UTF-8"); // feed the contents

                // parse the data
                if (args[1].equalsIgnoreCase("male")) {
                    int manCounter = 0;
                    double percentSum = 0.0;

                    // Consuming data to access desired field. Probably not the right way to be doing this...
                    while (in.hasNext() && percentSum < Double.parseDouble(args[2])) {
                        in.next();
                        in.next();
                        in.next();
                        percentSum += Double.parseDouble(in.next());
                        in.nextLine();
                        ++manCounter;
                    }

                    System.out.println(manCounter);

                }
                else if (args[1].equalsIgnoreCase("female")) { // if arg[2] is female
                    // Parse data, even number strings are female, sum total count
                    int womanCounter = 0;
                    double percentSum = 0.0;

                    // This is stupidly verbose but I'm not sure how else to do it.
                    while (in.hasNext() && percentSum < Double.parseDouble(args[2])) {
                        // Again, consuming data.
                        in.next();
                        in.next();
                        in.next();
                        in.next();
                        in.next();
                        in.next();
                        percentSum += Double.parseDouble(in.next());
                        in.nextLine();
                        ++womanCounter;
                    }

                    System.out.println(womanCounter);
                }

                in.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found:  (" + filename + ")");
                String curDir = System.getProperty("user.dir");
                System.out.println(curDir);
            }
        }
    }
}