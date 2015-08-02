package Assignment06;

/**
 Created by scot on 7/31/15.
 */
public class AlgorithmTester
{
   public static void main(String[] args) throws CycleFoundException
   {
      Graph g = new Graph();

      //TopologicalSort tps = new TopologicalSort();
      //tps.sort(g.generateGraph981());

      //UnweightedShortestPath usp = new UnweightedShortestPath();
      //usp.path(g.generateGraph982());

      //WeightedShortestPath wsp = new WeightedShortestPath();
      //wsp.path(g.generateGraph982());

      PrimsAlgorithm pa = new PrimsAlgorithm();
      pa.tree(g.generateGraph95());

      //KruskalsAlgorithm ka = new KruskalsAlgorithm();
      //ka.tree(g.generateGraph950());
   }
}
