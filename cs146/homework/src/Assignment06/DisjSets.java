package Assignment06;

import java.util.ArrayList;
import java.util.List;

/**
 Created by scot on 8/1/15.
 */
public class DisjSets<Vertex>
{
   private List<Vertex> s;

   /**
    Constuct the disjoint sets Object
    */
   public DisjSets()
   {
      s = new ArrayList<>();

   }

   /**
    Union two disjoint sets.
    For simplicity we assume root1 and root2 are distinct.
    and represent set names.
    @param root1 the root of set 1
    @param root2 the root of set 2
    */
   public void union(Vertex root1, Vertex root2)
   {
      s.set(s.indexOf(root2), root1);
   }

   /**
    Perform a find.
    Error checks ommited for simplicity.
    @param x the element being searched for.
    @return the set containing x.
    */
   public Vertex find(Vertex x)
   {
      if (s.contains(x))
         return x;
      else
         return find(s.get(s.indexOf(x)));
   }
}
