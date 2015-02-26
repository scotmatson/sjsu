public class Lab7
{
   private Robot carol;

    // This method sets up a maze. Don't look inside.
    private void makeMaze()
    {
        for (int i = 0; i < 10; i++)
        {
            carol.createHorizontalWall(i, 0);
            if (i != 5)
                carol.createHorizontalWall(i, 10);
            if (i < 7)
                carol.createHorizontalWall(i, 5);
        }
        for (int i = 0; i < 10; i++)
        {
            carol.createVerticalWall(0, i);
            carol.createVerticalWall(10, i);
            if (i > 2 && i < 9)
                carol.createVerticalWall(7, i);
        }
        carol.createHorizontalWindow(5, 10);
    }


   public static void main(String[] args)
   {
      new Lab7().run();
   }


   public void step()
   {
      // When the method is called, Carol has a wall to the right

      // TODO: Fix this code to deal with the other cases.
      carol.moveForward(); 

      // At this point, Carol should have (1) changed location
      // and (2) HAVE A WALL TO HER RIGHT
   }

   public void run()
   {
      carol = new Robot(1, 4, "robot.png");
      makeMaze();        

      while (carol.rightHasWall())
      {
         step(); // YOU are implementing the step method
      }
      carol.say("Whoa! There isn't a wall to the right any more!");   
   }
}