package com.wileyEdge.concurrency;

class Job1 extends Thread{
	@Override
	public void run() {
		
		method2();
	}
	public void  method2() {
		String name=Thread.currentThread().getName();
		System.out.println("I am here");
		for(int i=1000;i<=2000;i++) {
//			System.out.print("");
			System.out.println(name+" : "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
class Job2 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		method1();
	}
	public void method1() {
		System.out.println("no no, I am here");
		String name=Thread.currentThread().getName();
		for(int i=1;i<=1000;i++) {
			System.out.println(name+" : "+i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			method2();
		}
		
	}
	
}

public class ConcurrencyDemo {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrencyDemo cd=new ConcurrencyDemo();
		Job1 j1=new Job1();
		Thread t1=new Thread(j1);
		t1.setName("Thread 1");
		Job2 j2=new Job2();
		Thread t2=new Thread(j2);
		t2.setName("Thread 2");
		t1.start();
		t2.start();
//		cd.method2();

	}

}
