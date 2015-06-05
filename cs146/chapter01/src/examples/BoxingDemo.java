/**
 * Created by scot on 6/3/15.
 */

package examples;

public class BoxingDemo {
    public static void main(String[] args) {

//        GenericMemoryCell<Integer> m = new GenericMemoryCell<Integer>();
        GenericMemoryCell<Integer> m = new GenericMemoryCell<>();

        m.write(37);
        int val = m.read();
        System.out.println("Contents are: " + val);
    }
}
