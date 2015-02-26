public class Student
{
    private String name;
    private int score;
    
    public Student(String theName, int theScore)
    {
        name = theName;
        score = theScore;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public String toString()
    {
        String s = "[" + getClass().getName() + ":"
           + "name="+ name + ","
           + "score=" + score + "]";
        return s;
    }
}