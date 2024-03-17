package com.wileyEdge.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class Student implements Comparable<Student>{
	private int rollNo;
	private String name;
	public Student() {}
	public Student(int rollNo,String name) {
		this.rollNo=rollNo;
		this.name=name;
	}
	
	
	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		System.out.println("inside hashcode ");
		return this.rollNo;
//		return Objects.hash(this.rollNo,this.name);
	}

	@Override
	public boolean equals(Object obj) {
		
		System.out.println("inside equals ");
		if(obj instanceof Student) {
			Student s=(Student)obj;
			if(this.rollNo==s.rollNo && this.name.equals(s.name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + "]";
	}

	
	public int compareTo(Student s) {
		System.out.println("inside compare to");
		if(this.rollNo<s.rollNo) {
			return 1;
		}
		else if(this.rollNo==s.rollNo) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
}

class ScienceStudent extends Student{

	public ScienceStudent() {}
	
}

class EngineeringStudent extends ScienceStudent{
	public EngineeringStudent() {}
}

class StudentNameComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		int ret= s1.getName().compareTo(s2.getName());
		return -ret;
	}
	
}
class StudentIdComparator implements Comparator<Student>{
	
	@Override
	public int compare(Student s1, Student s2) {
		
		if(s1.getRollNo()<s2.getRollNo()) {
			return -1;
		}
		else if(s1.getRollNo()==s2.getRollNo()) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
}
public class CollectionDemo {

	public void testLists() {
		List<Object> list=new ArrayList<>();
//		List list=new LinkedList();
//		List list=new Vector();
		list.add("Sanskar");
		list.add(5);
		list.add(7);
		list.add(2.2f);
		list.add('a');
		list.add(false);
		list.add("Jesus");
		System.out.println(list);
		System.out.println("================using iterator=======");
		Iterator itr=list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("================using obj=======");
		for(Object obj:list) {
			System.out.println(obj);
		}
	}
	public void testSets() {
		Comparator<Student> com=new StudentNameComparator();
//								new StudentIdComparator();
		Set<? super Student> set=new TreeSet<>(com);// any class who is subclass of Student class can be implemented here
		set.add(new ScienceStudent());
		set.add(new EngineeringStudent());
//		set.add("sup");
//		set.add(1);
//		set.add(2.0f);
//		set.add('c');
//		set.add(51);
//		set.add(2);
//		set.add(1);
		Student s1=new Student(10,"Adam");
		Student s2=new Student(5,"Robin");
		Student s3=new Student(15,"Gary");
		Student s4=new Student(25,"Harry");
		
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		
		System.out.println(set);
		System.out.println("================using iterator=======");
		Iterator itr=set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}

	}
	
	public void testMaps() {
//		Map<Integer,String> map=new HashMap<>();
//		Map<Integer,String> map=new Hashtable<>();
		
		Student s1=new Student(10,"Adam");
		Student s2=new Student(5,"Robin");
		Student s3=new Student(15,"Gary");
		Student s4=new Student(10,"Adam");
		
		Map<Student,Integer> map=new TreeMap<>(new StudentNameComparator());
		map.put( s4,25);
		map.put( s3,15);
		map.put( s2,5);
		map.put( s1,10);
		
//		map.put(1, "abc");
//		map.put(2, "pqr");
//		map.put(3, "xyz");
//		map.put(1, "def");
//		map.put("abc", 6);
//		map.put('x', "ads");
//		map.put(3.2f, 268);
		
		Set<Student> set=map.keySet();
		Iterator<Student> its=set.iterator();
		while(its.hasNext()) {
			Student objKey= its.next();
			int value=map.get(objKey);
			System.out.println(objKey+" "+value);
		}
	}
	public static void main(String[] args) {
		CollectionDemo demo=new CollectionDemo();
//		demo.testLists();
//		demo.testSets();
		demo.testMaps();

	}

}
