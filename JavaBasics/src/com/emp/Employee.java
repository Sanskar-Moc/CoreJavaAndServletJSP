package com.emp;

import com.emp.utility.Address;

public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private Address address; // address is of type Address and instance variable of Employee class
	
	public Employee() {
		System.out.println("Object of Employee is being created");
	}
	public Employee(int id,String fname,String lname) {
		this.id=id;
		this.fname=fname;
		this.lname=lname;
		System.out.println("Object of Employee is being created using parameterized constructor");
	}
	public Employee(int id,String fname,String lname,Address address) {
		this(id,fname,lname);
		this.address=address;
		System.out.println("Object of Employee is being created using parameterized constructor with 4 paras");
	}

	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@Override
	public String toString() {
		return this.id+" "+this.fname+" "+this.lname+" "+this.address;
	}
	//parent class is available with method to override
	
	//method signature matches with parent class
}
