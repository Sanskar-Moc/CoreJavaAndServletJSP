package com.emp;

import com.emp.utility.Address;

public class TestEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("string it is");
		Address a1=new Address("Israel","Bethlehem",18000);
		Employee e1=new Employee(10,"Jesus","Christ",a1);
//		e1.setId(10);
//		e1.setFname("Jesus");
//		e1.setLname("Christ");
		Address a2=new Address("Israel","Palestine",18000);
		Employee e2=new Employee(20,"Saint","John",a2);
//		e2.setId(20);
//		e2.setFname("Saint");
//		e2.setLname("John");

		
//		a1.setCountry("Israel");
//		a1.setCity("Bethlehem");
//		a1.setZip(18000);
//		a2.setCountry("Israel");
//		a2.setCity("Palestine");
//		a2.setZip(18000);
//		e1.setAddress(a1);
		e2.setAddress(a2);
//		System.out.println(e1.getId()+" "+e1.getFname()+" "+e1.getLname());
//		System.out.println(e2.getId()+" "+e2.getFname()+" "+e2.getLname());
//		System.out.println(e1.getFname()+" "+e1.getAddress().getCity());
//		System.out.println(e2.getFname()+" "+e2.getAddress().getCity());
		System.out.println(e1.toString());
		System.out.println(e2);
	}

}
