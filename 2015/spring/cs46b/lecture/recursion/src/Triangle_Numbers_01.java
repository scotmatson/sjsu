/**
 * Created by scot on 3/9/15.
 */
public class Triangle_Numbers_01 {

    public static void main(String[] args) {

        int sum = 0;
        int largestRow = 0;
        int currentRow = 0;

        while (sum < 250 - currentRow + 1) {
            // Increment the size of the current row
            currentRow++;

            // add the current row to the sum
            sum += currentRow;
        }

        System.out.println("sum: " + sum);
        System.out.println("bottom row: " + currentRow);
    }
}
