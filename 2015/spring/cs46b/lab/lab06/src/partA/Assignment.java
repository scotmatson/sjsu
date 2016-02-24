package partA;

/**
 * The assignment class keeps one score for one student, as well as the
 * perfect score.  Student scores should default to 0 if they are requested
 * before being set.
 * @author you
 */
public class Assignment
{
    //any fantastic code you want here.
    private final double MAXIMUM_SCORE;
    private int score;

    /**
     * Creates the assignment, setting the perfect mark.
     * @param perfectScore This student's mark
     */
    public Assignment(int perfectScore)
    {
        //any fantastic code you want here.
        MAXIMUM_SCORE = perfectScore;
    }

    /**
     * Sets the score for this student.
     * @param score This student's mark
     */
    public void setScore(int score)
    {
        //any fantastic code you want here.
        try {
            if (score < 0) { throw new IllegalArgumentException(); }
            else if (score > MAXIMUM_SCORE) { throw new IllegalArgumentException(); }
            else { this.score = score; }
        }
        catch(IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the score for this student.
     * @return The students score
     */
    public int getScore() { return this.score; }

    /**
     * Gets the grade for this student, normalized to 0.0-100.0 range.
     */
    public double getGradeAsPercentage()
    {
        return (double) (100 * getScore()) / MAXIMUM_SCORE;
    }
}