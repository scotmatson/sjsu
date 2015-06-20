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
   // test GET, SET, ADD, REMOVE

   public static void main(String[] args) throws IOException
   {
      PrintWriter pw = new PrintWriter("list_performance_results.txt", "UTF-8");
      List<Integer> al = new ArrayList<>();
      List<Integer> ll = new LinkedList<>();
      List<Integer> id = new IndexedList<>();

      //appendingWriter(pw, al, ll, id);
      insertionWriter(pw, al, ll, id);

      pw.close();
   }

   public static double appendingTest(int n, List list)
   {
      Random rand = new Random();
      double start = System.currentTimeMillis();

      for (int i = 0; i < n; ++i)
      {
         list.add(rand.nextInt());
      }
      return System.currentTimeMillis() - start;
   }

   public static void appendingWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: add(Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 1000000; n*=10 )
      {
         pw.format("%10d   add(): %8.0f ms   add(): %8.0f ms   add(): %8.0f ms\n", n, appendingTest(n, al), appendingTest(n, ll), appendingTest(n, id));
         al.clear();
         ll.clear();
         id.clear();
      }
   }

   public static double insertionTest(int n, List list)
   {
      Random rand = new Random();
      double start = System.currentTimeMillis();

      for (int i = 0; i < n; ++i)
      {
         list.add(0);
         list.add(rand.nextInt(list.size()), rand.nextInt(1000));
      }
      return System.currentTimeMillis() - start;
   }

   public static void insertionWriter(PrintWriter pw, List<Integer> al, List<Integer> ll, List<Integer> id)
   {
      pw.format("Testing Method: add(int index, Integer integer)\n");
      pw.format("%10s %11s %21s %21s\n", "N", "ArrayList", "LinkedList", "IndexedList");
      for (int n = 10; n <= 100000; n*=10 )
      {
         pw.format("%10d   add(): %8.0f ms   add(): %8.0f ms   add(): %8.0f ms\n", n, insertionTest(n, al), insertionTest(n, ll), insertionTest(n, id));
         al.clear();
         ll.clear();
         id.clear();
      }
   }
}
