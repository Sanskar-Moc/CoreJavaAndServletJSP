package com.wileyEdge.defaultstatic;

public class DefaultAndStaticMethodDemo {

	public static void main(String[] args) {
		WritableImpl wo=new WritableImpl();
		wo.abc();
		wo.writeOne();
		wo.writeTwo();
		wo.writeThree();
		WritableOne.pqr();
		WritableTwo.pqr();

	}

}
