/**
 Algorithm Testing Class
 Tests functionality for,
    -Topological Sort
    -Breadth First Search/Shortest Path (Unweighted)
    -Dikstra's Algorithm/Shortest Path (Weighted)
    -Prim's Algorithm/Minimum Spanning Tree
    -Kruskal's Algorithm/Minimum Spannin Tree


 Solution for CS146 Assignment #06

 @author Scot Matson
 @version 08/01/2015
 */
package assignment06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class AlgorithmTester
{
   public static void main(String[] args) throws CycleFoundException,
   FileNotFoundException
   {
      PrintWriter pw = new PrintWriter(new File("graphAlgoOutput_SMatson.txt"));

      // Graph generating object.
      Graph g = new Graph();

      TopologicalSort tps = new TopologicalSort();
      tps.sort(pw, g.generateGraph981());

      UnweightedShortestPath usp = new UnweightedShortestPath();
      usp.path(pw, g.generateGraph982());

      WeightedShortestPath wsp = new WeightedShortestPath();
      wsp.path(pw, g.generateGraph982());

      PrimsAlgorithm pa = new PrimsAlgorithm();
      pa.tree(pw, g.generateGraph950a());

      KruskalsAlgorithm ka = new KruskalsAlgorithm();
      ka.tree(pw, g.generateGraph950b());

      pw.close();
   }
}
