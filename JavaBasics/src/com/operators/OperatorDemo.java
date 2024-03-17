package com.operators;

public class OperatorDemo {
	public static boolean isPositive(int x) {
		System.out.println("Inside isPositive method");
		return x>0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=1;int b=2;
		int c= a++ + ++b ;
		System.out.println("a="+a+" b="+b+" c="+c);
		System.out.println("=====================");
		int x=-5;
		int y=-3;
		if(isPositive(x) && isPositive(y))
		System.out.println("Both are positive");
		else
		System.out.println("!(Both are positive)");
		
		if(isPositive(x) || isPositive(y))
			System.out.println("Atleast one is Negative");
		else
			System.out.println("Both are Negative");

	}

}
