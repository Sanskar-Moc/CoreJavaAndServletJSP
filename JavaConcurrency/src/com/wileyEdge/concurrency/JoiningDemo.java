package com.wileyEdge.concurrency;

class Education implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Education has started");
		System.out.println("Education is going on...");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Education is completed");
	}
	
}
class Marraige implements Runnable{
	
	private Thread t;
	
	public Marraige(Thread t) {
		this.t=t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Wedding Ceremony started");
		System.out.println("Marraied");
	}
	
}

public class JoiningDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Education e=new Education();
		Thread t1=new Thread(e);
		Marraige m=new Marraige(t1);
		Thread t2=new Thread(m);
		t1.start();
		t2.start();
	}

}
