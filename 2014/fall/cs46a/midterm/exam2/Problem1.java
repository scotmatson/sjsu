/*
9602502
Do not remove your student ID
 * You are given a Student class in this project. A student has a name and 
 * an grade
 * 
 * You are to complete the static methods
 * 
 * You will upload Problem1.java along with your other solutions
 */
public class Problem1
{
    
    
    /**
     * Finds the highest grade
     */
    public static double find(Student[] list)
    {
        int i;
        double grade = 0.0;
        for (i = 0; i < list.length; ++i) {
            if (grade < list[i].getScore()) {
                grade = list[i].getScore();
            }
        }

        return grade;
    }
    
    /**
     * Get the number of Students with C's
     */

    public static int count (Student[] list)
    {
        int i;
        int count = 0;
        for (i = 0; i < list.length; ++i) {
            if (list[i].getScore() >= 70 && list[i].getScore() < 80) {
                ++count;
            }
        }

        return count;
    }

}
