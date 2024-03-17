package com.param;

class Num{
	public int n;// instance variable of type int and class num
}

public class ParameterPassingDemo {

	public void modify(int n) {
		System.out.println("Inside modify() method");
		n=10;
		System.out.println("Exiting modify() method "+n);
	}
	public void modify(Num num) {
		System.out.println("Inside modify(Num) method");
		num.n=10;
		System.out.println("Exiting modify(Num) method "+num.n);
	}
	public void modify(String str) {
		System.out.println("Inside modify(String) method");
		str="10";
		System.out.println("Exiting modify(String) method "+str);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ParameterPassingDemo ppd=new ParameterPassingDemo();
		System.out.println("Inside main() method");
		int n=5;
		System.out.println("Before invoking modify method "+ n);
		ppd.modify(n);
		System.out.println("After invoking modify method "+ n);
		System.out.println("===================================");
		Num num=new Num();
		num.n=5;
		System.out.println("Before invoking modify(Num) method "+ num.n);
		ppd.modify(num);
		System.out.println("After invoking modify(Num) method "+ num.n);
		
		System.out.println("Exiting main() method");
		
		System.out.println("===================================");
		String str="5";
		System.out.println("Before invoking modify(String) method "+ str);
		ppd.modify(str);
		System.out.println("After invoking modify(String) method "+ str);
	}

}
