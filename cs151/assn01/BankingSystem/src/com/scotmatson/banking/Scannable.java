/**
 * 
 */
package com.scotmatson.banking;

public interface Scannable<T> {
	
	/**
	 * Used to scan information from scannable objects
	 *  (i.e., cards & tickets).
	 * 
	 * @return an Array of information stored on the object.
	 */
	public void scan(T t);
	
}
