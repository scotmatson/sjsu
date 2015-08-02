/**
 Generates an Edge between two vertices.
 Used in graph algorithms.

 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

public class Edge implements Comparable<Edge>
{
   String name;
   Vertex v1;
   Vertex v2;
   int weight;

   /**
    Constructor method.
    @param n name identifier.
    @param v Vertex pointer.
    @param w weight of the Edge.
    */
   public Edge(String n, Vertex v, int w)
   {
      this.name = n;
      this.v1 = v;
      this.weight = w;
   }

   /**
    Constructor method.
    @param n name identifier.
    @param v1 Vertex pointer.
    @param v2 Vertex pointer.
    @param w weight of the Edge.
    */
   public Edge (String n, Vertex v1, Vertex v2, int w)
   {
      this.name = n;
      this.v1 = v1;
      this.v2 = v2;
      this.weight = w;
   }

   /**
    Gets a Vertex being pointed to.
    @return a Vertex.
    */
   public Vertex getVertex1()
   {
      return this.v1;
   }

   /**
    Gets a Vertex being pointed to.
    @return a Vertex.
    */
   public Vertex getVertex2()
   {
      return this.v2;
   }

   /**
    Gets the weight of the Edge.
    @return the Edge weight.
    */
   public int getWeight()
   {
      return this.weight;
   }

   /**
    Compares the weight of two Edges.
    @param o another Edge.
    @return the weight of the Edge being compared against.
    */
   @Override
   public int compareTo(Edge o)
   {
      Edge e = (Edge) o;
      if (this.getWeight() == e.getWeight())
         return 0;
      return this.getWeight() < e.getWeight() ? -1 : 1;
   }
}
