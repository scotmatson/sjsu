package assignment02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 Created by scot on 6/16/15.
 */
public class IndexedListTester
{

   // To print out to a file
   // formatting
   // test various n and k values
   // test GET, REMOVE

   public static void main(String[] args) throws IOException
   {
      PrintWriter pw = new PrintWriter("list_performance_results.txt", "UTF-8");
      List<Integer> al = new ArrayList<>();
      List<Integer> ll = new LinkedList<>();
      IndexedList<Integer> id = new IndexedList<>();

      //appendingWriter(pw, al, ll, id);
      //insertionWriter(pw, al, ll, id);
      //setWriter(pw, al, ll, id);
      //getWriter(pw, al, ll, id);
      removeWriter(pw, al, ll, id);

      //id.clear();
      //Random rand = new Random();
      //for (int i = 0; i < 51; ++i) {
      //   id.add(rand.nextInt(100));
      //}
      //id.printNodeGraph();

      //id.remove(0);
      //id.printNodeGraph();
      //id.remove(2);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.remove(0);
      //id.printNodeGraph();
      //id.remove(0);

      //System.out.println("Starting size : " + id.size());
      //for (int i = 0; i < 50; ++i)
      //{
      //   id.remove(0);
      //}
      //
      //id.remove(0);
      //id.printNodeGraph();

      //System.out.println();
      //System.out.println("Leftovers...");
      //for (int i = 0; i < id.size(); ++i) {
      //   System.out.println("["+i+"]"+" "+id.get(i));
      //}

      pw.close();
   }

   public static double appendingTest(int n, List list)
   {
      list.clear();
      Random rand = new Random();
      double start = System.currentTimeMillis();

      for (int i = 0; i < n; ++i)
      {
         list.add(rand.nextInt());
      }
      return (System.currentTimeMillis() - start);
   }

   public static void appendingWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: add(Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 1000000; n*=10 )
      {
         pw.format("%10d   add(): %8.0f ms   add(): %8.0f ms   add(): %8.0f ms\n", n, appendingTest(n, al), appendingTest(n, ll), appendingTest(n, id));
      }
   }

   public static double insertionTest(int n, List list)
   {
      list.clear();
      Random rand = new Random();
      double start = System.currentTimeMillis();

      for (int i = 0; i < n; ++i)
      {
         list.add(0);
         list.add(rand.nextInt(list.size()), rand.nextInt(100));
      }
      return (System.currentTimeMillis() - start);
   }

   public static void insertionWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: add(int index, Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 100000; n*=10 )
      {
         pw.format("%10d   add(): %8.0f ms   add(): %8.0f ms   add(): %8.0f ms\n", n, insertionTest(n, al), insertionTest(n, ll), insertionTest(n, id));
      }
   }

   public static double setTest(int n, List list)
   {
      list.clear();
      Random rand = new Random();
      for (int i = 0; i < n; ++i) {
         list.add(rand.nextInt(100));
      }

      double start = System.currentTimeMillis();

      for (int i = 0; i < list.size(); ++i)
      {
         list.set(rand.nextInt(list.size()), rand.nextInt(100));
      }
      return (System.currentTimeMillis() - start);
   }

   public static void setWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: set(int index, Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 100000; n*=10 )
      {
         pw.format("%10d   set(): %8.0f ms   set(): %8.0f ms   set(): %8.0f ms\n", n, setTest(n, al), setTest(n, ll), setTest(n, id));
      }
   }

   public static double getTest(int n, List list)
   {
      list.clear();
      Random rand = new Random();
      for (int i = 0; i < n; ++i) {
         list.add(rand.nextInt(100));
      }

      double start = System.currentTimeMillis();
      for (int i = 0; i < n; ++i)
      {
         list.get(rand.nextInt(list.size()));
      }
      return (System.currentTimeMillis() - start);
   }

   public static void getWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: set(int index, Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 100000; n*=10 )
      {
         pw.format("%10d   get(): %8.0f ms   get(): %8.0f ms   get(): %8.0f ms\n", n, getTest(n, al), getTest(n, ll), getTest(n, id));
      }
   }

   public static double removeTest(int n, List list)
   {
      list.clear();
      Random rand = new Random();
      for (int i = 0; i < n; ++i) {
         list.add(rand.nextInt(100));
      }

      double start = System.currentTimeMillis();
      for (int i = 0; i < list.size(); ++i)
      {
         list.remove(rand.nextInt(list.size()));
      }
      return (System.currentTimeMillis() - start);
   }

   public static void removeWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: remove(int index, Integer integer)\n");
      pw.format("%10s %11s %24s %24s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 100000; n*=10 )
      {
         pw.format("%10d   remove(): %8.0f ms   remove(): %8.0f ms   remove(): %8.0f ms\n", n, removeTest(n, al), removeTest(n, ll), removeTest(n, id));
      }
   }
}
