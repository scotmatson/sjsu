/**
 COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved
 Interface for sorting algorithms.

 Solves CS147 Homework Assignment #04

 @author Scot Matson
 @version 1.00 2015/07/11
 */

package assignment04;

public interface Sortable
{
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a);
}
