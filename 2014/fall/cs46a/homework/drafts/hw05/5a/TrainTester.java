public class TrainTester
{
    public static void main(String[] args)
    {
        Train calTrain = new Train();
        System.out.println("track length: " + 
            Train.DISTANCE_BETWEEN_STOPS * Train.LAST_STOP_NUMBER);
        System.out.println("expected: 50");    
        System.out.println("Starting direcion: " +   Train.FORWARD );
        System.out.println("expected: 1");  
        System.out.println("Reverse: " +   Train.REVERSE );
        System.out.println("expected: -1"); 
                        
        calTrain.move(8);
        System.out.println("Distance to Start: " + calTrain.distanceToStart());
        System.out.println("expected: 40");
        calTrain.turn();
        calTrain.move(7);
        System.out.println("Distance to End: " + calTrain.distanceToEnd());
        System.out.println("expected: 45");
 
    }
}