package partB;

import java.util.Comparator;

/**
 * Created by scot on 2/20/15.
 */
public class SillyStringComparator implements Comparator{




    @Override
    public int compare(Object o1, Object o2) {
        return (o1.equals(o2)) ? -1 : 1; // assuming equality does not exist
    }

    /**
     * Moves the first character of a string to the last position
     *
     * @param origStr
     * @return modified version of the original string
     */
    public String stringModifier (String origStr) {
        String s1Modified = origStr.substring(1, origStr.length()) + origStr.substring(0,1);
        return s1Modified;
    }
}
