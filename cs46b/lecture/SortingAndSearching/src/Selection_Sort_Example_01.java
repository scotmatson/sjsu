/**
 * Created by scot on 3/18/15.
 */
public class Selection_Sort_Example_01 {

    public static void main(String[] args) {

        int[] array = ArrayUtil.randomArray(100, 100);

        for (int i = 1; i < array.length; i++) {

            int smallestValue = array[i];
            int smallestIndex = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < smallestValue) {
                    smallestValue = array[j];
                    smallestIndex = j;
                }
            }
        }

        ArrayUtil.printArray(array);
    }


}
