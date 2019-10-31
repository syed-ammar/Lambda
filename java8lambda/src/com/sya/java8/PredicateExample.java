/**
 * 
 */
package com.sya.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author sammar
 *
 */
public class PredicateExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<EmployeePojo> empList = Arrays.asList(new EmployeePojo(100,"Syed","Ammar",27),
				new EmployeePojo(101,"Rashmi","Nagaraj",30),
				new EmployeePojo(102,"Guru","Raj",30),
				new EmployeePojo(103,"Vibhash","Ranjan",25),
				new EmployeePojo(104,"Shivangi","Garg",28),
				new EmployeePojo(104,"Shagun","Manchanda",30));
		
		printEmpList(empList, p->true);

		System.out.println("-----------------------------------------------------");
		
		printEmpList(empList, p->p.getFirstName().startsWith("S"));

		System.out.println("-----------------------------------------------------");

		printEmpList(empList, p->p.getLastName().startsWith("R"));

	}

	private static void printEmpList(List<EmployeePojo> list, Predicate<EmployeePojo> p)
	{
		for(EmployeePojo emp : list) {
			if(p.test(emp)) {
				System.out.println(emp);
			}
		}
	}

    private static void printEmpList(List<EmployeePojo> list)
    {
        for(EmployeePojo emp : list) {
          if(emp.getFirstName().startsWith("s")){
              System.out.println(emp);
          }
        }
    }

}
