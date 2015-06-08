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
import java.net.URL;
import java.util.Scanner;

public class NameFinderDemo
{
   public static void main (String[] args) throws IOException
   {
      // Performance testing start time.
      double startTime = System.currentTimeMillis();

      // URL to to War and Peace text file.
      URL warAndPeace = new URL("http://www.cs.sjsu.edu/~mak/CS146/assignments/1/WarAndPeace.txt");

      // Names we are interested in finding.
      Person[] people = {
         new Person("Makar", "Alexeevich"),
         new Person("Joseph", "Bazdeev"),
         new Person("Boris", "Drubetskoy")
      };

      // Reading data from URL
      BufferedReader br = new BufferedReader(new InputStreamReader(warAndPeace.openStream()));

      // Setting up to output data.
      PrintWriter pw = new PrintWriter("output.txt", "UTF-8");

      // Building header.
      pw.write(" LINE  POSITION  NAME\n");

      // Preparing to parse.
      Scanner stdin = new Scanner(br);
      stdin.useDelimiter("[\\s,.!?';]");

      int lineNumber = 0;
      while (stdin.hasNextLine()) {
         String line = stdin.nextLine();

         ++lineNumber;
         String lastWord = line.substring(line.lastIndexOf(" ") + 1);

         // MAKAR
         if (line.contains(people[0].getFullName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[0].getFullName())), people[0].getFullName());
         }
         if (lastWord.equals(people[0].getFirstName()) && stdin.hasNext(people[0].getLastName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[0].getFirstName())), people[0].getFullName());
         }

         // JOSEPH
         if (line.contains(people[1].getFullName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[1].getFullName())), people[1].getFullName());
         }
         if (lastWord.equals(people[1].getFirstName()) && stdin.hasNext(people[1].getLastName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[1].getFirstName())), people[1].getFullName());
         }

         // BORIS
         if (line.contains(people[2].getFullName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[2].getFullName())), people[2].getFullName());
         }
         if (lastWord.equals(people[2].getFirstName()) && stdin.hasNext(people[2].getLastName()))
         {
            pw.format("%5d  %8d  %s\n", lineNumber,
               (1 + line.indexOf(people[2].getFirstName())), people[2].getFullName());
         }
      }

      // Performance testing end time.
      double endTime = System.currentTimeMillis();
      pw.write("\nTotal Run Time: " + (endTime - startTime) + " millisecond(s)\n");

      pw.close();
   }
//
}
