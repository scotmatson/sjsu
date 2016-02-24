/**
Viewer for a spiral drawing
 */
public class SpiralViewer
{
    public static void main(String[] args)
    {

        final int GRID_SIZE = 10;
        int endX = 100;
        int endY = 100;
        int startX;
        int startY;
            
        for (int n = 0; n < 40; n++)
        {
            //LEFT
            startX = endX;
            startY = endY;
            
            System.out.println("Sx: " + startX + " Sy: " + startY);
            System.out.println("Ex: " + endX + " Ey: " + endY);

            
            endX = endX * n / GRID_SIZE;
            Line line = new Line(startX, startY, endX, endY);
            line.draw();
            
            System.out.println("Sx: " + startX);
            System.out.println("Sy: " + startY);
            System.out.println("Ex: " + endX);
            System.out.println("Ey: " + endY);
            
            //UP
            startX = endX;
            endY = endY * n / GRID_SIZE;
            line = new Line((startX * n) / GRID_SIZE, startY, endX, (endY * n) / GRID_SIZE);
            line.draw();
            
            System.out.println("Sx: " + startX);
            System.out.println("Sy: " + startY);
            System.out.println("Ex: " + endX);
            System.out.println("Ey: " + endY);
            
            //RIGHT
            endX = startY - 10;
            startY = endY;
            line = new Line(startX, startY, endX, endY);
            line.draw();
            
            System.out.println("Sx: " + startX);
            System.out.println("Sy: " + startY);
            System.out.println("Ex: " + endX);
            System.out.println("Ey: " + endY);
            
            //DOWN
            startX = endX;
            endY = endX;
            line = new Line(startX, startY, endX, endY);
            line.draw();
            
            
        }
    }
}