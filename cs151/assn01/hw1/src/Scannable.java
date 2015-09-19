/**
 * 
 * COPYRIGHT (C) 2015 Scot Matson. All Rights Reserved.
 * 
 * Interface used to define method headers for scannable Objects.
 * 
 * Solves CS151 homework assignment #1
 * 
 * @author Scot Matson
 * 
 * @version 1.01 2015/9/18
 * 
 */
public interface Scannable<T>
{

   /**
    * Used to scan information from scannable objects (i.e., cards & tickets).
    * 
    * @return an Array of information stored on the object.
    */
   public void scan(T t);

}
