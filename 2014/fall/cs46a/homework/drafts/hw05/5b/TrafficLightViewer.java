public class TrafficLightViewer
{
    public static void main(String[] args)
    {
        TrafficLight signal = new TrafficLight(10, 50);
        //System.out.println(signal.getLight());
        signal.draw();
        signal.changeLight();
        
        Text label = new Text(10, 20, signal.getLight());
        label.draw();
    }
}