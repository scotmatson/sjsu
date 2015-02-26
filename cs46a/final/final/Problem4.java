//ID9602502
/**
 * In this problem you will simulate the volume switch on a cellphone. 
 * There are two buttons that control the volume. The up button rasies 
 * the volume one level up to a MAX. Use the constant provided. The down button
 * lowers the volume one level, but the volume is never less than 0. 
 * In addition, the volumne buttons are controlled by an on-off switch. 
 * If the on-off switch is off, pushing the buttons has no effect, and
 * the volume is zero. When the switch is turned on again, the volume 
 * is at the same level as when it was turned off.
 * 
 * When the volume switch is at the maximum value, pushing the up button
 * once more sets the volume to 0. 
 * When it is at the minimum value, pushing the down button once more sets the volume to  
 * the minimum value: 0
 * 
 * 
 * A class like this would normally be given a meaningufl name such as VolumneSwitch but for the
 * exam we are calling it Problem4. You will upload Problem4.java
 */
public class Problem4
{
    private static final int MAX = 9;
    private static final int MIN = 0;
    private boolean on;
    private int volume;

    /**
      Constructs a volume switch that is off and, once turned on,
      has value 0.
     */
    public Problem4()
    {
        on = false;
        volume = 0;
    }

    /**
       Turns the switch assembly on if it was off or off if it was on.
     */
    public void toggle()
    {
        on = !on;
    }
    
    /**
      Turns the rocker switch up or down.
      @param up if true, the up button was pushed, if false the down button was pushed
   */
   public void changeVolume(boolean up)
   {
      if (up && volume < MAX) {
          ++volume;
      }
      else if (!up && volume > MIN) {
          --volume;
      }
   }
    
   /**
      Gets the value maintained by this switch assembly.
      @return the value
   */
   public int getVolume()
   {
      return volume;
   }

}
