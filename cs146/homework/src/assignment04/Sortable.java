package assignment04;

/**
 Created by scot on 7/11/15.
 */
public interface Sortable
{
   public <AnyType extends Comparable<? super AnyType>>
   void sort(AnyType[] a);
}
