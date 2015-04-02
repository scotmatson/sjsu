import java.util.Arrays;
import java.util.Comparator;

public class Sorter
{
    /**
     * Return an instance of a class that realizes the
     * Comparator interface. The class should be an inner
     * class. You must write the inner class, then return
     * an instance of it. It should compare students based
     * on student id. Students with lower student ids should
     * come first.
     *
     * @return an instance of a class that implements Comparator<Student>
     */
    public static Comparator<Student> getStudentIdComparator()
    {
        class StudentIdComparator implements Comparator<Student> {
            public int compare(Student first, Student second) {
                return Integer.compare(first.getId(), second.getId());
            }
        }
        return new StudentIdComparator();
    }

    /**
     * Return an instance of a class that realizes the
     * Comparator interface. The class should be an inner
     * class. You must write the inner class, then return
     * an instance of it. It should compare courses based
     * on department code. Compare them based on alphabetical
     * ordering. "cs" comes before "mus"
     *
     * @return an instance of a class that implements Comparator<Course>
     */
    public static Comparator<Course> getDepartmentComparator()
    {
        class DepartmentComparator implements Comparator<Course> {
            public int compare(Course first, Course second) {
                String s1 = first.getDepartment();
                String s2 = second.getDepartment();
                return s1.compareTo(s2);
            }
        }
        return new DepartmentComparator();
    }

    /**
     * Use selection sort to sort courses based on the
     * number of enrolled students. Courses with fewer
     * students should come first.
     *
     * @param courses the array of courses to sort
     */
    public static void selectionSortCourses(Course[] courses)
    {
        // YOUR CODE HERE
    }

    /**
     * Use merge sort to sort students based on their
     * last names. Use alphabetical ordering based on
     * the lastName field. So a student with the last
     * name "arthur" should come before a student with
     * the last name "presley".
     *
     * @param students the array to sort
     */
    public static Student[] mergeSortStudents(Student[] students)
    {
        // YOUR CODE HERE
    }

    /**
     * Use binary search on the lastName field to return
     * the index where the student is located in the array
     * or -1 if that student isn't in the array.
     *
     * This will require a recursive helper method.
     *
     * @param students the array to search
     * @return the index where the student is found, or -1 if not found
     */
    public static int binarySearchStudents(String lastName, Student[] students)
    {
        // YOUR CODE HERE
    }
}
