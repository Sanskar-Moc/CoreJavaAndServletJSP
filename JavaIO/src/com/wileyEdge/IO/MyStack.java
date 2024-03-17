package com.wileyEdge.IO;

public class MyStack<E> {
	private int x;
	private E[] data=(E[])new Object[10];
	
	public void push(E obj) {
		data[x]=obj;
		x++;
	}
	
	public E pop() {
		x--;
		return data[x];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack<String>ms1=new MyStack<>();
		ms1.push("abc");
		ms1.push("pqr");
		System.out.println(ms1.pop());
		System.out.println(ms1.pop());
		
		MyStack<Integer>ms=new MyStack<>();
		ms.push(25);
		ms.push(35);
		ms.push(53);
		System.out.println(ms.pop());
		System.out.println(ms.pop());
		
	}

}
