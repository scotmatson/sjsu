import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A class for testing an implementation of the Decorator pattern.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class DecoratorTester
{
   private static Logger LOG = Logger.getLogger("myClassName");

   /**
    The main method.
    @param args User-defined arguments.
    */
   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      System.out.println("Enter text into the console.");
      System.out.println("It will be encrypted into a file using a Caesar Cipher");
      System.out.println("and then decrypted and printed back out to the console.");
      System.out.println("You can find the encrypted text in a file named output.txt");
      System.out.println("in the same directory you launched this application from");
      System.out.println();

      System.out.print(">> ");
      String text = in.nextLine();

      final String FILENAME = "output.txt";
      File textFile = new File(FILENAME);
      if (!textFile.exists())
      {
         try
         {
            if (!textFile.createNewFile())
            {
               LOG.info("Cannot create file: " + textFile);
            }
         }
         catch (IOException ioe)
         {
            ioe.printStackTrace();
         }
      }

      // Encrypt user input and write the results to a file.
      BufferedWriter bw;
      try (FileWriter fw = new FileWriter("./" + textFile))
      {
         bw = new BufferedWriter(fw);
         EncryptingWriter ew = new EncryptingWriter(bw);
         ew.write(text);
         ew.close();
      }
      catch(IOException ioe)
      {
         ioe.printStackTrace();
      }

      // Decrypt user input and print the results in the console.
      BufferedReader br;
      try (FileReader fr = new FileReader("./" + textFile))
      {
         br = new BufferedReader(fr);
         DecryptingReader dr = new DecryptingReader(br);

         String line;
         while ((line = dr.readLine()) != null)
         {
            System.out.println(line);
         }

         dr.close();
      }
      catch (IOException ioe)
      {
         ioe.printStackTrace();
      }
      System.out.println();
   }
}
