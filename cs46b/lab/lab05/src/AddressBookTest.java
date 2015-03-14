import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest extends Object {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void anEmptyDirectoryHasNoFred() {

        AddressBook dir = new ArrayListAddressBook();
        Assert.assertNull(dir.get("Fred", "Phone"));
    }

    @Test
    public void shouldRemoveAnEntry() {
        AddressBook dir = new ArrayListAddressBook();
        dir.remove("Tester", "Phone");
        Assert.assertNull(dir.get("Tester", "Phone"));
    }

    @After
    public void tearDown() throws Exception {

    }
}