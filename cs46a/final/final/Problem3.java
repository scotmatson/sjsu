//ID9602502
/**
  In the main method of this Problem, you are given a 2d int array to aid in 
  testing. You are to complete the sum method to find the sum of 
   all even numbers
   
   You will upload Problem3.java
*/
public class Problem3
{
   public static void main(String[] args)
   {
       int[][] array2D = {{1, 4, -2, 5},
                         {-3, 7, 10, 9},
                         {-7, 3, -5, -5},
                         {-6, 8, 0, 7},
                         {-1, 4, -2, 8}
           
        };
        
        System.out.println(sum(array2D));
   }
   
   /**
    * Gets the sum of
    *  all even numbers
    * @return the sum of
    *  all even numbers
    */
   public static int sum(int[][] matrix)
   {
       int sum = 0;
       for (int i = 0; i < matrix.length; ++i) {
           for (int j = 0; j < matrix[i].length; ++j) {
               if (matrix[i][j] % 2 == 0) {
                   sum += matrix[i][j];
               }
           }
       }
       return sum;
   }
}
