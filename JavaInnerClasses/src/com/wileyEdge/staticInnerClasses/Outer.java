package com.wileyEdge.staticInnerClasses;

public class Outer {
	static class Inner{
		public void innerMethod() {
			System.out.println("Hi from inner method");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inner in=new Inner();
		in.innerMethod();
	}

}
