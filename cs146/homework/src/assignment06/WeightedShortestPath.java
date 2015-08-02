/**
 Weighted shortest path algorithm (Dikstra's Algorithm).
 For use with a graph structure.

 Solution for CS146 Assignment #06

 @author Scot Matson

 @version 08/01/2015
 */
package assignment06;

import java.io.PrintWriter;
import java.util.ArrayList;

public class WeightedShortestPath
{
   /**
    Dikstra's shorting spanning path algorithm.
    @param pw a PrintWriter
    @param adjacencyList a list of Vertices.
    */
   public void path(PrintWriter pw, ArrayList<Vertex> adjacencyList)
   {
      // Printer variables
      pw.format("\n%s", "*** WEIGHTED SHORTEST PATH - Graph 9.82 ***");
      String tableSpacer = "------------------------------";

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
      pw.format("\n%-15s %s", "Dequeue: ***", "Enqueue: " + s.getName());


      // Only Vertices with unknown distances should be stored in the queue
      while (!q.isEmpty())
      {
         // Printing operations.
         pw.format("\n%s\n", tableSpacer);
         pw.format("%2s", "v");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getName());
         pw.format("\n");
         pw.format("%2s", "dV");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getDistance());
         pw.format("\n");
         pw.format("%2s", "pV");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getPath());
         pw.format("\n");

         // Smallest unknown distance vertex
         Vertex v = q.dequeue();

         pw.format("\n%-15s %s", "Dequeue: " + v.getName(), "Enqueue: ");

         // For each outgoing edge
         for (Edge e : v.getOutgoingEdges())
         {
            // In the case that the Vertex has not yet been visited,
            // set a new weight based upon the weight of the current edge
            // and the weight of the preceding vertices.
            if (e.getVertex1().getDistance() == UNVISITED)
            {
               e.getVertex1().setDistance(v.getDistance() + e.getWeight());
               e.getVertex1().setPath(v.getName());
               q.enqueue(e.getVertex1());
               pw.format("%s ", e.getVertex1().getName());
            }
            else
            {
               // Check the weight of the current path against the weight
               // of the incoming Vertex and update the weight if a lower
               // value is found.
               if (e.getVertex1().getDistance() > v.getDistance() + e.getWeight())
               {
                  e.getVertex1().setDistance(v.getDistance() + e.getWeight());
                  e.getVertex1().setPath(v.getName());
                  pw.format("%s ", e.getVertex1().getName());
               }
            }

            // If the current weight exceeds the total weight of the
            // graph we have potentially found a cycle. Throw an Exception
            // and exit the applicaiton.
            if (e.getVertex1().getDistance() > WEIGHT_LIMIT)
            {
               throw new IllegalStateException("Excessive distance.");
            }
         }
      }

      // Printer operation to generate final list state.
      pw.format("%s", "***");
      pw.format("\n%s\n", tableSpacer);
      pw.format("%2s", "v");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getName());
      pw.format("\n");
      pw.format("%2s", "dV");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getDistance());
      pw.format("\n");
      pw.format("%2s", "pV");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getPath());
      pw.format("\n");
   }
}