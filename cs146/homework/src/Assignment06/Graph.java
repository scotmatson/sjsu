/**

 */
package Assignment06;

import java.util.ArrayList;

public class Graph
{
   public ArrayList generateGraph981()
   {
      // Initializing the Vertices
      final Vertex vA = new Vertex("A", 2);
      final Vertex vB = new Vertex("B", 1);
      final Vertex vC = new Vertex("C", 3);
      final Vertex vD = new Vertex("D", 2);
      final Vertex vE = new Vertex("E", 4);
      final Vertex vF = new Vertex("F", 2);
      final Vertex vG = new Vertex("G", 1);
      final Vertex vH = new Vertex("H", 1);
      final Vertex vI = new Vertex("I", 2);
      final Vertex vS = new Vertex("S", 0);
      final Vertex vT = new Vertex("T", 3);

      // Initializing the edges
      final Edge eAB = new Edge("AB", vB, 2);
      final Edge eAE = new Edge("AE", vE, 2);
      final Edge eBC = new Edge("BC", vC, 2);
      final Edge eCT = new Edge("CT", vT, 4);
      final Edge eDA = new Edge("DA", vA, 3);
      final Edge eDE = new Edge("DE", vE, 3);
      final Edge eEC = new Edge("EC", vC, 2);
      final Edge eEF = new Edge("EF", vF, 3);
      final Edge eEI = new Edge("EI", vI, 3);
      final Edge eFC = new Edge("FC", vC, 1);
      final Edge eFT = new Edge("FT", vT, 3);
      final Edge eGD = new Edge("GD", vD, 2);
      final Edge eGE = new Edge("GE", vE, 1);
      final Edge eGH = new Edge("GH", vH, 6);
      final Edge eHE = new Edge("HE", vE, 2);
      final Edge eHI = new Edge("HI", vI, 6);
      final Edge eIF = new Edge("IF", vF, 1);
      final Edge eIT = new Edge("IT", vT, 4);
      final Edge eSA = new Edge("SA", vA, 1);
      final Edge eSD = new Edge("SD", vD, 4);
      final Edge eSG = new Edge("SG", vG, 6);

      // Adding edges to vertices
      vA.addOutgoingEdge(eAB);
      vA.addOutgoingEdge(eAE);
      vB.addOutgoingEdge(eBC);
      vC.addOutgoingEdge(eCT);
      vD.addOutgoingEdge(eDA);
      vD.addOutgoingEdge(eDE);
      vE.addOutgoingEdge(eEC);
      vE.addOutgoingEdge(eEF);
      vE.addOutgoingEdge(eEI);
      vF.addOutgoingEdge(eFC);
      vF.addOutgoingEdge(eFT);
      vG.addOutgoingEdge(eGD);
      vG.addOutgoingEdge(eGE);
      vG.addOutgoingEdge(eGH);
      vH.addOutgoingEdge(eHE);
      vH.addOutgoingEdge(eHI);
      vI.addOutgoingEdge(eIF);
      vI.addOutgoingEdge(eIT);
      vS.addOutgoingEdge(eSA);
      vS.addOutgoingEdge(eSD);
      vS.addOutgoingEdge(eSG);

      // Create adjacency list
      final ArrayList<Vertex> adjacencyList = new ArrayList<>();
      adjacencyList.add(vA);
      adjacencyList.add(vB);
      adjacencyList.add(vC);
      adjacencyList.add(vD);
      adjacencyList.add(vE);
      adjacencyList.add(vF);
      adjacencyList.add(vG);
      adjacencyList.add(vH);
      adjacencyList.add(vI);
      adjacencyList.add(vS);
      adjacencyList.add(vT);

      return adjacencyList;
   }

   public ArrayList<Vertex> generateGraph982()
   {
      // Initializing the Vertices
      final Vertex vA = new Vertex("A", 1);
      final Vertex vB = new Vertex("B", 1);
      final Vertex vC = new Vertex("C", 2);
      final Vertex vD = new Vertex("D", 2);
      final Vertex vE = new Vertex("E", 3);
      final Vertex vF = new Vertex("F", 2);
      final Vertex vG = new Vertex("G", 1);

      final Edge eAB = new Edge("AB", vB, 5);
      final Edge eAC = new Edge("AC", vC, 3);
      final Edge eBG = new Edge("BG", vG, 1);
      final Edge eBE = new Edge("BE", vE, 3);
      final Edge eBC = new Edge("BC", vC, 2);
      final Edge eCE = new Edge("CE", vE, 7);
      final Edge eCD = new Edge("CD", vD, 7);
      final Edge eDA = new Edge("DA", vA, 2);
      final Edge eDF = new Edge("DF", vF, 6);
      final Edge eEF = new Edge("EF", vF, 1);
      final Edge eED = new Edge("ED", vD, 2);
      final Edge eGE = new Edge("GE", vE, 1);

      vA.addOutgoingEdge(eAB);
      vA.addOutgoingEdge(eAC);
      vB.addOutgoingEdge(eBG);
      vB.addOutgoingEdge(eBE);
      vB.addOutgoingEdge(eBC);
      vC.addOutgoingEdge(eCE);
      vC.addOutgoingEdge(eCD);
      vD.addOutgoingEdge(eDA);
      vD.addOutgoingEdge(eDF);
      vE.addOutgoingEdge(eEF);
      vE.addOutgoingEdge(eED);
      vG.addOutgoingEdge(eGE);

      final ArrayList<Vertex> adjacencyList = new ArrayList<>();
      adjacencyList.add(vA);
      adjacencyList.add(vB);
      adjacencyList.add(vC);
      adjacencyList.add(vD);
      adjacencyList.add(vE);
      adjacencyList.add(vF);
      adjacencyList.add(vG);

      return adjacencyList;
   }
}
