package com.exp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionDemo {

	public void method1(int a) throws FileNotFoundException{
		method2();
		System.out.println("Inside method 1");
		try {
			System.out.println("Going to Divide");
			int r=10/a;
			System.out.println("Divided");
		}
		catch(ArithmeticException | NullPointerException e) {
			System.out.println("Please dont divide by 0");
			
		}
		catch(Exception e) {
			
		}
		finally{
			System.out.println("It always gets executed");
			
		}
		System.out.println("Exiting method 1");
	}
	public void method2() throws FileNotFoundException {
		System.out.println("Inside method 2");
//		try {
			FileInputStream fis=new FileInputStream("C:\\C376\\abc.txt");			
//		}
//		catch(FileNotFoundException e) {
//			System.out.println("File not found");
//			e.printStackTrace();
//		}
		
		System.out.println("Exiting method 2");
		
	}
	public void method3() {
		System.out.println("Inside method 3");
		BankAccount acct=new BankAccount();
		try {
			acct.withdraw(125);			
		}
		catch(InsufficientFundsException e) {
			e.printStackTrace();
			System.out.println("Try to give lesser amount");
		}
		System.out.println("Exiting method 3");
		
	}
	public static void main(String[] args) {
		System.out.println("Inside main");
		ExceptionDemo demo=new ExceptionDemo();
		try {
			demo.method1(0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		demo.method3( );
		
		
		System.out.println("Exiting main");

	}

}
