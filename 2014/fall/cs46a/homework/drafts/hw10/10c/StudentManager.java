import java.util.ArrayList;

/**
 * Author: Scot Matson
 * Version: 20141106
 * Course: CS46A - 01
 * Assn: 10c {DRAFT}
 * Desc: A class used to help efficiently manage and analyze data pertaining to a student body
 */
public class StudentManager
{
    ArrayList<Student> students;

    /**
     * Constructs an empty StudentManager.
     */
    public StudentManager()
    {
        students = new ArrayList<Student>();
    }

    /**
     * String representation of the StudentManager
     * 
     * @return strStud StudentManager as String.
     */
    public String toString()
    {
        String strStud = students.toString();
        return strStud;
    }
    
    /**
     * Adds a student to this StudentManager.
     * 
     * @param s The student to add..
     */
    public void add(Student s)
    {
        students.add(s);
    }
    
    /**
     * Get the first instance of the student with the given name or return null if student
     * does not exist
     * 
     * @param name The name of the student to find.
     * @return studentProfile Information associated with a single student
     */
    public Student findStudent(String name)
    {
        return null;
    }
    
    /**
     * Gets the class average, otherwise returns null
     * 
     * @return classAverage The average class score
     */
    public double classAverage()
    {
        return 0.0;
    }
}
