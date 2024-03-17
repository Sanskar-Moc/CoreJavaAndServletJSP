package com.jungleBook.animal;

public abstract class Animal {//cannot be instantiated
	protected String name;
	public String color;
	
	public Animal() {
		System.out.println("Inside default constructor of Animal");
	}
	public Animal(String name,String color) {
		System.out.println("Inside parameterized constructor of Animal");
		this.name=name;
		this.color=color;
	}
	
	public abstract void makeNoise();//this method should compulsorily be overridden in child class
	//{
//		System.out.println("L'animal fait du bruit");
//	}
	public void sleep() {
		System.out.println("Le "+ this.name + " dort");
	}
}
