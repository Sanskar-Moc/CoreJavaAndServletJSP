package com.wileyEdge.concurrency;

class JointAccount{
	public int balance=100;
	public void withdraw(int amt) {
		this.balance-=amt;
	}
}

class Job implements Runnable{
	private JointAccount ja;
	
	public Job(JointAccount ja) {
		this.ja=ja;
	}
	
	public void startWithdrawProcess(int amt) {
		String name=Thread.currentThread().getName();
		System.out.println(name+" has entered inside startWithdrawProcess()");
		System.out.println(name+" is checking the balance");
		synchronized(ja) {
			if (amt<ja.balance) {
				System.out.println(name+" has checked the balance, its sufficient");
				System.out.println(name+" actually withdrawing...");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ja.withdraw(amt);
				System.out.println(name+" has withdrawn");
			}
			else {
				System.out.println("insufficient balance");
				
			}
		}
		
		
	}
	
	@Override
	public void run() {
		startWithdrawProcess(75);
		if(ja.balance<0) {
			System.out.println("BIG PROBLEM!!!!");
		}
		
	}
	
}

public class HusbandWifeDemo {

	public static void main(String[] args) {
		JointAccount acct=new JointAccount();
		Job job=new Job(acct);
		Thread t1=new Thread(job);
		Thread t2=new Thread(job);
		t1.setName("Raj");
		t2.setName("Priya");
		
		t2.start();
		t1.start();

	}

}
