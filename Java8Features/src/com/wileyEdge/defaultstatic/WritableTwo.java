package com.wileyEdge.defaultstatic;

public interface WritableTwo {
	default void writeOne() {
		System.out.println("default writeOne() in WritableTwo interface");
	}
	default void writeTwo() {
		System.out.println("default writeTwo() in WritableTwo interface");
	}
	default void writeThree() {
		System.out.println("default writeThree() in WritableTwo interface");
	}
	static void pqr() {
		System.out.println("static pqr() in WritableTwo interface");		
	}
}
