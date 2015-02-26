import javax.swing.*;

/**
* Created by scot on 1/30/15.
*/
public class AddressBookDemo
{
    public static void main(String[] args)
    {
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            String filename = jFileChooser.getSelectedFile().getPath();
            AddressBook book = new ArrayListAddressBook();
            book.load(filename);
            // Printing out the variables for debugging
            //System.out.println(book.get("Horstmann", "Phone"));
            //System.out.println(book.get("Horstmann", "Email"));

            Item contact = book.getFirst();
            //System.out.println(book.getFirst());
            //currentContact = book.getNext(contact);
            //System.out.println(book.getNext(contact));
            //System.out.println(book.getNext(contact));

            while (book.getNext(contact) != null) {
                System.out.println(book.getNext(contact));
                contact = book.getNext(contact);
            }
        }


    }
}
