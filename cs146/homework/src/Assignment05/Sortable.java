/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Interface for sorting algorithms.

 Solves CS147 Homework Assignment #05

 @author Scot Matson

 @version 2015/07/11
 */

package Assignment05;

public interface Sortable
{
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a);
}
