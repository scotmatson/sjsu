/**
 * Author: Scot Matson
 * Version: 20141106
 * Course: CS46A
 * Section: 01
 * Assignment: 10a {DRAFT}
 */

import java.util.ArrayList;

public class Gallery
{
    private ArrayList<Picture> pictures;
    private static final int GAP = 10;

    /**
        Constructs an empty gallery.
    */
    public Gallery()
    {
        pictures = new ArrayList<Picture>();
    }

    /**
        Adds a picture to the gallery.
        @param filename the name of the picture file
    */
    public void add(String filename)
    {
        pictures.add(new Picture(filename));
    }

    /**
        Arranges the pictures next to each other and draws them.
    */
    public void draw()
    {
        for (int i = 1; i < pictures.size(); i++)
        {
            Picture pic = pictures.get(i);
            Picture left = pictures.get(i - 1);
            pic.translate(left.getMaxX() + GAP, 0);
        }

        for (Picture pic : pictures)
        {
            pic.draw();
        }
    }

    /**
        Gets the area of the Picture at the given index in the Gallery
        @param index the index of the Picture whose area is wanted
        @return the area of the picture at that index
    */
    public int getArea(int index)
    {
        return pictures.get(index).getHeight() * pictures.get(index).getWidth();
    }
}
