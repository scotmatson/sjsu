import java.util.Random;
/**
9602502
Do not remove your student ID
 * This class has static methods to process a 2d array of ints. You
 * will complete the methods (In Problem3 you will create a tester)
 */
public class Problem2
{
    
    /**
     * Find the sum of the elements in the
     * last row
     */
    public static int sum(int[][] list)
    {
        int LAST_ROW = list.length-1;
        int i;
        int sum = 0;
        for (i = 0; i < list[LAST_ROW].length; ++i) {
            sum += list[LAST_ROW][i];
        }

        return sum;
    }
    
    /**
     * Replace all odd values with 2
     */
    public static void replace(int[][] list)
    {
        int ROW, COL;
        for (ROW = 0; ROW < list.length; ++ROW) {
            for (COL = 0; COL < list[ROW].length; ++COL) {
              if ((list[ROW][COL] % 2) == 1) {
                  list[ROW][COL] = 2;
              }
            }
        }
    }
}
