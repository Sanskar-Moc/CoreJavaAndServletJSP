package com.wileyEdge.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person{
	private String fname;
	private String lname;
	public Person() {}
	public Person(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	public String getDescription() {
		return "Information about Person";
	}
}

public class ReflectionDemo {

	public static void main(String[] args) {
		Person p=new Person();
		Class $class=p.getClass();
		Constructor[]ca= $class.getConstructors();
		System.out.println("============constructors==============");
		for(Constructor c:ca) {
			System.out.println(c);
		}
		System.out.println("============methods==============");
		Method[]ma=$class.getMethods();
		for(Method m:ma) {
			System.out.println(m.getName());
		}
		
		System.out.println("============all fields==============");
		Field[] fa=$class.getDeclaredFields();
		for(Field f:fa) {
			System.out.println(f);
		}
		
	}

}
