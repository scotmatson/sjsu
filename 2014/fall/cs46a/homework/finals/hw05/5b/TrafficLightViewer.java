public class TrafficLightViewer
{
    public static void main(String[] args)
    {
        //red
        int x = 10;
        int y = 50;
        int textY = 20;
        int deltaX = 50;
        TrafficLight signal = new TrafficLight(x, y);
        signal.draw();
        Text label = new Text(x, textY, signal.getLight());
        label.draw();
        
        //green
        x = x + deltaX;
        TrafficLight signal1 = new TrafficLight(x, y);
        signal1.changeLight();
        signal1.changeLight();
        signal1.draw();
        Text label1 = new Text(x, textY, signal1.getLight());
        label1.draw();
        
        //yellow
        x = x + deltaX;
        TrafficLight signal2 = new TrafficLight(x, y);
        signal2.changeLight();
        signal2.draw();
        Text label2 = new Text(x, textY, signal2.getLight());
        label2.draw();
        
        //red
        x = x + deltaX;
        TrafficLight signal3 = new TrafficLight(x, y);
        signal3.changeLight(); //yellow
        signal3.changeLight(); //green
        signal3.changeLight(); //red
        signal3.draw();
        Text label3 = new Text(x, textY, signal3.getLight());
        label3.draw();
        
    }
}