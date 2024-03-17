package com.wileyEdge.methodLocalInnerClasses;

public class MethodLocalInnerDemo {
	private int x=10;
	
	public void outerMethod() {
		int y=9;
		class MyInner{
			int z=11;
			public void innerMethod() {
				System.out.println("From method local class, I can access outer's private 'x' "+x);
				System.out.println("From method local class, I can access local variable 'z' "+z);
				System.out.println("From method local class, I can access outerMethod() 'y' "+y);
			}//end of innerMethod()
		}//end of MyInner
		
		MyInner mi=new MyInner();
		mi.innerMethod();
	}//end of outerMethod()
	public static void main(String[] args) {
		MethodLocalInnerDemo demo=new MethodLocalInnerDemo();
		demo.outerMethod();
	}

}
