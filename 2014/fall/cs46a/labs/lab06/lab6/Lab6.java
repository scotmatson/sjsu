public class Lab6
{
   private Robot carol;

   /**
    * This method sets up the room. Don't look inside.
    * @param width the width of the room
    * @param depth the depth of the room
    * @param windowX the x-coordinate of the window's center
    * @param windowY the y-coordinate of the window's center
    */
   public void makeRoom(int width, int depth, double windowX, double windowY)
   {
      for (int i = 0; i < width; i++)
      {
         if (i != windowX - 0.5 || 0 != windowY) 
            carol.createHorizontalWall(i, 0);
         if (i != windowX - 0.5 || depth != windowY)
            carol.createHorizontalWall(i, depth);
      }
      for (int i = 0; i < depth; i++)
      {
         if (0 != windowX || i != windowY - 0.5)
            carol.createVerticalWall(0, i);
         if (width != windowX || i != windowY - 0.5)
            carol.createVerticalWall(width, i);
      }
      if (windowX == 0 || windowX == depth) 
         carol.createVerticalWindow(windowX, windowY - 0.5);
      else
         carol.createHorizontalWindow(windowX - 0.5, windowY);
   }


   public static void main(String[] args)
   {
      new Lab6().run();
   }

   public Lab6()
   {
      carol = new Robot(2, 2, "roomba.png");
   }

   public void run()
   {
      makeRoom(8, 6, 7.5, 0);        
   
      carol.turnLeft();
      goToWall();
      carol.turnLeft();
      findWindow();  
   }

   public void goToWall()
   {
      while (!carol.frontHasWallorWindow())
         carol.moveForward();
   }

   public void findWindow()
   {
      while (carol.rightHasWall())
      {
         if (carol.frontHasWallorWindow())
         {
            carol.turnLeft();
            if (!carol.rightHasWall())
                break;
         }
         carol.moveForward();
      }
   }    
}