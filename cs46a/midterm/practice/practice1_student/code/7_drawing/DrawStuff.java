
/**
 * Write a description of class DrawStuff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DrawStuff
{
    public static void main(String[] args)
    {
        Line myLine = new Line(10, 10, 60, 10);
        myLine.draw();
        
        Ellipse myCircle = new Ellipse(25, 10, 10, 10);
        myCircle.setColor(Color.RED);
        myCircle.fill();
        
        Rectangle myRect = new Rectangle(25, 30, 20, 40);
        myRect.draw();
    }

}
