package com.jungleBook.animal.faline;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;

public class Cat extends Animal implements Pet {
	public Cat(String name,String color) {
		super(name,color);
		System.out.println("Inside cats parameterized constructor");
	}
	@Override
	public void makeNoise() {
		System.out.println("Le "+this.name+" meower");
	}
	@Override
	public void play() {
		System.out.println(this.name+" is sitting on your lap");
		
	}
	@Override
	public void beFriendly() {
		System.out.println(this.name+" is showing domination");
		
	}
}
