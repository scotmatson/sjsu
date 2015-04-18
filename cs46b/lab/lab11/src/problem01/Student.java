import java.util.LinkedList;
import java.util.List;

public class Student {
    private String name;
    private List scores = new LinkedList<>();

    public Student(String name)
    {
        this.name = name;
    }

    public void addGrade(int score)
    {
        scores.add(score);
    }

    public String getName()
    {
        return name;
    }

    public int getScore(int i)
    {
        return scores.get(i);
    }

    public double getAverage()
    {
        if(scores.isEmpty())
            return 0;
        double total = 0;
        for(int i = 0; i < scores.size(); i++)
        {
            total += getScore(i);
        }

        return total / scores.size();
    }
}