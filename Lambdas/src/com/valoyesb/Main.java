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
		
		// -------------------------- SAMPLE 3 -------------------------------------------------
		/*String sillyString2 = doStringStuff((s1, s2) -> 
			s1.toUpperCase() + s2.toUpperCase(), employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString2);*/
		
		// -------------------------- SAMPLE 4 -------------------------------------------------
		/*UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();
		String sillyString3 = doStringStuff(uc, employees.get(0).getName(), employees.get(1).getName());
		System.out.println(sillyString3);*/
		
		// -------------------------- SAMPLE 5 -------------------------------------------------
		// The anonymous class doesn't has a name, which makes sense
		AnotherClass anotherClass = new AnotherClass();
		String s = anotherClass.doSomething();
		System.out.println(s);
		
		// -------------------------- SAMPLE 5 -------------------------------------------------
		AnotherClass anotherClass2 = new AnotherClass();
		String s1 = anotherClass2.doSomethingWithLambda();
		System.out.println(s1);
		
		// SAMPLE 6 ----------------------------------------------------------------------------
		AnotherClass.printValue();
		
		// -------------------------- SAMPLE 7 -------------------------------------------------
		for(Employee employee : employees){
			new Thread(	() -> System.out.println("The employee's age is : " + employee.getAge())).start();
		}
		
		// -------------------------- SAMPLE 8 -------------------------------------------------
		employees.forEach( e -> {
			System.out.println("The employee's name is : " + e.getName());
			System.out.println("The employee's age is : " + e.getAge());
		});
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

class AnotherClass{
	
	public String doSomething(){
		System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
		return Main.doStringStuff(new UpperConcat() {
			
			@Override
			public String upperAndConcat(String s1, String s2) {
				System.out.println("The anonymous class's name is " + getClass().getSimpleName());
				return s1.toUpperCase() + s2.toUpperCase();
			}
		}, "String1", "String2");
	}
	
	public String doSomethingWithLambda(){
		System.out.println("The AnotherClass class's name is: " + getClass().getSimpleName());
		
		return Main.doStringStuff((s1, s2) -> 
			{
				System.out.println("The AnotherClass class's when calling from the lambda is: " + getClass().getSimpleName());
				String result1 = s1.toUpperCase() + s2.toUpperCase();
				return result1;}, "String1", "String2");
	}
	
	public static void printValue(){
		
		int number = 25;
		
		Runnable r = () -> {
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("The value is: " + number);
		};
		
		new Thread(r).start();
		
	}
}

