import java.util.Arrays;
import java.util.Comparator;

public class Tester
{
    public static void main(String[] args)
    {
        Student[] students = new Student[10];
        students[0] = new Student("ian", "innman", 100, "i@gmail.com");
        students[1] = new Student("jon", "jonson", 1, "j@gmail.com");
        students[2] = new Student("carl", "chung", 31, "c@gmail.com");
        students[3] = new Student("harold", "henderson", 234, "h@gmail.com");
        students[4] = new Student("daniel", "dennet", 78, "d@gmail.com");
        students[5] = new Student("guy", "garret", 72, "g@gmail.com");
        students[6] = new Student("fei", "fang", 67, "f@gmail.com");
        students[7] = new Student("brent", "bostick", 783, "b@gmail.com");
        students[8] = new Student("abbigail", "anderson", 123, "a@gmail.com");
        students[9] = new Student("evan", "entman", 54, "e@gmail.com");

        Comparator<Student> studentIdComparator = Sorter.getStudentIdComparator();
        Arrays.sort(students, studentIdComparator);

        System.out.println("Actual: " + students[0]);
        System.out.println("Expected: jon jonson");
        System.out.println("Actual: " + students[2]);
        System.out.println("Expected: evan entman");
        System.out.println("Actual: " + students[3]);
        System.out.println("Expected: fei fang");

        Course[] courses = new Course[2];
        Course c1 = new Course("cs", 46, "Data Structures");
        c1.addStudent(new Student("b", "b", 1, "b@gmail"));
        Course c2 = new Course("mus", 101, "Intro to music theory");
        c2.addStudents(students);
        courses[0] = c2;
        courses[1] = c1;

        courses = new Course[4];
        courses[0] = c1;
        courses[1] = c2;
        courses[2] = new Course("psy", 102, "Abnormal Psychology");
        courses[3] = new Course("eng", 154, "Mechanical Engineering");

        Comparator<Course> departmentComparator = Sorter.getDepartmentComparator();
        Arrays.sort(courses, departmentComparator);

        System.out.println("Actual: " + courses[1]);
        System.out.println("Expected: eng-154: Mechanical Engineering");
        System.out.println("Actual: " + courses[2]);
        System.out.println("Expected: mus-101: Intro to music theory");
        System.out.println("Actual: " + courses[0]);
        System.out.println("Expected: cs-46: Data Structures");
    }


}