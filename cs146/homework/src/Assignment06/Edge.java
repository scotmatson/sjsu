package Assignment06;

/**
 Created by scot on 7/31/15.
 */
public class Edge implements Comparable<Edge>
{
   String name;
   Vertex v1;
   Vertex v2;
   int weight;

   public Edge(String n, Vertex v, int w)
   {
      this.name = n;
      this.v1 = v;
      this.weight = w;
   }

   public Edge (String n, Vertex v1, Vertex v2, int w)
   {
      this.name = n;
      this.v1 = v1;
      this.v2 = v2;
      this.weight = w;
   }

   public Vertex getVertex1()
   {
      return this.v1;
   }

   public Vertex getVertex2()
   {
      return this.v2;
   }

   public int getWeight()
   {
      return this.weight;
   }

   @Override
   public int compareTo(Edge o)
   {
      Edge e = (Edge) o;
      if (this.getWeight() == e.getWeight())
         return 0;
      return this.getWeight() < e.getWeight() ? -1 : 1;
   }
}
