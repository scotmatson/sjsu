/**
 * Created by scot on 6/3/15.
 */

package examples;
public class MemoryCell {

    private Object storedValue;

    public Object read() {
        return storedValue;
    }

    public void write (Object x) {
        storedValue = x;
    }
}
