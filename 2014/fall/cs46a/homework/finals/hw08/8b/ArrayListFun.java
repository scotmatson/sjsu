
/**
 * Practice using ArrayList data type (DRAFT).
 * 
 * @author (Scot Matson) 
 * @version (2014/10/23)
 */

import java.util.ArrayList;

public class ArrayListFun
{
    public static void main(String[] args)
    {
        ArrayList<String> garden = new ArrayList<String>();
        garden.add("pansy");
        garden.add("daisy");
        garden.add("violet");
        garden.add(0, "cactus");
        garden.add(0, "petunia");
        garden.set(1, "marigold");
        garden.set(garden.size()-1, "phlox");
        System.out.println(garden.get(garden.size()-1) + "***");
        System.out.println(garden.toString());
        for (String flower : garden) {
            System.out.println(flower);
        }
    }
}

