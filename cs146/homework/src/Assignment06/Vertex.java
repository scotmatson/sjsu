package Assignment06;

import java.util.ArrayList;
import java.util.List;

/**
 Created by scot on 7/26/15.
 */
public class Vertex
{
   String name;
   int topNum; // Topological Numbering
   int indegree; // The number of edges
   List<Edge> outgoingEdges = new ArrayList<>();

   public Vertex(String n, int i)
   {
      this.name = n;
      this.indegree = i;
   }

   /**
    Adds a new Edge to the current Vertex
    @param e an Edge which connects two vertices
    */
   public void addOutgoingEdge(Edge e)
   {
      outgoingEdges.add(e);
   }

   /**

    @return an ArrayList of outgoing Edges
    */
   public List<Edge> getOutgoingEdges()
   {
      return outgoingEdges;
   }

   /**
    Gets the indegree.

    @return the current number of indegrees.
    */
   public int getIndegree()
   {
      return indegree;
   }

   public void setTopNum(int num)
   {
      this.topNum = num;
   }

   public void decrementIndegree()
   {
      --indegree;
   }

   public String getName()
   {
      return name;
   }

   //
   //class Edge {
   //   Vertex v;
   //   int weight;
   //
   //   private Edge (Vertex v, int weight)
   //   {
   //      this.v = v;
   //      this.weight = weight;
   //   }
   //}
}
