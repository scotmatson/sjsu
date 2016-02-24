/**
 * Created by scot on 3/18/15.
 */
public class ArrayUtil {

    public static int[] randomArray(int size, int maximum) {

        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = (int) Math.floor(Math.random() * maximum);
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i]);
        }
    }
}
