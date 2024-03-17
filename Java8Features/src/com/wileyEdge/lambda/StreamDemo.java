package com.wileyEdge.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

enum Status{
	OPEN,
	CLOSED
}
class Employee{
	private String name;
	private int age;
	private double salary;
	
	public Employee(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
class Students{
	private String name;
	private Set<String> certifications;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getCertifications() {
		return certifications;
	}
	public void setCertifications(Set<String> certifications) {
		this.certifications = certifications;
	}
	public void addCertification(String certi) {
        if (this.certifications == null) {
          this.certifications = new HashSet<>();
        }
        this.certifications.add(certi);
    }
	@Override
	public String toString() {
		return "Students [name=" + name + ", certifications=" + certifications + "]";
	}
}
class Person{
	private String name;
	private String gender;
	private int age;
	public Person(String name, String gender, int age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getAge() {
		return age;
	}
	
}

class Task{
	private int points;
	private Status status;
	public Task(int points, Status status) {
		this.points = points;
		this.status = status;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	
}

public class StreamDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Task>tasks=new ArrayList<>();
		tasks.add(new Task(2,Status.OPEN));
		tasks.add(new Task(5,Status.OPEN));
		tasks.add(new Task(10,Status.CLOSED));
//		Firstly, the tasks collection is converted to its stream representation. Then, the filter operation on stream filters out all CLOSED tasks. 
//		* On next step, the mapToInt operation converts the stream of Tasks to the stream of Integers using Task::getPoints method of the each task instance. 
//		* And lastly, all points are summed up using sum method, producing the final result.

		int sum=tasks.stream().filter((a)->a.getStatus()==Status.OPEN)
		.mapToInt((task)->task.getPoints()).sum();
		
		System.out.println(sum);
		
		
		Set<Integer> set = new HashSet<>(); 
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(7);
		System.out.println("========with Lambda=========");
		list.forEach((t)->System.out.println(t));
		System.out.println("========with method inference=========");
		// forEach with Method Inference
		list.forEach(System.out :: println);
		System.out.println("=========with stream+method inference========");
		//forEach on stream
		list.stream().forEach(System.out::println);
		// forEach on Stream.parallel()
		System.out.println("=======with stream+parallel()==========");
		list.stream().parallel().forEach(System.out :: println);
//		parallel() : the stream is split into multiple chunks, with each chunk processed independently 
//		and with the result summarized at the end.
		System.out.println("=======with stream+parallel()+order maintained==========");
		list.stream().parallel().forEachOrdered(System.out::println);
		
		
		Set<Object> set1 = new HashSet<>(); 
		set1.add(5); 
		set1.add("amit");
		set1.add("3");
		System.out.println("=======with mapToInt==========");
		
		set1.stream().mapToInt(new ToIntFunction<Object>() {
			@Override
			public int applyAsInt(Object value) {
				if(value instanceof String) {
					try {
						return Integer.parseInt((String) value);						
					}
					catch(NumberFormatException e) {
						return 0;
					}
				}
				else if(value instanceof Integer) {
					return (int) value;
				}
				else {
					return 0;
				}
			}
		}).forEach(System.out::println);
		
		System.out.println("=======with mapToInt using lambda==========");
		set1.stream().mapToInt((value)->{
			if(value instanceof String) {
				try {
					return Integer.parseInt((String) value);						
				}
				catch(NumberFormatException e) {
					return 0;
				}
			}
			else if(value instanceof Integer) {
				return (int) value;
			}
			else {
				return 0;
			}
		}).forEach(System.out::println);
		System.out.println("=======calculate squares==========");
		list.stream().mapToInt((n)->n*n).forEach(System.out::println);
		OptionalDouble od=list.stream().mapToInt((n)->2*n).average();
		System.out.println("average of all number is "+(od.isPresent()?od.getAsDouble():0.0));
		OptionalInt oi1=list.stream().mapToInt((n)->2*n).findAny();
		System.out.println("any integer "+(oi1.isPresent()?oi1.getAsInt():0));
		OptionalInt oi2=list.stream().mapToInt((n)->2*n).findFirst();
		System.out.println("any integer "+(oi2.isPresent()?oi2.getAsInt():0));
		//max and sum
		OptionalInt oi3=list.stream().mapToInt((n)->2*n).max();
		System.out.println("max "+(oi3.isPresent()?oi3.getAsInt():0));
		System.out.println("sum "+(list.stream().mapToInt((n)->2*n).sum()));
		System.out.println("isAnyMatch "+(list.stream().mapToInt((n)->2*n).anyMatch(new IntPredicate() {
			@Override
			public boolean test(int value) {
				if(value==10) {
					return true;
				}
				return false;
			}
		})));
		System.out.println("isAnyMatch "+(list.stream().mapToInt((n)->2*n).anyMatch((n)->n==14)));
		
		boolean isAllMatch=list.stream().mapToInt((s) -> (int)s*2).allMatch((n)-> n>5 );
		System.out.println("is all match "+isAllMatch);
		
		//The Collectors class has a few imp methods like averagingInt and groupingBy
		List<Integer>intList=new ArrayList<>(Arrays.asList(5,9,7,2));
		Double db=intList.stream().map(new Function<Integer,Integer>() {
			
			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t*2;
			}}).collect(Collectors.averagingInt((x)->x*2));
		
		Double db2 = intList.stream().map((x)->x*2).collect(Collectors.averagingInt((x)->x*2));
		System.out.println(db);
		System.out.println(db2);
		
		
		List<Person> persons = Arrays.asList(new Person("Amit","Male",38),
				new Person("Prachi","Female",34),
				new Person("Banesh","Male",22));
		OptionalDouble avgAge=persons.stream().filter((p)->p.getGender().equals("Male")).mapToInt((a)->a.getAge()).average();
		
		System.out.println("avg age "+avgAge.getAsDouble());
		System.out.println("--------------");
		Map<String,List<Person>> namesPerGender =persons.stream().collect(Collectors.groupingBy((t)->t.getGender()));
//		Map<String,List<Person>> namesPerGender =persons.stream().collect(Collectors.groupingBy(new Function<Person,String>(){
//			@Override
//			public String apply(Person t) {
//				return t.getGender();
//			}
//		}));
		
//		System.out.println(namesPerGender);
		
//		System.out.println(persons.removeIf((Person p)-> p.getName().equalsIgnoreCase("Amit") ));
		namesPerGender.computeIfPresent("Male", (gender, personlist) -> {
     	   personlist.removeIf((Person p) ->  { return (p.getName().equalsIgnoreCase("Banesh"));});
   		   return personlist;	   
           });
		namesPerGender.forEach((gender, personList)-> System.out.println(gender+"-->"+personList));
		
		//flatmap works in case of nested fors - { {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}
		Students s1 = new Students();
        s1.setName("Amit"); 
        s1.addCertification("SCJP");
        s1.addCertification("SCWCD");
        s1.addCertification("OCJP");
        
        Students s2 = new Students();
        s2.setName("Sujay"); 
        s2.addCertification("BCD");
        s2.addCertification("Oracle");
//        System.out.println(s1);
        List<Students>students=new ArrayList<>();
        students.add(s1);
        students.add(s2);
        
        students.stream()
        .map((x)->x.getCertifications())
        .flatMap((x)->x.stream()).distinct()
        .collect(Collectors.toList())
        .forEach(System.out::println);
        
        
        List<Employee> employees = Arrays.asList(
        	    new Employee("John", 35, 60000.0),
        	    new Employee("Mary", 39, 70000.0),
        	    new Employee("Jane", 42, 45000.0),
        	    new Employee("Bill", 28, 55000.0),
        	    new Employee("Tom", 31, 52000.0)
        	);
//        We want to filter the list based on the following criteria:
//        	Only include employees with a salary greater than 50000.
//        	Only include employees who are under 40 years old.
//        	Sort the resulting list by name in ascending order.
//        	sorted(  )
        employees.stream().filter((a)->(a.getSalary()>50000.0 && a.getAge()<40)).sorted((a,b)->a.getName().compareTo(b.getName())).forEach(System.out::println);		
        int x[]= {1,2,3};
        System.out.println(Arrays.stream(x).sum());
	
	}

}
