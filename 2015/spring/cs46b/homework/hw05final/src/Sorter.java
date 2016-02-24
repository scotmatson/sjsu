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
    public static void selectionSortCourses(Course[] courses) {
        for (int i = 0; i < courses.length - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < courses.length; ++j) {
                if (courses[j].size() < courses[min].size()) {
                    min = j;
                }
            }

            // The the current min has changed from the initial min...
            if (min != i) {
                // Swap
                Course temp = courses[min];
                courses[min] = courses[i];
                courses[i] = temp;
            }
        }
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
        // Modified code from Big Java by Cai Horstmann
        // Sizing the new array halves
        if (students.length <= 1) { return students; }
        Student[] first = new Student[students.length / 2];
        Student[] second = new Student[students.length - first.length];

        // Copying the original array elements into the new array
        for (int i = 0; i < first.length; ++i) {
            first[i] = students[i];
        }
        for (int i = 0; i < second.length; ++i) {
            second[i] = students[first.length + i];
        }

        // Recursively continue this process until we have broken the original array
        //  down into its constituents
        mergeSortStudents(first);
        mergeSortStudents(second);

        // Begin merging to rebuild a sorted array
        int iFirst = 0;     // Next element to consider in the first array
        int iSecond = 0;    // Next element to consider int the second array
        int j = 0;          // Next open position in students

        // As long as we have not exceeded our counters have moved out of
        //  bounds, continue to move the smallest element of the arrays
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getLastName().compareTo(second[iSecond].getLastName()) < 0) {
                students[j] = first[iFirst];
                ++iFirst;
            }
            else {
                students[j] = second[iSecond];
                ++iSecond;
            }
            ++j;
        }

        // Only one of the loops below will be used to clean up any
        //  remaining array elements
        while (iFirst < first.length) {
            students[j] = first[iFirst];
            ++iFirst;
            ++j;
        }
        while (iSecond < second.length) {
            students[j] = second[iSecond];
            ++iSecond;
            ++j;
        }

        return students;
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
        return binarySearchStudents(students, 0, students.length-1, lastName);
    }
    private static int binarySearchStudents(Student[] a, int low, int high, String lastName) {
        // Partial code borrowed from Cai Horstmann's Big Java
        if (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid].getLastName().compareTo(lastName) == 0) {
                return mid;
            }
            else if (a[mid].getLastName().compareTo(lastName) < 0) {
                return binarySearchStudents(a, mid + 1, high, lastName);
            }
            else {
                return binarySearchStudents(a, low, mid - 1, lastName);
            }
        }
        else {
            return -1;
        }
    }
}
