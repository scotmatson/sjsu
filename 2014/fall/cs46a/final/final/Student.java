/**
 * moddels a student with a name and a grade
 */
public class Student
{
    private String name;
    private int grade;
    
    public Student(String theName, int grade)
    {
        name = theName;
        this.grade = grade;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getGrade()
    {
        return grade;
    }
    
    public String toString()
    {
        String s = "[" + getClass().getName() + ":"
           + "name="+ name + ","
           + "grade=" + grade + "]";
        return s;
    }
}
