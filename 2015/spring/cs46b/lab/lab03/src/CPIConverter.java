import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by scot on 2/13/15.
 */
public class CPIConverter {

    private static final int FIRST_YEAR = 1913;
    private static final int LAST_YEAR = 2003;

    private double[] cpi;

    CPIConverter () {
    }

    public void read(String location) {
        cpi = new double[LAST_YEAR - FIRST_YEAR + 1];
        try {
            URL cpiURL = new URL(location);
            InputStream cpiIn = cpiURL.openStream();
            Scanner in = new Scanner(cpiIn);
            int i = 0;
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        }
        catch(MalformedURLException e) {
            System.out.println("Whoa, that URL was totally bogus hoss. Why don't you clean that" +
                    " bad boy up and give 'er another go?\n\n" + e);
        }
        catch(IOException e) {
            System.out.println("Unfortunately the web page you were looking for has " +
                    "either been incorrectly entered or no longer exists.");
        }
    }

    public double equivalentAmount(double amount, int fromYear, int toYear) {
        amount /= (fromYear - FIRST_YEAR);
        amount *= (toYear - FIRST_YEAR);
        return amount;
    }
}
