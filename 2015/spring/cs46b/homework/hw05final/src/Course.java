import java.util.ArrayList;

public class Course
{
    private String departmentCode;
    private int number;
    private String name;
    public ArrayList<Student> enrolledStudents;

    public Course(String NewDepartmentCode, int NewNumber, String NewName)
    {
        departmentCode = NewDepartmentCode;
        number = NewNumber;
        name = NewName;
        enrolledStudents = new ArrayList<Student>();
    }

    public String getDepartment()
    {
        return departmentCode;
    }

    public void addStudent(Student newStudent)
    {
        enrolledStudents.add(newStudent);
    }
    public void addStudents(Student[] newStudents)
    {
        for( Student s : newStudents )
            enrolledStudents.add(s);
    }

    public int size()
    {
        return enrolledStudents.size();
    }

    @Override
    public String toString()
    {
        return departmentCode + "-" + number + ": " + name;
    }
}