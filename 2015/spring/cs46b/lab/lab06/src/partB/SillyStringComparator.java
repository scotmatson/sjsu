package partB;

import java.util.Comparator;

/**
 * Created by scot on 2/20/15.
 */
public class SillyStringComparator implements Comparator<String>
{
    @Override
    public int compare(String str1, String str2) {

        String s1Modified = str1.substring(1, str1.length()) + str1.substring(0,1);
        String s2Modified = str2.substring(1, str2.length()) + str2.substring(0,1);

        // If both strings are empty we do not need to test for equality, we can simply return 0 because we know
        // the contents are the same. Otherwise we will compare as usual and return our results.
        return (!(str1.isEmpty() && str2.isEmpty())) ? s1Modified.compareTo(s2Modified) : 0;
    }
}
