package com.jungleBook;

import com.jungleBook.animal.Animal;
import com.jungleBook.animal.Pet;
import com.jungleBook.animal.canine.Dog;
import com.jungleBook.animal.faline.Cat;
import com.jungleBook.animal.faline.Tiger;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Animal a=new Animal();
//		Dog a=new Dog();
//		a.name="Dog";
//		a.color="Brown";
		
//		a.makeNoise();
//		a.sleep();
//		
//		Animal c=new Cat("Parmisian","Black");
//		c.makeNoise();
//		c.sleep();
//		
//		Animal t=new Tiger("Bengal Tiger","Golden");
//		t.makeNoise();
		Animal[] ani = new Animal[5];
		ani[0]=new Dog("Labrador","Golden Brown");
		ani[1]=new Cat("Parmisian","Black");
		ani[2]=new Dog("Pug","Brown");
		ani[3]=new Cat("Siamese","Grey");
		ani[4]=new Tiger("Bengal Tiger","Golden");
		
		for(Animal x:ani) {
			x.makeNoise();
//			x.sleep();
		}
		
		Pet[]pets=new Pet[4];
		pets[0]=new Dog("Labrador","Golden Brown");
		pets[1]=new Cat("Parmisian","Black");
		pets[2]=new Dog("Pug","Brown");
		pets[3]=new Cat("Siamese","Grey");
		
		for(Pet x:pets) {
			x.play();
			x.beFriendly();
		}
		
		Pet p=new Pet(){

			@Override
			public void play() {
				// TODO Auto-generated method stub
				System.out.println("playing inside anonymous class");
			}

			@Override
			public void beFriendly() {
				// TODO Auto-generated method stub
				System.out.println("being friendly inside anonymous class");
				
			}			
		};
		p.beFriendly();
		p.play();
		
		Animal ab=new Animal() {

			@Override
			public void makeNoise() {
				// TODO Auto-generated method stub
				System.out.println("making noise inside inner anonymous class of animal");
			}
			
		};
		ab.makeNoise();
		
		
	}

}
