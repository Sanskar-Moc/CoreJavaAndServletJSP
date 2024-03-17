package com.wileyEdge.regularInnerClasses;

public class Outer {
	private int x=10;
	public class Inner{
		public void method1() {
			System.out.println("i can access private variable of outer class in inner class  "+x);
		}
	}
	public static void main(String[] args) {
		Outer demo=new Outer();
		Inner in=demo.new Inner();
		in.method1();
	}

}
