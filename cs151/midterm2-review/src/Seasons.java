/**
 Created by scot on 11/15/15.
 */
public enum Seasons
{
   SPRING(80), SUMMER(90), FALL(70), WINTER(50);

   private int temperature;

   private Seasons(int aTemperature)
   {
      temperature = aTemperature;
   }

   public void setTemperature(int aTemperature)
   {
      temperature = aTemperature;
   }

   public int getTemperature()
   {
      return temperature;
   }
}
