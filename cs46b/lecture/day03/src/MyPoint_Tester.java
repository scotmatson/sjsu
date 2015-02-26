import java.awt.*;

/**
 * Created by scot on 2/2/15.
 */
public class MyPoint_Tester {

    public static void main(String[] args) {

        MyPoint_Tester program = new MyPoint_Tester();
        program.go();
    }

    public void go() {
        MyPoint p = new MyPoint();

        p.setLocation(10, 237);

        System.out.println(p.toString());

        moveRelative(p, -10, -237);

        System.out.println(p.toString());

    }

    private void moveRelative(MyPoint a, int x, int y) {
        a.move(x, y);
    }


}
