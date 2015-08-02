/**
 An unweighted shortest path algorithm.
 Uses a depth first search pattern.

 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

import java.io.PrintWriter;
import java.util.ArrayList;

public class UnweightedShortestPath
{
   /**
    A depth first search unweighted shortest path algorithm.
    @param pw a PrintWriter.
    @param adjacencyList a list of Vertices
    */
   public void path(PrintWriter pw,ArrayList<Vertex> adjacencyList)
   {
      // Printer variables
      pw.format("\n%s", "*** UNWEIGHTED SHORTEST PATH - Graph 9.82 ***");
      String tableSpacer = "------------------------------";

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
      pw.format("\n%-15s %s", "Dequeue: ***", "Enqueue: " + s.getName());

      // As long as the queue holds Vertices, continue to loop.
      while (!q.isEmpty())
      {

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

         // Remove the next Vertex in line for evaluation.
         Vertex v = q.dequeue();
         pw.format("\n%-15s %s", "Dequeue: " + v.getName(), "Enqueue: ");

         // Look at each of the Edges assigned to the Vertex.
         for (Edge e : v.getOutgoingEdges())
         {
            // If we've found an unvisited Vertex, add it to the queue.
            if (e.getVertex1().getDistance() == UNVISITED)
            {
               e.getVertex1().setDistance(v.getDistance() + 1);
               e.getVertex1().setPath(v.getName());
               q.enqueue(e.getVertex1());
               pw.format("%s ", e.getVertex1().getName());

            }

            // If the distance exceeds to total distance of the
            // graph, a potential cycle has been found and an
            // Exception is thrown.
            if (e.getVertex1().getDistance() > NUM_VERTICES)
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