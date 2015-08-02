package Assignment06;

import java.util.ArrayList;
import java.util.List;

/**
 Created by scot on 7/26/15.
 */
public class Vertex
{
   private String name;
   private int topNum; // Topological Numbering
   private int indegree; // The number of edges
   private int distance;
   private List<Edge> outgoingEdges = new ArrayList<>();
   private String path;
   private boolean known;

   public Vertex(String n, int i)
   {
      this.name = n;
      this.indegree = i;
      path = "0";
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

   /**
    Assigns a name to the Vertex for debugging and printing.
    @return
    */
   public String getName()
   {
      return name;
   }

   /**
    Sets the distance of the current Vertex from the
    point of entry.

    @param d
    */
   public void setDistance(int d)
   {
      this.distance = d;
   }

   public int getDistance()
   {
      return this.distance;
   }

   public void setPath(String v)
   {
      this.path = v;
   }

   public void setKnown(boolean k)
   {
      this.known = k;
   }

   public boolean getKnown()
   {
      return this.known;
   }

   public String getPath()
   {
      return this.path;
   }
}
