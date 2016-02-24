import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by scot on 3/2/15.
 */
public class PrinterWriter_Example {

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter out = new PrintWriter("output.txt");

        out.println("Jane");
        out.println("Austen");
        out.println("j.austen@gmail.com");

        out.close();
    }
}
