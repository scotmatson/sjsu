import java.util.ArrayList;
import java.util.Scanner;

public class Viewer
{

    public static void main(String[] args)
    {
        Gallery myGallery = new Gallery();
        System.out.println("enter file name");
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
        {
            String name = in.next();
            myGallery.add(name);
        }
        int area = myGallery.getArea(0);
        Text text = new Text(10, 10, ""+ area);
        text.draw();
        area = myGallery.getArea(3);
        Text text2 = new Text(10, 30, ""+ area);
        text2.draw();
        
    }
}