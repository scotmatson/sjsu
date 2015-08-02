/**
 Generates graphs (adjacency lists) for use
 with graph sorting algorithms. Graphs are
 based upon diagrams found in Mark Allen Weiss's
 Data Structures and Algorithms text.

 Solution for CS146 Assignment #06

 @author Scot Matson, attr. Mark Allen Weiss
 @version 08/01/2015
 */
package assignment06;

import java.util.ArrayList;

public class Graph
{
   /**
    Directed Acyclic Graph
    @return a DAG graph as a list.
    */
   public ArrayList<Vertex> generateGraph981()
   {
      // Initializing vertices
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

      // Initializing edges
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

   /**
    Directed Acyclic graph
    @return a DAG graph as a list.
    */
   public ArrayList<Vertex> generateGraph982()
   {
      // Initializing vertices
      final Vertex vA = new Vertex("A", 1);
      final Vertex vB = new Vertex("B", 1);
      final Vertex vC = new Vertex("C", 2);
      final Vertex vD = new Vertex("D", 2);
      final Vertex vE = new Vertex("E", 3);
      final Vertex vF = new Vertex("F", 2);
      final Vertex vG = new Vertex("G", 1);

      // Initializing edges
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

      // Adding edges to vertices
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

      // Create adjacency list
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

   public ArrayList<Vertex> generateGraph950a()
   {
      // Initializing vertices
      Vertex v1 = new Vertex("V1", 3);
      Vertex v2 = new Vertex("V2", 3);
      Vertex v3 = new Vertex("V3", 3);
      Vertex v4 = new Vertex("V4", 6);
      Vertex v5 = new Vertex("V5", 3);
      Vertex v6 = new Vertex("V6", 3);
      Vertex v7 = new Vertex("V7", 3);

      // Initializing edges
      Edge e12 = new Edge("12", v2, 2);
      Edge e13 = new Edge("13", v3, 4);
      Edge e14 = new Edge("14", v4, 1);
      Edge e21 = new Edge("21", v1, 2);
      Edge e24 = new Edge("24", v4, 3);
      Edge e25 = new Edge("25", v5, 10);
      Edge e31 = new Edge("31", v1, 4);
      Edge e34 = new Edge("34", v4, 2);
      Edge e36 = new Edge("36", v6, 5);
      Edge e41 = new Edge("41", v1, 1);
      Edge e42 = new Edge("42", v2, 3);
      Edge e43 = new Edge("43", v3, 2);
      Edge e45 = new Edge("45", v5, 7);
      Edge e46 = new Edge("46", v6, 8);
      Edge e47 = new Edge("47", v7, 4);
      Edge e52 = new Edge("52", v2, 10);
      Edge e54 = new Edge("54", v4, 7);
      Edge e57 = new Edge("57", v7, 6);
      Edge e63 = new Edge("63", v3, 5);
      Edge e64 = new Edge("64", v4, 8);
      Edge e67 = new Edge("67", v7, 1);
      Edge e74 = new Edge("74", v4, 4);
      Edge e75 = new Edge("75", v5, 6);
      Edge e76 = new Edge("76", v6, 1);

      // Adding edges to vertices
      v1.addOutgoingEdge(e12);
      v1.addOutgoingEdge(e13);
      v1.addOutgoingEdge(e14);
      v2.addOutgoingEdge(e21);
      v2.addOutgoingEdge(e24);
      v2.addOutgoingEdge(e25);
      v3.addOutgoingEdge(e31);
      v3.addOutgoingEdge(e34);
      v3.addOutgoingEdge(e36);
      v4.addOutgoingEdge(e41);
      v4.addOutgoingEdge(e42);
      v4.addOutgoingEdge(e43);
      v4.addOutgoingEdge(e45);
      v4.addOutgoingEdge(e46);
      v4.addOutgoingEdge(e47);
      v5.addOutgoingEdge(e52);
      v5.addOutgoingEdge(e54);
      v5.addOutgoingEdge(e57);
      v6.addOutgoingEdge(e63);
      v6.addOutgoingEdge(e64);
      v6.addOutgoingEdge(e67);
      v7.addOutgoingEdge(e74);
      v7.addOutgoingEdge(e75);
      v7.addOutgoingEdge(e76);

      // Create adjacency list
      ArrayList<Vertex> adjacencyList = new ArrayList<>();
      adjacencyList.add(v1);
      adjacencyList.add(v2);
      adjacencyList.add(v3);
      adjacencyList.add(v4);
      adjacencyList.add(v5);
      adjacencyList.add(v6);
      adjacencyList.add(v7);

      return adjacencyList;
   }

   /**
    Undirected Cyclic Graph
    @return a UCG graph as a list.
    */
   public ArrayList<Vertex> generateGraph950b()
   {
      // Initializing vertices
      Vertex v1 = new Vertex("V1", 3);
      Vertex v2 = new Vertex("V2", 3);
      Vertex v3 = new Vertex("V3", 3);
      Vertex v4 = new Vertex("V4", 6);
      Vertex v5 = new Vertex("V5", 3);
      Vertex v6 = new Vertex("V6", 3);
      Vertex v7 = new Vertex("V7", 3);

      // Initializing edges
      Edge e12 = new Edge("12", v1, v2, 2);
      Edge e13 = new Edge("13", v1, v3, 4);
      Edge e14 = new Edge("14", v1, v4, 1);
      Edge e21 = new Edge("21", v2, v1, 2);
      Edge e24 = new Edge("24", v2, v4, 3);
      Edge e25 = new Edge("25", v2, v5, 10);
      Edge e31 = new Edge("31", v3, v1, 4);
      Edge e34 = new Edge("34", v3, v4, 2);
      Edge e36 = new Edge("36", v3, v6, 5);
      Edge e41 = new Edge("41", v4, v1, 1);
      Edge e42 = new Edge("42", v4, v2, 3);
      Edge e43 = new Edge("43", v4, v3, 2);
      Edge e45 = new Edge("45", v4, v5, 7);
      Edge e46 = new Edge("46", v4, v6, 8);
      Edge e47 = new Edge("47", v4, v7, 4);
      Edge e52 = new Edge("52", v5, v2, 10);
      Edge e54 = new Edge("54", v5, v4, 7);
      Edge e57 = new Edge("57", v5, v7, 6);
      Edge e63 = new Edge("63", v6, v3, 5);
      Edge e64 = new Edge("64", v6, v4, 8);
      Edge e67 = new Edge("67", v6, v7, 1);
      Edge e74 = new Edge("74", v7, v4, 4);
      Edge e75 = new Edge("75", v7, v5, 6);
      Edge e76 = new Edge("76", v7, v6, 1);

      // Adding edges to vertices
      v1.addOutgoingEdge(e12);
      v1.addOutgoingEdge(e13);
      v1.addOutgoingEdge(e14);
      v2.addOutgoingEdge(e21);
      v2.addOutgoingEdge(e24);
      v2.addOutgoingEdge(e25);
      v3.addOutgoingEdge(e31);
      v3.addOutgoingEdge(e34);
      v3.addOutgoingEdge(e36);
      v4.addOutgoingEdge(e41);
      v4.addOutgoingEdge(e42);
      v4.addOutgoingEdge(e43);
      v4.addOutgoingEdge(e45);
      v4.addOutgoingEdge(e46);
      v4.addOutgoingEdge(e47);
      v5.addOutgoingEdge(e52);
      v5.addOutgoingEdge(e54);
      v5.addOutgoingEdge(e57);
      v6.addOutgoingEdge(e63);
      v6.addOutgoingEdge(e64);
      v6.addOutgoingEdge(e67);
      v7.addOutgoingEdge(e74);
      v7.addOutgoingEdge(e75);
      v7.addOutgoingEdge(e76);

      // Create adjacency list
      ArrayList<Vertex> adjacencyList = new ArrayList<>();
      adjacencyList.add(v1);
      adjacencyList.add(v2);
      adjacencyList.add(v3);
      adjacencyList.add(v4);
      adjacencyList.add(v5);
      adjacencyList.add(v6);
      adjacencyList.add(v7);

      return adjacencyList;
   }
}
