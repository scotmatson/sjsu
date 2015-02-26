import java.util.ArrayList;

/**
 * Created by scot on 1/28/15.
 *
 *
 *
 * NOTES:
 *   primitive types will create two spaces in memory making two separate
 *   pointers to two separate memory addresses
 *   int x = 10,
 *   int y = x;
 *   y = 11;
 *
 *   objects will simply reference the same location in memory using the two pointers
 *   so any changes to either variables will have an effect to the single memory
 *   location
 *   MyClass x = new MyClass(10);
 *   y = x;
 *   y.set(11);
 */
public class Quiz_Tester {

    public static void main(String[] args) {

        int x = 3;

        int y = (x == 3) ? 12 : 0;

        a.add(Integer.parseInt(in.nextLine()));

        int[] b = new int[2];
        b[0] = 10;
        b[1] = 11;
        int[] c = new int[2];
        System.arraycopy(b, 0, c, 0, 2);


        for( int z : c) {
            System.out.println(z);
        }

        ArrayList<Integer> d = new ArrayList<>();
        //Deep Copy?

        int[] MyArray = new int[10];
        MyArray[1] = 5;
        int[] NewArray = MyArray;
        NewArray[1] = 10;
        System.out.println(MyArray); // Will print out the value 10


    }
}
