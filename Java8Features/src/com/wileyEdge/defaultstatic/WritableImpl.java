package com.wileyEdge.defaultstatic;

public class WritableImpl implements WritableOne, WritableTwo {
	@Override
	public void abc() {
		System.out.println("This is overridden abc() in WritableImpl");
	}

	@Override
	public void writeOne() {
		// TODO Auto-generated method stub
		WritableOne.super.writeTwo();
	}

	@Override
	public void writeTwo() {
		System.out.println("Inside Overridden writeTwo() of WritableImpl");
	}

}
