package com.wileyEdge.miscellaneous;

class Employee{

	@Override
	protected void finalize() throws Throwable {
		System.out.println("I am getting removed from heap, CLEANUP!");
	}
	public void doCoding() {
		System.out.println("Employee is coding");
		
	}
	
}

public class GCDemo {
	public void doWork() {
		Employee e1= new Employee();
		e1.doCoding();
		e1=null;
	}
	public static void main(String[] args) {
		GCDemo gc=new GCDemo();
		gc.doWork();
		System.gc();
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
