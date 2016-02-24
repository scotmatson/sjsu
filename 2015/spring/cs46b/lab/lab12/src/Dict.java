import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by scot on 4/30/15.
 */
public class Dict {

    public static void main(String[] args) {

        if (args.length == 1) {
            try {
                Stack<File> stack = new Stack<>();
                stack.p
                Scanner in = new Scanner(new File(args[0]));
                int lineNumbers = 0;
                Map<Integer, HashSet<String>> index = new HashMap<>();

                while (in.hasNextLine()) {
                    ++lineNumbers;
                    Set<Integer> lines = new HashSet<>();
                    lines.add(lineNumbers);
                    index.put(identifer, lines);

                    System.out.printf("%2d.", lineNumbers);

                    String line = in.nextLine();
                    Scanner in2 = new Scanner(line);
                    in2.useDelimiter("[^a-zA-Z0-9_]+");
                    while(in2.hasNext()) {
                        System.out.printf(" %s", in2.next());
                    }
                    System.out.println();
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
