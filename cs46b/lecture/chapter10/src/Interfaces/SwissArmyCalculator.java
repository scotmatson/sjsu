package Interfaces;

import java.util.ArrayList;

/**
 * Created by scot on 2/9/15.
 */
public class SwissArmyCalculator {

    private ArrayList<Calculatable> operations;

    public SwissArmyCalculator () {
        operations = new ArrayList<Calculatable>();
    }

    public void addOperation(Calculatable c) {
        operations.add(c);
    }

    public Calculatable getOperationByName(String name) {
        for (Calculatable c : operations) {
            if ( c.getName().equals(name) )
                return c;
        }

        return null;
    }


}
