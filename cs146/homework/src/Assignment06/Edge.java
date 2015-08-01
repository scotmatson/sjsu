package Assignment06;

/**
 Created by scot on 7/31/15.
 */
public class Edge
{
   String name;
   Vertex vertex;
   int weight;

   public Edge(String n, Vertex v, int w)
   {
      this.name = n;
      this.vertex = v;
      this.weight = w;
   }

   public Vertex getVertex()
   {
      return vertex;
   }
}
