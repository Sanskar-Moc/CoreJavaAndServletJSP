package com.wileyedge.model;

public class Student {
	private String name;
	private int age;
	private long mobNo;
	private String address;
	
	
	public Student(String name, int age, long mobNo, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobNo = mobNo;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
