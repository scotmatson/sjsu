/**
 * Models the grades for a class on a particular assessment (assignment, quiz, exam)..
 * 
 * @author (Scot Matson) 
 * @version (20141030)
 */
public class ScoreManager
{
    public static final int INDEX_A = 4;
    public static final int INDEX_B = 3;
    public static final int INDEX_C = 2;
    public static final int INDEX_D = 1;
    public static final int INDEX_F = 0;
    private String name;
    private int grades[];

    /**
     * Constructs a ScoreManager for the given assessment 
     * with the given array
     * @param theName the name of this assessment
     * @param theGrades the grades for this ScoreManager
     */
    public ScoreManager(String theName, int[] theGrades)
    {
        name = theName;
        grades = theGrades;
    }

    /**
     * Gets the name of this assessment
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * The number of times a particular score occurs
     * @param target The score being evaluated
     * @return scoreCounter Number of times a score occurs
     */
    public int countTarget(int target)
    {   
        int scoreCounter = 0;

        if (grades.length > 0) {
            for (int i = 0; i < grades.length; ++i) {
                if (grades[i] == target) {
                    ++scoreCounter;
                }
            }
        }
        return scoreCounter;
    }

    /**
     * The mode (the value that occurs most often)
     * @return mode The value with the highest frequency
     */
    public int mode()
    {
        return 0;
    }

    /**
     * An array containing the number of A's B's, C's, D's, F's
     * @return grade Letter grade A -> F
     */
    public int[] letterCounts()
    {
        return null;
    }

}
