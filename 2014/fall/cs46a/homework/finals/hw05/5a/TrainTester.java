public class TrainTester
{
    public static void main(String[] args)
    {
        Train calTrain = new Train();
        calTrain.move(2);
        System.out.println("Distance to Start: " + calTrain.distanceToStart());
        System.out.println("expected: 0\n");
        
        calTrain.addFuel();
        calTrain.move(3);
        System.out.println("PowerLevel: " + calTrain.getPowerUnits());
        System.out.println("expected: 1\n");
        
        System.out.println("Distance to End: " + calTrain.distanceToEnd());
        System.out.println("expected: 35\n");
        
        calTrain.move(3);
        System.out.println("Distance to End: " + calTrain.distanceToEnd());
        System.out.println("expected: 30\n");
        
        System.out.println("PowerLevel: " + calTrain.getPowerUnits());
        System.out.println("expected: 0\n");
        
        calTrain.addFuel();
        calTrain.addFuel();
        calTrain.move(5);
        calTrain.turn();
        System.out.println("PowerLevel: " + calTrain.getPowerUnits());
        System.out.println("expected: 3\n");
        
        calTrain.move(4);
        System.out.println("Distance to Start: " + calTrain.distanceToStart());
        System.out.println("expected: 30\n");
        
        System.out.println("PowerLevel: " + calTrain.getPowerUnits());
        System.out.println("expected: 0\n");
        
    }
}