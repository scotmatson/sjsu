package problem03;

import java.util.Comparator;

public class TestComparator implements Comparator<Integer>
{
    public int compare(Integer i1, Integer i2)
    {
        return i2 - i1;  //reverses order, just to spice things up.
    }
}