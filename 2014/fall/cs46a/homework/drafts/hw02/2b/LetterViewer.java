
/**
 * Write a description of class LetterViewer here.
 * 
 * @author (Scot Matson) 
 * @version (20140901)
 */
public class LetterViewer {
    public static void main(String[] args) {
      // Instantiate objects
      Line bodyK1 = new Line(10, 10, 10, 60);        // K1
      Line legUpK1 = new Line(40, 10, 10, 35);       // K1
      Line legDownK1 = new Line(40, 60, 10, 35);     // K1
      Ellipse oh = new Ellipse(40, 10, 50, 50); // O
      Line bodyK2 = new Line(100, 10, 100, 60);      // K2
      Line legUpK2 = new Line(130, 10, 100, 35);     // K2
      Line legDownK2 = new Line(130, 60, 100, 35);   // K2
       
      // Colorize
      oh.setColor(Color.RED);
      
      // Draw to the canvas
      bodyK1.draw();
      legUpK1.draw();
      legDownK1.draw();
      oh.draw();
      bodyK2.draw();
      legUpK2.draw();
      legDownK2.draw();
    }
}
