
/**
 * Write a description of class Word here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Word
{
   private String text;

   /**
      Constructs a word.
      @param text the characters in this word
   */
   public Word(String text)
   {
      this.text = text;
   }

   /**
      Tests whether a letter is a vowel
      @param letter a string of length 1
      @return true if letter is a vowel
    */
   public boolean isVowel(String letter)
   {
      return "aeiouy".contains(letter.toLowerCase());
   }

   public int countVowels()
   {
      int i;
      int counter = 0;
      for (i = 0; i < text.length(); ++i)
      {
         String letter = text.substring(i, i + 1); // the ith letter
         if (isVowel(letter)) {
             ++counter;
         }

      }
      return counter;
   }

   public int countVowelGroups() {
      int i;
      int vowelGroup = 0;
      boolean isGroup = false;
      String letter;
      
      for (i = 0; i < text.length(); i++) {
        letter = text.substring(i, i + 1);

        if(isVowel(letter)) {
            isGroup = true;
            
            while (isGroup && i < text.length()) {
                letter = text.substring(i, i + 1);
                i++;
                if (!isVowel(letter)) {
                    isGroup = false;
                } 
            }
            i--;
            vowelGroup++;
        }
      }
      return vowelGroup;
   }
   
   public String toString()
   {
      return text;
   }
}