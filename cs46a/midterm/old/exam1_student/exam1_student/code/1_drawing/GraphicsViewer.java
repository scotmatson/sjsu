
public class GraphicsViewer
{
    public static void main(String[] args)
    {
        // Creates a rectangular frame
        Rectangle mySquare = new Rectangle(20, 10, 100, 100);
        mySquare.setColor(Color.BLUE);
        mySquare.draw();
        
        // Creates an 'aquamarine' circle within the rectangle
        Ellipse myCircle = new Ellipse(20, 10, 100, 100);
        Color circleFiller = new Color(0, 200, 200);
        myCircle.setColor(circleFiller);
        myCircle.fill();
        
        // Creates a diagonal line within the rectangle
        Line topDiag = new Line(20, 10, 120, 110);
        topDiag.draw();
        
        // Creates a diagonal line within the rectangle
        Line bottomDiag = new Line(20, 110, 120, 10);
        bottomDiag.draw();
    }
    
}
