package Assignment06;

import java.util.ArrayList;

/**
 Created by scot on 7/26/15.
 */
public class UnweightedShortestPath
{
   public void path(ArrayList<Vertex> adjacencyList)
   {
      // Printer variables
      System.out.printf("%s\n", "*** UNWEIGHTED SHORTEST PATH - Graph 9.82");
      String tableSpacer = "----------------------------------";

      final int UNVISITED = -1;
      final int NUM_VERTICES = 7;

      Vertex s = adjacencyList.get(0);
      Queue<Vertex> q = new Queue<>();

      // Initializing Vertices distances
      for (Vertex v : adjacencyList)
         v.setDistance(UNVISITED);

      // Entry point for algorithm
      s.setDistance(0);
      q.enqueue(s);
      System.out.printf("\n%-15s %s", "Dequeue: ***", "Enqueue: " + s.getName());


      while (!q.isEmpty())
      {

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

         Vertex v = q.dequeue();
         System.out.printf("\n%-15s %s", "Dequeue: " + v.getName(), "Enqueue: ");

         for (Edge e : v.getOutgoingEdges())
         {
            if (e.getVertex().getDistance() == UNVISITED)
            {
               e.getVertex().setDistance(v.getDistance() + 1);
               e.getVertex().setPath(v.getName());
               q.enqueue(e.getVertex());
               System.out.printf("%s ", e.getVertex().getName());

            }
            if (e.getVertex().getDistance() > NUM_VERTICES)
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
