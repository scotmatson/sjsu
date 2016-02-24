
public class StringUtility1 {
    /**
     * Gets th middle letter of the string if the lngth is odd or the character
     * after the midpoint if the length is even
     * @param word the String to process
     * @return a String containing the middle character
     */    
    public String middleLetter(String word) {
        int charCount = word.length();
        int midWord = charCount / 2;
        String midLetter = word.substring(midWord, midWord + 1);
        return midLetter;
    }
}
