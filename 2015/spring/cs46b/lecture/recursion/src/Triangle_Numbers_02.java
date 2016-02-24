/**
 * Created by scot on 3/9/15.
 */
public class Triangle_Numbers_02 {

    public static void main(String[] args) {
        int largestRow = tr();
        System.out.println("largestRow: " + largestRow);
    }

    private static int tr() {
        // Helper method to hide the recursion from the calling program.
        return triangleRecursive(0, 0);
    }

    private static int triangleRecursive(int rowSize, int sum) {
        // This is the base case which stop the recursion.
        // Failure to stop recursion creates a stack overflow.
        if( sum + rowSize > 250) return rowSize - 1;
        else {
            // add this row
            sum += rowSize;

            // recursively add the next row
            return triangleRecursive(rowSize + 1, sum);
        }
    }
}
