public class Robot
{
    private int x;
    private int y;
    private int dx;
    private int dy;
    private Picture pic;
    private boolean crashed;

    /**
        Constructs a robot at grid location (0, 0). The robot faces east.
    */
    public Robot()
    {
        x = 0;
        y = 0;
        dx = 1;
        dy = 0;
        pic = new Picture("robot.png");
        pic.draw();
    }

    /**
        Constructs a robot at a given grid location. The robot faces north.
        @param x the x location of the robot
        @param y the y location of the robot
        @param imageFile the Robot image
    */
    public Robot(int x, int y, String imageFile)
    {
        this.x = x;
        this.y = y;
        dx = 0;
        dy = -1;
        pic = new Picture("robot1.png");
        pic.translate(x * pic.getWidth(), y * pic.getHeight());
        pic.draw();
    }


    /**
        Moves this robot one step in the direction that it is facing.
    */
    public void moveForward()
    {
        Canvas.snapshot();
        if (crashed) return;
        if (frontHasWallorWindow())
        {
            pic.tint(Color.GRAY);
            crashed = true;
            return;
        }

        x = x + dx;
        y = y + dy;
        pic.translate(dx * pic.getWidth(), dy * pic.getHeight());
    }

    /**
        Turns this robot 90 degrees right.
    */
    public void turnRight()
    {
        Canvas.snapshot();
        if (crashed) return;
        int newDx = -dy;
        dy = dx;
        dx = newDx;
        pic.turn(1);
    }

    /**
        Turns this robot 90 degrees left.
    */
    public void turnLeft()
    {
        Canvas.snapshot();
        if (crashed) return;
        int newDx = dy;
        dy = -dx;
        dx = newDx;
        pic.turn(-1);
    }

    /**
        Makes this robot say something.
        @param message the text that the robot says
    */
    public void say(String message)
    {
        Canvas.snapshot();
        Text text = new Text((x + 1.2) * pic.getWidth(), (y + 0.5) * pic.getHeight(), message);
        text.draw();robot1
        int height = text.getHeight();
        Ellipse bubble = new Ellipse(text.getX() - height / 2,
                                     text.getY() - height / 2,
                                     text.getWidth() + height,
                                     2 * height);
        bubble.draw();
        double y = bubble.getY() + height;
        Line line = new Line(pic.getX() + pic.getWidth(),
                             y + height / 4, bubble.getX(), y);
        line.draw();
    }

    /**
        Checks whether there is a wall or window in front of this robot.
        @return true if there is a wall or window, false if there is neither.
    */
    public boolean frontHasWallorWindow()
    {
        for (Shape s : Canvas.getInstance().getShapes())
        {
            if (s instanceof Wall || s instanceof Window)
            {
                double cx = (x + 0.5 + 0.5 * dx) * pic.getWidth();
                double cy = (y + 0.5 + 0.5 * dy) * pic.getHeight();
                if (s.getX() <= cx && cx < s.getX() + s.getWidth()
                        && s.getY() <= cy && cy < s.getY() + s.getHeight())
                {
                    System.out.println("x: " + x + ", y: " + y);
                    System.out.println("cx: " + cx + ", cy: " + cy);
                    System.out.println("sx: " + s.getX() + ", sy: " + s.getY());
                    return true;
                }
            }
        }
        return false;
    }

    /**
        Checks whether there is a wall to the right of this robot.
        @return true if there is a wall, false if there isn't a wall.
    */
    public boolean rightHasWall()
    {
        for (Shape s : Canvas.getInstance().getShapes())
        {
            if (s instanceof Wall)
            {
                double cx = (x + 0.5 - 0.5 * dy) * pic.getWidth();
                double cy = (y + 0.5 + 0.5 * dx) * pic.getHeight();
                if (s.getX() <= cx && cx < s.getX() + s.getWidth()
                        && s.getY() <= cy && cy < s.getY() + s.getHeight())
                {
                    return true;
                }
            }
        }
        return false;
    }

    private static double LENGTH_FACTOR = 0.9;
    private static double THICKNESS_FACTOR = 0.05;

    private class Wall extends Rectangle {}
    private class Window extends Rectangle {}

    public void createHorizontalWall(double centerX, double centerY)
    {
        Wall wall = new Wall();
        wall.translate((centerX + 0.5) * pic.getWidth(), centerY * pic.getHeight());
        wall.grow(pic.getWidth() * LENGTH_FACTOR / 2, pic.getHeight() * THICKNESS_FACTOR / 2);
        wall.setColor(Color.BLACK);
        wall.fill();
    }

    public void createVerticalWall(double centerX, double centerY)
    {
        Wall wall = new Wall();
        wall.translate(centerX * pic.getWidth(), (centerY + 0.5) * pic.getHeight());
        wall.grow(pic.getWidth() * THICKNESS_FACTOR / 2, pic.getHeight() * LENGTH_FACTOR / 2);
        wall.setColor(Color.BLACK);
        wall.fill();
    }

    public void createHorizontalWindow(double centerX, double centerY)
    {
        Window window = new Window();
        window.translate((centerX + 0.5) * pic.getWidth(), centerY * pic.getHeight());
        window.grow(pic.getWidth() * LENGTH_FACTOR / 2, pic.getHeight() * THICKNESS_FACTOR / 2);
        window.setColor(Color.BLACK);
        window.draw();
    }

    public void createVerticalWindow(double centerX, double centerY)
    {
        Window window = new Window();
        window.translate(centerX * pic.getWidth(), (centerY + 0.5) * pic.getHeight());
        window.grow(pic.getWidth() * THICKNESS_FACTOR / 2, pic.getHeight() * LENGTH_FACTOR / 2);
        window.setColor(Color.BLACK);
        window.draw();
    }
}
