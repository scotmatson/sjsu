package Assignment06;

import java.util.*;

/**
 Created by scot on 7/26/15.
 */
public class KruskalsAlgorithm
{
   public void tree(ArrayList<Vertex> adjacencyList)
   {
      System.out.printf("%s\n\n", "*** KRUKAL's ALGORITHM - Graph 9.50 ***");
      System.out.printf("%6s %13s %10s\n", "Edge", "Weight", "Action");
      System.out.printf("%s\n", "-----------------------------------");


      HashMap<Vertex, Set<Vertex>> forest = new HashMap<>();
      for (Vertex v : adjacencyList)
      {
         Set<Vertex> tree = new HashSet<>();
         tree.add(v);
         forest.put(v, tree);
      }

      ArrayList<Edge> edgeList = new ArrayList<>();

      // Extract all of the edges from the adjacency list.
      for (Vertex v : adjacencyList)
         for (Edge e : v.getOutgoingEdges())
            edgeList.add(e);

      // Place the edges in ascending order by weight
      Collections.sort(edgeList);
      Queue<Edge> pq = new Queue<>(edgeList);
      List<Edge> mst = new ArrayList<>();

      while (true)
      {
         Edge check = pq.dequeue();
         Set<Vertex> visited1 = forest.get(check.v1);
         Set<Vertex> visited2 = forest.get(check.v2);

         if (visited1.equals(visited2))
         {
            System.out.printf("  (%s, %s) %4d %17s\n", check.v1.getName(), check.v2.getName(), check.getWeight(), "Rejected");
            continue;
         }

         System.out.printf("  (%s, %s) %4d %17s\n", check.v1.getName(), check.v2.getName(), check.getWeight(), "Accepted");

         mst.add(check);
         visited1.addAll(visited2);
         for(Vertex v : visited1)
         {
            forest.put(v, visited1);
         }
         if (visited1.size() == adjacencyList.size())
            break;
      }
   }
}
