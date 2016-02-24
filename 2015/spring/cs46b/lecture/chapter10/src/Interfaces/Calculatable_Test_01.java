package Interfaces;

/**
 * Created by scot on 2/9/15.
 */
public class Calculatable_Test_01 {

    public static void main(String[] args) {

        Addition a = new Addition();
        Multiplication m = new Multiplication();

        SwissArmyCalculator s = new SwissArmyCalculator();
        s.addOperation(a);
        s.addOperation(m);

        int data[] = {237, 42};
        int result = 0;

        Calculatable c = s.getOperationByName("Addition");
        if( c != null ) {
            result = c.calculate(data);
            System.out.println(result);
        }
    }


}
