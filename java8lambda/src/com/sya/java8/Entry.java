package com.sya.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Entry {

	public static void main(String[] args) {
		/*Employee emp = new HumanResource();
		delegate(emp);
		Employee emp2 = new Employee() {
			@Override
			public void doWork() {

			}
		};
		Employee eng = ()-> System.out.println("I am a developer");
		AddNumbers num = (int a) -> a*2;
		System.out.println(num.doubleNumber(2));
		delegate(eng);*/

		Thread th = new Thread(new MyThread());
		th.start();

		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("I am custom thread");
			}
		});

	}

	private static void delegate(Employee e) {
		e.doWork();
	}
	
}
