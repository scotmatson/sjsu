/**
 * Description: Describes a text string.
 * Student: Scot Matson
 * Version: 20141009
 */
public class TextUtil
{
    private String text;
 
    /**
     * Constructor for objects of class TextUtil
     * @param str the text for this object
     */
    public TextUtil(String str)
    {
        text = str;
    }

    /**
     * Returns the number of characters in this text
     * @return charCount the number of characters
     */
    public int getCount() {
        int charCount = text.length();
        return charCount;
    }
    
    /**
     * Gets the number of uppercase letters in the text
     * @return ucCount the number of uppercase letters
     */
    public int upperCaseCount() {
        int ucCount = 0;
        return ucCount;
        
    }
    
    /**
     * Gets a string that contains every other character, starting with the character at index 0
     * @return eoLetter a string consisting of every other letter
     */
    public String getEverySecondLetter() {
        String eoLetter = null;
        return eoLetter;
    }
}
