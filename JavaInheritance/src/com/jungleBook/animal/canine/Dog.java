package com.jungleBook.animal.canine;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Dog extends Animal implements Pet {
	
	public Dog() {
		this("Labrador","GoldenBrown");
//		super();
		System.out.println("Inside default constructor of Dog");
	}
	public Dog(String name,String color) {
		super(name,color);
		System.out.println("Inside parameterized constructor of Dog");
//		this.name=name;
//		this.color=color;
	}
	
	@Override
	public void makeNoise() {
		System.out.println("Le "+ this.name+ " aboie");
	}
	@Override
	public void play() {
		System.out.println(this.name + " is jumping");
		
	}
	@Override
	public void beFriendly() {
		System.out.println(this.name + " is having zoomies");
		
	}
}
