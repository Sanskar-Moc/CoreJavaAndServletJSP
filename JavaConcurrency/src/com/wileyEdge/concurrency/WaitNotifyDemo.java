package com.wileyEdge.concurrency;


class Account{
	public int balance=0;
	public void withdraw(int amt) {
		this.balance-=amt;
	}
	public void deposit(int amt) {
		this.balance+=amt;
	}
}

class Depositer implements Runnable{

	Account a;
	public Depositer(Account a) {
		this.a=a;
	}
	
	@Override
	public void run() {
		synchronized(a) {
			a.deposit(100);	
			a.notifyAll();
		}
		
		
	}
	
}
class Withdrawer implements Runnable{
	
	Account a;
	public Withdrawer(Account a) {
		this.a=a;
	}
	
	@Override
	public void run() {
		synchronized(a) {
			try {
				a.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			a.withdraw(100);			
		}
		if(a.balance<0) {
			System.out.println("BIG PROBLEM!!!");
		}
		else {
			System.out.println("Balance never negative");			
		}
		
	}
	
}
public class WaitNotifyDemo {

	public static void main(String[] args) {
		Account acct=new Account();
		Depositer d=new Depositer(acct);
		Withdrawer w=new Withdrawer(acct);
		Thread t1=new Thread(d);
		t1.setName("Raj");
		Thread t2=new Thread(w);
		t2.setName("Simran");
		t2.start();
		t1.start();

	}

}
