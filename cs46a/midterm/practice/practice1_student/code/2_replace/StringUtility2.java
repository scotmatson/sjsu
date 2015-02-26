
public class StringUtility2
{
    /**
     * Replaces s with $ and i with 1.
     * @param word the string to alter
     * @return a new String with the replacements made
     */
    public String getReplacement (String word) 
    {
        word =  word.replace("s", "$");
        word = word.replace("i", "1");
        
        return word;
    }
}
