/**
 Vertices used with Edges to generate
 graph structures.

 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

import java.util.ArrayList;
import java.util.List;

public class Vertex
{
   private String name;
   private int topNum; // Topological Numbering
   private int indegree; // The number of edges
   private int distance;
   private List<Edge> outgoingEdges = new ArrayList<>();
   private String path;
   private boolean known;

   /**
    Constructor method.
    @param n the name of the Vertex.
    @param i the number of indegrees.
    */
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
    Gets the list of outgoing Edges.
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

   /**
    Assigns a numerical value based upon the order
    the Vertex was visited.
    Used in a topological sorting algorihtm.
    @param num the number to assign.
    */
   public void setTopNum(int num)
   {
      this.topNum = num;
   }

   /**
    Decrements the current indegree.
    */
   public void decrementIndegree()
   {
      if (getIndegree() > 0)
         --indegree;
   }

   /**
    Gets the name of the Vertex
    @return the name.
    */
   public String getName()
   {
      return name;
   }

   /**
    Sets the distance of the current Vertex from the
    point of entry.
    @param d the distance.
    */
   public void setDistance(int d)
   {
      this.distance = d;
   }

   /**
    Gets the distance of the Vertex away from a graph entry point.
    @return the distance.
    */
   public int getDistance()
   {
      return this.distance;
   }

   /**
    Stores the name of the Vertex by which this Vertex
    was reached.
    @param v the name of an adjacent Vertex.
    */
   public void setPath(String v)
   {
      this.path = v;
   }

   /**
    Sets a flag to indicate if the Vertex has been discovered.
    @param k a truthy value.
    */
   public void setKnown(boolean k)
   {
      this.known = k;
   }

   /**
    Gets the value of the flag which indicates if the
    vertex has been discovered.
    @return a truthy value.
    */
   public boolean getKnown()
   {
      return this.known;
   }

   /**
    Gets the path of a neighboring Vertex by which
    this Vertex was reached.
    @return an adjacent Vertex.
    */
   public String getPath()
   {
      return this.path;
   }
}
