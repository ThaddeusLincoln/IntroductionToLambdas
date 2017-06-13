package com.valoyesb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Benito
 *
 */
public class Main {

	public static void main(String[] args) {
		
		// 3. and we can use Lambdas
		/*new Thread(() -> {
			
			System.out.println("Printing from Runnable in a LAMBDA");
			System.out.println("Line 2");
			System.out.println("Line Drei");
			System.out.format("This is line %s\n", "vier");
			
		}).start();*/
		
		// for using Comparator
		Employee john = new Employee("John Doe", 51);
		Employee jane = new Employee("Aretha Franklin", 27);
		Employee elvis = new Employee("Elvis-Calvin Doe", 12);
		Employee snow = new Employee("Snow White", 19);
		
		List<Employee> employees = new ArrayList<>();
		employees.add(john);
		employees.add(jane);
		employees.add(elvis);
		employees.add(snow);
		
		// 1. with an anonymous class
//		Collections.sort(employees, new Comparator<Employee>() {
//
//			@Override
//			public int compare(Employee employee1, Employee employee2) {
//				return employee1.getName().compareTo(employee2.getName());
//			}
//		});
//		
//		for(Employee employee : employees){
//			System.out.println(employee.getName());
//		}
		
		// let's do it with Lambda
		Collections.sort(employees, (employee1, employee2) -> employee1.getName().compareTo(employee2.getName()));
		for(Employee employee : employees){
			System.out.println(employee.getName());
		}
		
		// -------------------------- SAMPLE 2 -------------------------------------------------
		// using lambdas with an interface which only method returns a value
		/*String sillyString = doStringStuff(new UpperConcat() {
			
			@Override
			public String upperAndConcat(String s1, String s2) {
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString);*/
		
		String sillyString2 = doStringStuff((s1, s2) -> 
			s1.toUpperCase() + s2.toUpperCase(), employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString2);
		
		

	}
	
	public static String doStringStuff(UpperConcat uc, String s1, String s2){
		return uc.upperAndConcat(s1, s2);
	}

}

class Employee {
	
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}


/**
 * @author Benito
 * La usamos para el ejemplo, ya que contiene un method que devuelve un valor
 *
 */
interface UpperConcat{
	
	public String upperAndConcat(String s1, String s2);
	
}
