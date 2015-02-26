/** 
    [30 points]

    Provide the requested methods. You may use any of the other methods 
    (yours or mine) in the solution. Not all of my methods will be 
    useful for your tasks. 
*/

public class Problem1
{
   /**
      Checks whether a character is a vowel.
      @param str a string of length 1
      @return true if str is a vowel
   */
   public static boolean isVowel(String str)
   {
      return "aeiou".contains(str.toLowerCase());
   }

   /**
      Checks whether a character is a letter.
      @param str a string of length 1
      @return true if str is a letter
   */
   public static boolean isLetter(String str)
   {
      return "abcdefghijklmnopqrstuvwxyz".contains(str.toLowerCase());
   }

   /**
      Checks whether a character is a digit.
      @param str a string of length 1
      @return true if str is a digit
   */
   public static boolean isDigit(String str)
   {
      return "0123456789".contains(str);
   }

   /**
      Checks whether a character is uppercase.
      @param str a string of length 1
      @return true if str is uppercase
   */
   public static boolean isUppercase(String str)
   {
      return isLetter(str) && str.equals(str.toUpperCase());
   }

   /**
      Checks whether a character is lowercase.
      @param str a string of length 1
      @return true if str is lowercase
   */
   public static boolean isLowerCase(String str)
   {
      return isLetter(str) && str.equals(str.toLowerCase());
   }

   /**
      Checks whether a character is a symbol.
      @param str a string of length 1
      @return true if str is a symbol
   */
   public static boolean isSymbol(String str)
   {
      return !isLetter(str) && !isDigit(str);
   }


   /**
      Yields an array of characters (really, strings
      of length 1) in a string. For example, if str is "Hello", return
      an array containing "H", "e", "l", "l", "o".
   */
   public static String[] explode(String str)
   {
      String parseStr = "";
      int i;
      for (i = 0; i < str.length(); ++i) {
          if (isLetter(str.substring(i, i+1)))
            parseStr += str.substring(i, i+1);
      }
      String charArr[] = new String[parseStr.length()];
       for (i = 0; i < parseStr.length(); ++i) {
         charArr[i] = parseStr.substring(i, i+1);
      }
      return charArr;
   }
   
   /**
      Counts the number of uppercase characters in a string.
   */
   public static int count(String str)
   {
      int i;
      int ucCount = 0;
      String currChar;
      for (i = 0; i < str.length(); ++i) {
          currChar = str.substring(i, i+1);
          if (isUppercase(currChar)) {
              ++ucCount;
          }
      }

      if (ucCount != 0) {
          return ucCount;
      }
      return -1;
   }

   /**
      Finds the index of the first digit in a string.
      Returns -1 if no match.
   */
   public static int index(String str)
   {
      int i;
      for (i = 0; i < str.length(); ++i) {
          if (isDigit(str.substring(i, i+1))) {
              return i;
          }
      }
      return -1;
   }

   /**
      Finds the index of the second digit in a string.
      Returns -1 if no match.
   */
   public static int index2(String str)
   {
      int i = index(str) + 1;
      for (; i < str.length(); ++i) {
          if(isDigit(str.substring(i, i+1)))
              return i;
      }
      return -1;
   }

   /**
      Returns a string consisting of all vowel in a string.
   */
   public static String findall(String str)
   {
      String allVowels = "";
      int i;
       for (i = 0; i < str.length(); ++i) {
          if(isVowel(str.substring(i, i+1)))
              allVowels += str.substring(i, i+1);
      }
      return allVowels;
   }
}
