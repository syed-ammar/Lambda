/**
 * 
 */
package com.sya.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author sammar
 *
 */
public class ConsumerExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<EmployeePojo> empList = Arrays.asList(new EmployeePojo(100,"Syed","Ammar",27),
				new EmployeePojo(101,"Rashmi","Nagaraj",30),
				new EmployeePojo(102,"Satish","Krishnan",40),
				new EmployeePojo(103,"Vibhash","Ranjan",25),
				new EmployeePojo(104,"Shivangi","Garg",28),
				new EmployeePojo(105,"Shagun","Manchanda",29));
		
		printEmpList(empList, p->true, p->System.out.println(p.getEmpId()));
		
		System.out.println("-----------------------------------------------------");

		printEmpList(empList, p->true, p->System.out.println(p.getFirstName()));
		
		System.out.println("-----------------------------------------------------");
		
		printEmpList(empList, p->p.getFirstName().startsWith("S"), p->System.out.println(p));

		System.out.println("Result of stream-----------------------------");

		//Sorting without Stream
		List<EmployeePojo> sortedList = new ArrayList<>();
		for (EmployeePojo emp: empList )
		{
			if(emp.getFirstName().startsWith("S")) {
				sortedList.add(emp);
			}
		}
		Collections.sort(sortedList, new Comparator<EmployeePojo>() {
			@Override
			public int compare(EmployeePojo emp1, EmployeePojo emp2) {

				return emp1.getAge() > emp2.getAge() ? 1 : -1;
			}
		});

		printEmpList(sortedList, p->true, p-> System.out.println(p));

		//Sorting with Stream
		List<EmployeePojo> sortedUsingStream = empList.stream()
				                               .filter(p->p.getFirstName().startsWith("S"))
				                               .sorted(Comparator.comparing( EmployeePojo::getAge))
				                               .collect(toList());

		printEmpList(sortedUsingStream, p->true, p-> System.out.println(p));
		/*List<String> list = Arrays.asList("TOTE01","TOTE01","TOTE03","TOTE02");
		Set<String> set = list.stream().collect(Collectors.toSet());
		List<String> distinctList = list.stream().distinct().collect(Collectors.toList());
		System.out.println(list.toString());
		System.out.println(set.toString());
		System.out.println(distinctList.toString());
		list.stream().sorted(Comparator.naturalOrder()).limit(2).collect(Collectors.toList());
		System.out.println(list.stream().sorted(Comparator.naturalOrder()).limit(2).collect(Collectors.toList()));*/

	}

	private static void printEmpList(List<EmployeePojo> list, Predicate<EmployeePojo> p, Consumer<EmployeePojo> con)
	{
		for(EmployeePojo emp : list) {
			if(p.test(emp)) {
				con.accept(emp);
			}
		}
	}
}
