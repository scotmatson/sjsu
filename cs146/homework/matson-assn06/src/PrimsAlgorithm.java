/**
 Minimum Spanning Tree Graph Algorithm

 Solution for CS146 Assignment #06

 @author Scot Matson

 @version 08/01/2015
 */
package assignment06;

import java.io.PrintWriter;
import java.util.ArrayList;

public class PrimsAlgorithm
{
   /**
    Prim's minimum spanning tree algorithm.
    @param pw a PrintWriter
    @param adjacencyList a list of Vertices.
    */
   public void tree(PrintWriter pw, ArrayList<Vertex> adjacencyList)
   {
      // Print headers for testing.
      pw.format("\n%s", "*** PRIM'S ALGORITHM - Graph 9.50 ***");
      String tableSpacer = "---------------------------------";

      final int UNVISITED = -1;
      final int WEIGHT_LIMIT = 53; // Total weight of Graph 9.50

      Vertex s = adjacencyList.get(0);
      Queue<Vertex> q = new Queue<>();

      // Initializing Vertices distances
      for (Vertex v : adjacencyList)
         v.setDistance(UNVISITED);

      // Entry point for algorithm
      s.setDistance(0);
      q.enqueue(s);
      pw.format("\n%-15s %s", "Dequeue: ***", "Enqueue: " + s.getName());


      // Only Vertices with unknown distances should be stored in the queue.
      // As long as we have Vertices in the queue, continue looping.
      while (!q.isEmpty())
      {
         // Print analytics.
         pw.format("\n%s\n", tableSpacer);
         // Vertex
         pw.format("%2s", "v");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getName());
         pw.format("\n");
         // Known
         pw.format("%2s", "kV");
         for (Vertex v: adjacencyList)
         {
            String known = (v.getKnown()) ? "T": "F";
            pw.format("%4s", known);
         }
         pw.format("\n");
         // Distance
         pw.format("%2s", "dV");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getDistance());
         pw.format("\n");
         // Path
         pw.format("%2s", "pV");
         for (Vertex v : adjacencyList)
            pw.format("%4s", v.getPath());
         pw.format("\n");

         // Smallest unknown distance vertex
         Vertex v = q.dequeue();
         v.setKnown(true);
         pw.format("\n%-15s %s", "Dequeue: " + v.getName(), "Enqueue: ");

         // For each outgoing edge
         for (Edge e : v.getOutgoingEdges())
         {
            // In the case that the Vertex has not yet been visited,
            // set a new weighted based upon the adjacent edges.
            if (e.getVertex1().getDistance() == UNVISITED)
            {
               e.getVertex1().setDistance(e.getWeight());
               e.getVertex1().setPath(v.getName());
               q.enqueue(e.getVertex1());
               pw.format("%s ", e.getVertex1().getName());
            } else
            {
               // Check the weight of the current edge against the weight of
               // the previously stored edge weight. If we have found a lower
               // weight which does not break the path, then store it.
               if (e.getVertex1().getDistance() > e.getWeight() && e.getVertex1().getKnown())
               {
                  e.getVertex1().setDistance(e.getWeight());
                  e.getVertex1().setPath(v.getName());
                  pw.format("%s ", e.getVertex1().getName());
               }
            }

            // If our travelled distance exceeds the total weight of
            // the graph then end the application and throw an Exception.
            if (e.getVertex1().getDistance() > WEIGHT_LIMIT)
            {
               throw new IllegalStateException("Excessive distance.");
            }
         }
      }

      // Printer operation to generate final list state.
      pw.format("\n%s\n", tableSpacer);
      // Vertex
      pw.format("%2s", "v");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getName());
      pw.format("\n");
      // Known
      pw.format("%2s", "kV");
      for (Vertex v: adjacencyList)
      {
         String known = (v.getKnown()) ? "T": "F";
         pw.format("%4s", known);
      }
      pw.format("\n");
      // Distance
      pw.format("%2s", "dV");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getDistance());
      pw.format("\n");
      // Path
      pw.format("%2s", "pV");
      for (Vertex v : adjacencyList)
         pw.format("%4s", v.getPath());
      pw.format("\n");
   }
}