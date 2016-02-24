import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A Decorator class that encrypts a Writer being written to
 a text file.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class EncryptingWriter extends BufferedWriter
{

   public EncryptingWriter(Writer out)
   {
      super(out);
   }

   /**
    Wraps a Writer's write() method with an encryption algorithm.
    @param str a String
    @throws IOException
    */
   @Override
   public void write(String str) throws IOException
   {
      String eStr = encrypt(str);
      super.write(eStr);
   }

   /**
    Encrypted a String using a basic Caesar Cipher.
    @param str a String
    @return an encrypted String
    */
   private String encrypt(String str)
   {
      StringBuilder sb = new StringBuilder(str);
      for (int i = 0; i < sb.length(); i++)
      {
         char character;
         int ascii;

         switch (sb.charAt(i))
         {
            case 32:
               break;
            case 88:
            case 89:
            case 90:
            case 120:
            case 121:
            case 122:
               character = str.charAt(i);
               ascii = character - 23;
               sb.setCharAt(i, (char) ascii);
               break;
            default:
               character = str.charAt(i);
               ascii = character + 3;
               sb.setCharAt(i, (char) ascii);
               break;
         }
      }
      return sb.toString();
   }
}
