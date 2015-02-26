import java.util.Random;

/**
 * Author: Scot Matson
 * Version: 20141106
 * Course: CS46A - 01
 * Assn: 10b {DRAFT}
 * Description: 
 */
public class Array2DManager
{
    private int[][] matrix;
    private int rows;
    private int columns;
    
    /**
     * Constructor for Array2DManager class
     * @param theRows The number of rows in an Array
     * @param theColumns The number of columns in an Array
     */
    public Array2DManager(int theRows, int theColumns)
    {
        rows = theRows;
        columns = theColumns;
        matrix = new int[rows][columns];
        
        //Populating the Array
        Random random = new Random(4750);
        for (int row = 0; row < 1; ++row)
        {

            for (int column = 0; column < columns; ++column) 
            {
                matrix[row][column] = random.nextInt(100);
            }
        }
    }
    
    /**
     * Gets the sum of all the integers in the array for this Array2DManager
     * @return sumOfInts The sum of all integers in the Array
     */
    public int sum()
    {
        int sumOfInts = 0;
        for (int row = 0; row < 1; ++row)
        {
            for(int column = 0; column < columns; ++column) 
            {
                sumOfInts += matrix[row][column];
            }
        }
        
        return sumOfInts;
    }
    
    /**
    * Gets the sum of the given 2d array
    * @param array An array of integer values
    */
    public static int sum(int[] array)
    {
        return 0;
    }
    
    /**
     * A string representation of a 'm', 'x', 'n' array with 'm' rows each of 
     * which contains the 'n' numbers in the columns of that row, separated by commas.
     * @return 
     */
    public String toString()
    {
        
        return null;
    }    
}
