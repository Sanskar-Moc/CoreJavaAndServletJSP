package com.wileyEdge.inference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MethodInferenceDemo {

	public static void main(String[] args) {
//		four supported types of Method References
//		constructor reference with the syntax
//		syntax Class::new and using generics Class<T>:
//		static method reference with syntax
//		syntax Class::static_method
//		instance method of an arbitrary object of specific type
//		syntax Class::method
//		Instance method of particular object of specific type with
//		syntax instance::method
		
//		without lambda
		Car c1=Car.create(new Supplier<Car>() {
			@Override
			public Car get() {
				return new Car();
			}
		});
//		with lambda
		Car c2=Car.create(()->new Car());
		
//		with method inference
		Car c3=Car.create(Car::new);
//		MySupplier<Car> mysup = Car :: new;
		Car c4=Car.create1(Car::new, "Bugati");
		Car c5=Car.create1(Car::new, "BMW");
		Car c6=Car.create1(Car::new, "Audi");
		
		List<Car>cars=new ArrayList<>();
		cars.add(c4);
		cars.add(c5);
		cars.add(c6);
		
//		without lambda
		cars.forEach(new Consumer<Car>() {
			@Override
			public void accept(Car t) {
				Car.doServicing(t);
			}
		});
		
//		with lambda
		cars.forEach((t)->Car.doServicing(t));
//		with method inference
		cars.forEach(Car::doServicing);
		
		//3 arbitaray method of Car
		//with instance method inference
		cars.forEach(Car::drive);
		
		//4. instance method of particular object
		final Car police = Car.create( Car::new );
		cars.forEach(police::follow);
		
	}

}
