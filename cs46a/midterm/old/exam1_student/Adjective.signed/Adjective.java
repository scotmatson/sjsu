
/**
 * Describes an adjective in the English language
 */
public class Adjective
{
    private String adjective;

    /**
     * Constructor for objects of class Adjective
     * @param the adjective
     */
    public Adjective(String word)
    {
        adjective = word;
    }

    /**
     * set a new word for this Adjective
     * @param newWord the new adjective to set
     */
    public void setAdjective(String newWord)
    {
        adjective = newWord;
    }
    
    /**
     * gets the word for this Adjective
     * @return the adjective
     */
    public String getAdjective()
    {
        return adjective;
    }
    /**
     * Gets the superlative form of this Adjective
     * @return the superlative form
     */
    public String superlative()
    {
        String superAdj = null;
        String theAdj = adjective.toLowerCase();
        int adjLength = theAdj.length();
        
        if (theAdj.compareTo("good") == 0) { superAdj = "best"; }
         else if (theAdj.compareTo("bad") == 0) { superAdj = "worst"; }
         else if (theAdj.charAt(adjLength - 1) == 'y') {
            superAdj = theAdj.substring(0, adjLength - 1) + "iest";
        }
         else if (adjLength <= 5) { superAdj = superAdj + "est"; }
         else if (adjLength > 5) { superAdj = "most " + superAdj; }
        
        
        return superAdj;
    }
    
}
