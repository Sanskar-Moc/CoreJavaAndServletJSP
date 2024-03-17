package com.wileyEdge.defaultstatic;

@FunctionalInterface
public interface WritableOne {
	void abc();
	default void writeOne() {
		System.out.println("default writeOne() in WritableOne interface");
	}
	default void writeTwo() {
		System.out.println("default writeTwo() in WritableOne interface");
	}
	static void pqr() {
		System.out.println("static pqr() in WritableOne interface");		
	}
}
