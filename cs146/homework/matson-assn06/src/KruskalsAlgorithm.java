/**
 Minimum Spanning Tree Graph Algorithm

 Solution for CS146 Assignment #06

 @author Scot Matson, attr. to Niru
    (http://stackoverflow.com/a/14660751/4280850)

 @version 08/01/2015
 */
package assignment06;

import java.io.PrintWriter;
import java.util.*;

public class KruskalsAlgorithm
{
   /**
    Kruskals Minimum Spanning Tree algorithm.
    @param pw a printWriter
    @param adjacencyList a list of Vertices
    */
   public void tree(PrintWriter pw, ArrayList<Vertex> adjacencyList)
   {
      // Print header for testing
      pw.format("\n%s\n", "*** KRUSKAL's ALGORITHM - Graph 9.50 ***");
      pw.format("%6s %13s %10s\n", "Edge", "Weight", "Action");
      pw.format("%s\n", "-----------------------------------");

      // Generate a map of all vertices to compare their Edge
      // Edge relationships against one another.
      HashMap<Vertex, Set<Vertex>> forest = new HashMap<>();
      for (Vertex v : adjacencyList)
      {
         Set<Vertex> tree = new HashSet<>();
         tree.add(v);
         forest.put(v, tree);
      }

      // Extract the Edges from all of the Vertices in the
      // adjacency list.
      ArrayList<Edge> edgeList = new ArrayList<>();
      for (Vertex v : adjacencyList)
         for (Edge e : v.getOutgoingEdges())
            edgeList.add(e);
      // Place the edges in ascending order by weight
      Collections.sort(edgeList);

      // Place the Edges into the queue so they may be easily
      // accessed by their sorted order.
      Queue<Edge> pq = new Queue<>(edgeList);
      // mst = The Minimum Spanning Tree.
      // Commeneted out at this time as it is not being used but
      // the desired results would be stored in this data structure.
      // List<Edge> mst = new ArrayList<>();

      // Create an infinite loop which only breaks after all
      // known Vertices have been visited.
      while (true)
      {
         // Begin dequeing Edges and merge the Set of reachable vertices
         // stored by the Edge.
         Edge check = pq.dequeue();
         Set<Vertex> visited1 = forest.get(check.getVertex1());
         Set<Vertex> visited2 = forest.get(check.getVertex2());

         // If the sets are the same, do not merge them as they will create
         // a cycle.
         if (visited1.equals(visited2))
         {
            pw.format("  (%s, %s) %4d %17s\n", check.getVertex1().getName(),
               check.getVertex2().getName(), check.getWeight(), "Rejected");
            continue;
         }

         // If the sets are not equal, add the Edge to the MST.
         pw.format("  (%s, %s) %4d %17s\n", check.getVertex1().getName(),
            check.getVertex2().getName(), check.getWeight(), "Accepted");

         // mst.add(check);

         // Merge the list of visited vertices.
         visited1.addAll(visited2);
         for(Vertex v : visited1)
            forest.put(v, visited1);

         // Once we have visited every Vertex, break the loop and
         // leave the algorithm.
         if (visited1.size() == adjacencyList.size())
            break;
      }
   }
}
