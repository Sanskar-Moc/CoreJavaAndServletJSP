package com.wileyEdge.anonymousInnerClass;

interface Pet{
	void play();
	void beFriendly();
}

abstract class Animal{
	public abstract void makeNoise();
}

class Dog extends Animal implements Pet{

	@Override
	public void makeNoise() {
		System.out.println("Dog is making noise");
	}
	@Override
	public void play() {
		System.out.println("Dog is playing");		
	}
	@Override
	public void beFriendly() {
		System.out.println("Dog is being friendly");		
	}
	
}

public class AnonymousInnerDemo {

	public static void main(String[] args) {
		Animal a=new Dog();
		Pet p=new Dog();
		Animal a2=new Animal() {
			@Override
			public void makeNoise() {
				System.out.println("Oh my god, Animal is making noise from Anonymous Inner Class");
			}			
		};
		a2.makeNoise();
		Pet p2=new Pet() {
			@Override
			public void play() {
				System.out.println("Jesus Christ, Pet is playing from anonymous inner class");
			}
			@Override
			public void beFriendly() {
				System.out.println("Jesus Christ, Pet is being friendly from anonymous inner class");
			}
		};
		p2.play();
		p2.beFriendly();
	}

}
