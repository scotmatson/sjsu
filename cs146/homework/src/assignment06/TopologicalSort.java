/**
 Topological Sorting Algorithm
   Performs a topological sort with a queue and prints
   the output to a table.

 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TopologicalSort
{
   /**
    Topological sorting algorithm.
    @param pw a PrintWriter.
    @param adjacencyList a list of Vertices.
    @throws CycleFoundException
    */
   public void sort(PrintWriter pw, ArrayList<Vertex> adjacencyList)
      throws CycleFoundException
   {
      // The number of vertices in the list.
      final int NUM_VERTICES = adjacencyList.size();
      Queue<Vertex> q = new Queue<>();
      int counter = 0;

      // Variables used for printing output
      String[] tableHead = {
         "Enqueue", "Dequeue", "A", "B", "C", "D",
         "E", "F", "G", "H", "I", "S", "T"
      };

      pw.format("*** TOPOLOGICAL SORT - Graph 9.81 ***\n");
      pw.format("%s %s %s %2s %2s %2s %2s %2s %2s %2s %2s %2s %2s\n", tableHead[0], tableHead[1], tableHead[2], tableHead[3], tableHead[4], tableHead[5], tableHead[6], tableHead[7], tableHead[8], tableHead[9], tableHead[10], tableHead[11], tableHead[12]);
      pw.format("%s\n", "-----------------------------------------------");

      ArrayList<String> sortedOrder = new ArrayList<>();
      String pEnq = "";
      String pDeq = "";

      // For each Vertex v in our adjacency list, check
      // to see if at least one has (indegree == 0)
      for (Vertex vEntry : adjacencyList)
      {
         // If an indegree of 0 is found, then
         // we have located an entry point to our graph.
         if (vEntry.getIndegree() == 0)
         {
            q.enqueue(vEntry);
            pEnq += vEntry.getName() + " ";
            break;
         }
      }

      // Remove Vertices from the queue and assign them a number.
      // Locate adjacent Vertices and decrement their indegree.
      // If a Vertex's indegree goes to zero, enqueue it.
      while (!q.isEmpty())
      {
         Vertex vPath = q.dequeue();
         pDeq += vPath.getName();
         sortedOrder.add(vPath.getName());

         // Print the Enqueues and Dequeues
         pw.format("%-8s", pEnq);
         pw.format("%-6s", pDeq);
         // Print the updated list of Edges
         for (Vertex vCount : adjacencyList)
            pw.format("%3s", vCount.getIndegree());
         pw.format("\n");
         pEnq = "";
         pDeq = "";

         // Assign the sorting order to the current Vertex
         vPath.setTopNum(++counter);
         // Cycle through the Vertices Edges and decrement the indegree's
         // from adjacent Vertices. Enqueue any Vertex whoes Indegree
         // goes to zero.
         for (Edge e : vPath.getOutgoingEdges())
         {
            e.getVertex1().decrementIndegree();
            if (e.getVertex1().getIndegree() == 0)
            {
               q.enqueue(e.getVertex1());
               pEnq += e.getVertex1().getName() + " ";
            }
         }
      }

      if (counter != NUM_VERTICES)
         throw new CycleFoundException();

      // Print sorted order.
      pw.format("\nTopologically Sorted Order\n");
      for (String s : sortedOrder)
         pw.format("%-2s", s);
      pw.format("\n");
   }
}
