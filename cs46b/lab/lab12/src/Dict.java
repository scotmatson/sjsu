import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by scot on 4/30/15.
 */
public class Dict {

    public static void main(String[] args) {

        if (args.length == 1) {
            try {

                Scanner in = new Scanner(new File(args[0]));

                while (in.hasNext()) {
                    System.out.println(in.next());
                }

                in.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Unable to execute application, no file argument referenced.");
        }
    }
}
