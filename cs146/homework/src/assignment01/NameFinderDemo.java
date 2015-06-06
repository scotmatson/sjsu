/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved

 Test class for the NameNode.java class.

 Solves CS147 Homework Assignment #01

 @author Scot Matson
 @version 1.00 2015/6/5
 */
package assignment01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NameFinderDemo
{
   public static void main (String[] args) throws MalformedURLException,
   IOException
   {
      // Performance testing start time.
      double startTime = System.currentTimeMillis();

      // URL to to War and Peace text file.
      URL warAndPeace = new URL("http://www.cs.sjsu.edu/~mak/CS146/assignments/1/WarAndPeace.txt");

      // Names we are interested in finding.
      String[] names = new String[3];
      names[0] = "Makar Alexeevich";
      names[1] = "Joseph Bazdeev";
      names[2] = "Boris Drubetskoy";


      // Reading data
      BufferedReader br = new BufferedReader(new InputStreamReader(warAndPeace.openStream()));

      // Preparing to parse data.
      Scanner in = new Scanner(br);

      // Setting up to output data.
      PrintWriter pw = new PrintWriter("output.txt", "UTF-8");

      pw.write(" LINE  POSITION  NAME\n");
      Scanner stdin = new Scanner(br);

      int lineNumber = 0;

      while (stdin.hasNextLine()) {
         String line = stdin.nextLine();
         ++lineNumber;
         String lastWord = line.substring(line.lastIndexOf(" ")+1);
         // MAKAR
         if (line.contains(names[0]))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (1 + line.indexOf(names[0])), names[0]);
         }
         if (lastWord.equals("Makar") && stdin.hasNext("Alexeevich1"))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (line.indexOf("Makar")), names[0]);
         }

         // JOSEPH
         if (line.contains(names[1]))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (1 + line.indexOf(names[1])), names[1]);
         }
         if (lastWord.equals("Joseph") && stdin.hasNext("Bazdeev"))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (line.indexOf("Joseph")), names[1]);
         }

         // BORIS
         if (line.contains(names[2]))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (1 + line.indexOf(names[2])), names[2]);
         }
         if (lastWord.equals("Boris") && stdin.hasNext("Drubetskoy"))
         {
            pw.format("%5d  %8d  %s\n", lineNumber, (line.indexOf("Boris")), names[2]);
         }
      }

      // Performance testing end time.
      double endTime = System.currentTimeMillis();
      pw.write("\nTotal Run Time: " + (endTime - startTime) + " millisecond(s)\n");

      pw.close();
   }
//
}
