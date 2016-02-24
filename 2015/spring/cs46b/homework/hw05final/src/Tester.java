import java.util.Arrays;
import java.util.Comparator;

public class Tester
{
    public static void main(String[] args)
    {
        Student[] students = new Student[10];
        students[0] = new Student("i", "i", 100, "i@gmail.com");
        students[1] = new Student("lowest", "studentid", 1, "j@gmail.com");
        students[2] = new Student("c", "c", 31, "c@gmail.com");
        students[3] = new Student("h", "h", 234, "h@gmail.com");
        students[4] = new Student("d", "d", 78, "d@gmail.com");
        students[5] = new Student("g", "g", 72, "g@gmail.com");
        students[6] = new Student("f", "f", 67, "f@gmail.com");
        students[7] = new Student("b", "b", 783, "b@gmail.com");
        students[8] = new Student("a", "a", 123, "a@gmail.com");
        students[9] = new Student("e", "e", 54, "e@gmail.com");

        Student[] sortedStudents = Sorter.mergeSortStudents(students);

        System.out.println("Actual: " + sortedStudents[0]);
        System.out.println("Expected: a a");
        System.out.println("Actual: " + sortedStudents[3]);
        System.out.println("Expected: d d");

        Comparator<Student> studentIdComparator = Sorter.getStudentIdComparator();
        Arrays.sort(sortedStudents, studentIdComparator);

        System.out.println("Actual: " + sortedStudents[0]);
        System.out.println("Expected: lowest studentid");

        Course[] courses = new Course[2];
        Course c1 = new Course("cs", 46, "Data Structures");
        c1.addStudent(new Student("b", "b", 1, "b@gmail"));
        Course c2 = new Course("mus", 101, "Intro to music theory");
        c2.addStudents(students);
        courses[0] = c2;
        courses[1] = c1;

        Sorter.selectionSortCourses(courses);

        System.out.println("Actual: " + courses[0]);
        System.out.println("Expected: cs-46: Data Structures");
        System.out.println("Actual: " + courses[1]);
        System.out.println("Expected: mus-101: Intro to music theory");

        courses = new Course[4];
        courses[0] = c1;
        courses[1] = c2;
        courses[2] = new Course("psy", 102, "Abnormal Psych");
        courses[3] = new Course("eng", 154, "Mech Eng");

        Comparator<Course> departmentComparator = Sorter.getDepartmentComparator();
        Arrays.sort(courses, departmentComparator);

        System.out.println("Actual: " + courses[1]);
        System.out.println("Expected: eng-154: Mech Eng");

        sortedStudents = Sorter.mergeSortStudents(students);
        System.out.println("Actual: " + Sorter.binarySearchStudents("a", sortedStudents));
        System.out.println("Expected: 0");
        System.out.println("Actual: " + Sorter.binarySearchStudents("d", sortedStudents));
        System.out.println("Expected: 3");
        System.out.println("Actual: " + Sorter.binarySearchStudents("y", sortedStudents));
        System.out.println("Expected: -1");

    }


}