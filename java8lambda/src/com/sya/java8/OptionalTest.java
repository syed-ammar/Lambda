package com.sya.java8;

import java.util.Optional;

public class OptionalTest {
    public static void main(String args[])
    {
        EmployeePojo emp = new EmployeePojo(100,"Syed","Ammar",27);
        emp = null;
        Optional<EmployeePojo> op = Optional.ofNullable(emp);
        op.ifPresent(e -> System.out.println(e));

        Optional<String> name = op.map(e -> e.getLastName());
    }

}
