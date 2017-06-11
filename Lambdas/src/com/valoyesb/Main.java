package com.valoyesb;

public class Main {

	public static void main(String[] args) {
		
		// 3. and we can use Lambdas
		new Thread(() -> {
			
			System.out.println("Printing from Runnable in a LAMBDA");
			System.out.println("Line 2");
			System.out.println("Line Drei");
			
		}).start();

	}

}

class CodeToRun implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Printing from Runnable");
		
	}
	
	
	
}