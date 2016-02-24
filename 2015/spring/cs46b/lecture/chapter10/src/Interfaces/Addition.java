package Interfaces;

/**
 * Created by scot on 2/9/15.
 */
public class Addition implements Calculatable {


    @Override
    public String getName() {
        return "Addition";
    }

    @Override
    public int calculate(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; ++i) {
            sum += a[i];
        }


        return sum;
    }
}
