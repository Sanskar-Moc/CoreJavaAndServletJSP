package com.wileyEdge.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Address implements Serializable{
	private String country;
	private String city;
	public Address() {
		System.out.println("Hey mate, I am getting called, I am Address's Default contructor");
		
	}
	public Address(String country, String city) {
		System.out.println("Hey mate, I am getting called, I am Address's Parametrized contructor");
		this.country = country;
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [country=" + country + "\n city=" + city + "]";
	}
	
	
}

class Student implements Serializable {// tag interface or marker interface
	private int rollNo;
	private String name;
	private transient Address addr;
	
	public Address getAddr() {
		return addr;
	}
	public void setAddr(Address addr) {
		this.addr = addr;
	}
	public Student() {
		System.out.println("Hey mate, I am getting called, I am Student's Default contructor");
	}
	public Student(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + "\n name=" + name + "\n addr=" + addr + "]";
	}
	
	
	
	
}

public class SerializationDemo {

	public static void main(String[] args) {
		Student s1=new Student(44,"Sanskar");
		Address a1=new Address("India","Varanasi");
		s1.setAddr(a1);
		File file=new File("C:\\C376\\student.ser");
		FileOutputStream fos = null;
		BufferedOutputStream bos=null;
		ObjectOutputStream oos=null;
		try {
			fos = new FileOutputStream(file);
			bos=new BufferedOutputStream(fos);
			oos=new ObjectOutputStream(bos);
			oos.writeObject(s1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done");

	}

}
