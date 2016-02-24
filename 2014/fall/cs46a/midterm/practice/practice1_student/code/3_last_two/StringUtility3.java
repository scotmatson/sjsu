
public class StringUtility3
{
   public String lastTwo(String word)
   {
       int wordLen = word.length();
       String lastTwo = word.substring(wordLen - 2, wordLen);
       return lastTwo;
   }
}
