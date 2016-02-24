import java.util.Random;
import java.util.Arrays;
/**
9602502
Do not remove your student ID
 * In this problem you will write a tester to test the  
 * methods you wrote in your Problem2
 * 
 * First create a 2d array of ints with
 * 7rows and 4columns
 * 
 * Next fill the array with random numbers less than or equal 
 * to 100 using the Random object declared for you. Do not change the 
 * object
 * 
 * Finally call the static methods in Problem2 and print the
 * results. Remember that you call a static method using the 
 * name of the class something like this
 * ClassName.methodName(parameters)
 * 
 * You can get credit for the tester even if you could not do 
 * Problem2
 */
public class Problem3
{
    public static void main(String[] args)
    {
	    //fill array with random numbers
        Random random = new Random(4000);
        int[][] list = new int[7][4];
        int ROW, COL;
        for (ROW = 0; ROW < list.length; ++ROW) {
            for (COL = 0; COL < list[ROW].length; ++COL) {
                    list[ROW][COL] = random.nextInt(100);
            }
        }


        print(list);
        // call the static sum method of Problem2 and print the results
        System.out.println("Sum of last row: " + Problem2.sum(list));

        print(list);
        //call the static replace method of Problem2
        Problem2.replace(list);
                
    }
    
    /**
     * prints the 2d array
     */
    public static void print(int[][] array)
    {
	    System.out.println();
        for(int row = 0; row < array.length; row++)
        {
            System.out.println(Arrays.toString(array[row]));
        }
        System.out.println();
    }
}
