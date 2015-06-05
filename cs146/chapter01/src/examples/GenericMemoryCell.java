/**
 * Created by scot on 6/3/15.
 */

package examples;
public class GenericMemoryCell<AnyType> {

    private AnyType storedValue;

    public AnyType read() {
        return storedValue;
    }

    public void write(AnyType x) {
        storedValue = x;
    }
}
