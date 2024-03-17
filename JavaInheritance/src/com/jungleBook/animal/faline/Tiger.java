package com.jungleBook.animal.faline;

import com.jungleBook.animal.Animal;

public class Tiger extends Animal {

	public Tiger(String name,String color) {
		super(name,color);
		System.out.println("Inside the Tiger parameterized constructor");
	}
	
	@Override
	public void makeNoise() {
		System.out.println(this.name+ " is roaring");

	}

}
