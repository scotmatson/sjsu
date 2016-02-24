import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.

 A Decorator class that decrypts a Reader that has been encrypted
 with a Caesar Cipher.

 Solves CS151 homework assignment #3

 @author Scot Matson

 @version 1.01 2015/10/25
 */
public class DecryptingReader extends BufferedReader
{
   public DecryptingReader(Reader in)
   {
      super(in);
   }

   /**
    Wraps a Reader's readLine() method with a decryption algorithm.
    @return str a String.
    @throws IOException
    */
   @Override
   public String readLine() throws IOException
   {
      String str = super.readLine();
      if (str != null)
      {
         str = decrypt(str);
      }
      return str;
   }

   /**
    Decrypts a String.
    @param str a Caesar Cipher encrypted String
    @return a decrypted String
    */
   public String decrypt(String str)
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
            case 65:
            case 66:
            case 67:
            case 97:
            case 98:
            case 99:
               character = str.charAt(i);
               ascii = character + 23;
               sb.setCharAt(i, (char) ascii);
               break;
            default:
               character = str.charAt(i);
               ascii = character - 3;
               sb.setCharAt(i, (char) ascii);
               break;
         }
      }
      return sb.toString();
   }
}
