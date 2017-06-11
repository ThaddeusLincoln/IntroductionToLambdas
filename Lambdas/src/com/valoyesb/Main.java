package com.valoyesb;

public class Main {

	public static void main(String[] args) {
		
		// 1. una manera de hacerlo
		new Thread(new CodeToRun()).start();
		
		// 2. tambien puedo utilizar una Anonymous class
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Printing from Runnable from anonymous class");
			}
		}).start();
		
		// 3. and we can use Lambdas
		new Thread(() -> System.out.println("Printing from Runnable in a LAMBDA")).start();

	}

}

class CodeToRun implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Printing from Runnable");
		
	}
	
	
	
}