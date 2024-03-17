package com.wileyEdge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

@FunctionalInterface
interface Greetable{
	String greet(String name);
}

interface Addable{
	int add(int a,int b);
}

class AddableImpl implements Addable{

	@Override
	public int add(int a, int b) {
		
		return a+b;
	}
	
}

class GreetableImpl implements Greetable{

	@Override
	public String greet(String name) {
		System.out.println("Inside child class's greet method");
		return "welcome " +name;
	}
	
}

class Student implements Comparable<Student>{
	private String name;
	private int rollNo;
	public Student(String name, int rollNo) {
		this.name = name;
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
	@Override
	public int compareTo(Student s) {
		// TODO Auto-generated method stub
		return this.getRollNo()-s.getRollNo();
	}
	
}

public class LambdaDemo {

	public void useLambdaInForLoop() {
		List<String>list=new ArrayList<>();
		list.add("Jesus");
		list.add("John");
		list.add("Joseph");
		list.add("Judah");
		
		Consumer<String>c1=new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);				
			}
		};
		list.forEach(c1);
		System.out.println("----------------------------");
		list.forEach((t)->System.out.println("welcome "+t));
		//External Iteration   
		// The responsibility of iterating over the elements and making sure that  //all elements are iterated lies on Programmer.
		//In enhanced for loop also, managing the iterations still remains the programmer’s job
		Map<Integer,String>map=new HashMap<>();
		map.put(1, "abc");
		map.put(3, "poi");
		map.put(35, "qoi");
		
		map.forEach((a,b)->System.out.println(a+" "+b));
	
	}
	public void useLambdaOnThreads() {
		Runnable r1=new Runnable(){
			@Override
			public void run() {
				for(int i=9999;i<11000;i++){
					System.out.println(i);
				}	
			}
		};
		Thread t1=new Thread(r1);
		Thread t2=new Thread(()->{
			for(int i=0;i<1000;i++){
				System.out.println(i);
			}
		});
		t1.start();
		t2.start();
		
	}
	
	public void useLambdaInCollections() {
		List<Student>students=new ArrayList<>();
		students.add(new Student("Rob",10));
		students.add(new Student("Gary",5));
		students.add(new Student("Adam",15));
		Comparator<Student>com=new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				
				return s1.getName().compareTo(s2.getName());
			}
		};
		Comparator<Student>com2=new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				
				return s1.getRollNo()-s2.getRollNo();
			}
		};
		Collections.sort(students,com2);
		Consumer<Student>con=new Consumer<>() {
			@Override
			public void accept(Student t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		};
		students.forEach(con);
		System.out.println("============using lambda==========");
		Collections.sort(students,(a,b)->a.getName().compareTo(b.getName()));
		students.forEach((s)->System.out.println(s));
		
		System.out.println("============reversed==============");
		Collections.sort(students,com.reversed()); // reversed() is a default method in Comparator interface
		students.forEach((s)->System.out.println(s));
		
		System.out.println("============static reversedOrder()==============");
		com2=(Comparator<Student>) Comparator.reverseOrder();
		Collections.sort(students,com2);
		students.forEach((s)->System.out.println(s));
		
		Stream<Student>filteredData=students.stream().filter((s)->s.getRollNo()>5);
		System.out.println("students having rollno>5 "+filteredData.count());
		
		
	}
	
	public void doBehaviousPassing() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int result1=sumAll(numbers,(n)->true);
		System.out.println("sum of all "+result1);
		int result2=sumAll(numbers,(n)->n%2==0);
		System.out.println("sum of all even "+result2);
		int result3=sumAll(numbers,(n)->n%2==1);
		System.out.println("sum of all odd "+result3);
		int result4=sumAll(numbers,(n)->n>3);
		System.out.println("sum of greater than 3 "+result4);
	}
	private int sumAll(List<Integer>numbers) {
		int total=0;
		for(int x:numbers) {
			total+=x;
		}
		return total;
	}
	private int sumAllEven(List<Integer>numbers) {
		int total=0;
		for(int x:numbers) {
			total+=(x%2==0?x:0);
		}
		return total;
	}
	private int sumAll(List<Integer>numbers,Predicate<Integer> p) {
		int total=0;
		for(int x:numbers) {
			if(p.test(x)) {
				total+=x;
			}
		}
		return total;
	}
	
	public void doBinaryOperations() {
		List<Integer> numbers = Arrays.asList(20, 10);
		BinaryOperator<Integer> binop1=new BinaryOperator<>() {
			@Override
			public Integer apply(Integer t, Integer u) {
				// TODO Auto-generated method stub
				return t+u;
			}
		};
		BinaryOperator<Integer>binop2=(t,u)->t+u;
		int result1 = performBinaryOp(numbers,(i,j)->i+j);
		int result2 = performBinaryOp(numbers,(i,j)->i-j);
		System.out.println(result1);
		System.out.println(result2);
		
	}
	private int performBinaryOp(List<Integer> numbers,BinaryOperator<Integer> bin) {
		return bin.apply( numbers.get(0), numbers.get(1) );
	}
	public static void main(String[] args) {// functional interface have exactly one abstract method
		Greetable g=new GreetableImpl();
		System.out.println(g.greet("yellow"));
		Greetable g2=new Greetable() {

			@Override
			public String greet(String name) {
				System.out.println("inside anonymous inner class");
				return "hello"+name;
			}
			
		};
		System.out.println(g2.greet("jesus"));
		
		
		Greetable g3=(a)->"Welcome lam "+a;
		
		System.out.println(g3.greet("john"));
		System.out.println("===================================");
		
		Addable ad1=new AddableImpl();
		System.out.println(ad1.add(5,6));
		
		Addable ad2=new Addable() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		System.out.println(ad2.add(15,6));
		
		Addable ad3=(a,b)->a+b;
		System.out.println(ad3.add(15,16));
		System.out.println("===================================");
		LambdaDemo ld=new LambdaDemo();
//		ld.useLambdaInForLoop();
//		ld.useLambdaOnThreads();
//		ld.useLambdaInCollections();
//		ld.doBehaviousPassing();
		ld.doBinaryOperations();

	}

}
