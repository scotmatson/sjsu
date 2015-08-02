/**

 */
package Assignment06;

import java.util.ArrayList;

public class WeightedShortestPath
{
   public void path(ArrayList<Vertex> adjacencyList)
   {
      // Printer variables
      System.out.printf("%s\n", "*** WEIGHTED SHORTEST PATH - Graph 9.82 ***");
      String tableSpacer = "----------------------------------";

      final int UNVISITED = -1;
      final int WEIGHT_LIMIT = 40; // Total weight of Graph 9.82

      Vertex s = adjacencyList.get(0);
      Queue<Vertex> q = new Queue<>();

      // Initializing Vertices distances
      for (Vertex v : adjacencyList)
         v.setDistance(UNVISITED);

      // Entry point for algorithm
      s.setDistance(0);
      q.enqueue(s);
      System.out.printf("\n%-15s %s", "Dequeue: ***", "Enqueue: " + s.getName());


      // Only Vertices with unknown distances should be stored in the queue
      while (!q.isEmpty())
      {
         // Printing operations.
         System.out.printf("\n%s\n", tableSpacer);
         System.out.printf("%2s", "v");
         for (Vertex v : adjacencyList)
            System.out.printf("%4s", v.getName());
         System.out.println();
         System.out.printf("%2s", "dV");
         for (Vertex v : adjacencyList)
            System.out.printf("%4s", v.getDistance());
         System.out.println();
         System.out.printf("%2s", "pV");
         for (Vertex v : adjacencyList)
            System.out.printf("%4s", v.getPath());
         System.out.println();

         // Smallest unknown distance vertex
         Vertex v = q.dequeue();

         System.out.printf("\n%-15s %s", "Dequeue: " + v.getName(), "Enqueue: ");

         // For each outgoing edge
         for (Edge e : v.getOutgoingEdges())
         {
            // In the case that the Vertex has not yet been visited,
            // set a new weight.
            if (e.getVertex1().getDistance() == UNVISITED)
            {
               e.getVertex1().setDistance(v.getDistance() + e.getWeight());
               e.getVertex1().setPath(v.getName());
               q.enqueue(e.getVertex1());
               System.out.printf("%s ", e.getVertex1().getName());
            }
            else
            {
               // Check the weight of the current path against the weight
               // of the incoming Vertex
               if (e.getVertex1().getDistance() > v.getDistance() + e.getWeight())
               {
                  e.getVertex1().setDistance(v.getDistance() + e.getWeight());
                  e.getVertex1().setPath(v.getName());
                  System.out.printf("%s ", e.getVertex1().getName());
               }
            }

            if (e.getVertex1().getDistance() > WEIGHT_LIMIT)
            {
               throw new IllegalStateException("Excessive distance.");
            }
         }
      }

      // Printer operation to generate final list state.
      System.out.printf("%s", "***");
      System.out.printf("\n%s\n", tableSpacer);
      System.out.printf("%2s", "v");
      for (Vertex v : adjacencyList)
         System.out.printf("%4s", v.getName());
      System.out.println();
      System.out.printf("%2s", "dV");
      for (Vertex v : adjacencyList)
         System.out.printf("%4s", v.getDistance());
      System.out.println();
      System.out.printf("%2s", "pV");
      for (Vertex v : adjacencyList)
         System.out.printf("%4s", v.getPath());
   }
}
