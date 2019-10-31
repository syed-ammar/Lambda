package com.sya.java8;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);

        List<EmployeePojo> empList = Arrays.asList(new EmployeePojo(100,"Syed","Ammar",27),
                new EmployeePojo(101,"Rashmi","Nagaraj",30),
                new EmployeePojo(102,"Guru","Raj",30),
                new EmployeePojo(103,"Vibhash","Ranjan",25),
                new EmployeePojo(104,"Shivangi","Garg",28),
                new EmployeePojo(105,"Shagun","Manchanda",30));

        Long count = empList.stream().filter(e -> e.getAge() > 25).collect(counting());
        System.out.println("Employee count : "+count);

        Double result = empList
                       .stream()
                       .collect(averagingDouble(EmployeePojo::getAge));

        System.out.println("Average age : "+result);

        Optional emp = empList
                       .stream()
                       .max(Comparator.comparing(EmployeePojo::getAge));

        System.out.println("Max age : "+emp.get());

        emp = empList.stream()
                      .min(Comparator.comparing(EmployeePojo::getAge));

        System.out.println("Min age : "+emp.get());

        Map<Long,EmployeePojo> empMap = empList.stream()
                                               .collect(Collectors.toMap(e -> e.getEmpId(),e -> e));

        System.out.println("Map size : "+empMap.size());

        Map<Integer,List<EmployeePojo>> grpMap =  empList.stream()
                                                         .collect(Collectors.groupingBy(EmployeePojo::getAge));

        System.out.println("Result of groupingBy : "+grpMap.size()+" Key set : "+grpMap.keySet());

        Map<Integer,Set<EmployeePojo>> grpMapWithSet =  empList.stream()
                                                       .collect(Collectors.groupingBy(EmployeePojo::getAge,toSet()));

        System.out.println("Result of groupingBy with custom collector: "+grpMapWithSet.size()+" Key set : "+grpMapWithSet.keySet());

        Map<Integer,Set<EmployeePojo>> grpMapWithCustomMap =  empList.stream()
                                                              .collect(Collectors.groupingBy(e -> e.getAge(), TreeMap::new, toSet()));

        System.out.println("Result of groupingBy with custom Map: "+grpMapWithCustomMap.size()+" Key set : "+grpMapWithCustomMap.keySet());

    }
}
