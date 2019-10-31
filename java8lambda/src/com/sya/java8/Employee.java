/**
 * 
 */
package com.sya.java8;

/**
 * @author sammar
 *
 */
@FunctionalInterface
public interface Employee {

	public void doWork();

	public default void something(){
		System.out.println("Hi");
	}

}
