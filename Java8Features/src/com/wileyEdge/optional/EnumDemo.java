package com.wileyEdge.optional;

enum Gender{
	MALE,
	FEMALE
}

enum MathOperator{
	PLUS,
	MINUS,
	MULTIPLY,
	DIVIDE
}

enum Days{
	MONDAY(100),
	TUESDAY(101),
	WEDNESDAY(102),
	THURSDAY(103),
	FRIDAY(104),
	SATURDAY(105),
	SUNDAY(106);
	
	int n;
	Days(int x){
		n=x;
	}
	public int getValue() {
		return n;
	}
}

public class EnumDemo {

	public static int calculate(MathOperator m,int a,int b) {
		switch(m) {
			case PLUS:
				return a+b;
			case MINUS:
				return a-b;
			case MULTIPLY:
				return a*b;
			case DIVIDE:
				return a/b;
			default:
				throw new UnsupportedOperationException();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Gender.MALE);
		System.out.println(calculate(MathOperator.PLUS,12,6));
		System.out.println(calculate(MathOperator.MINUS,12,6));
		System.out.println(calculate(MathOperator.MULTIPLY,12,6));
		System.out.println(calculate(MathOperator.DIVIDE,12,6));
		System.out.println("=========================");
		Days aday = Days.FRIDAY;
		
		switch(aday) {
			case MONDAY:
				System.out.println("Well well well, if it isnt Monday");
				break;
			case FRIDAY:
				System.out.println("Aw man, its Friday");
				break;
			case SUNDAY:
				System.out.println("Sunday, and than, here we go again");
				break;
//			default:
//				throw new UnsupportedOperationException();
		}
		
		Days d=Days.MONDAY;
		switch(d.getValue()) {
		case 100:
			System.out.println("Well well well, if it isnt Monday");
			break;
		case 104:
			System.out.println("Aw man, its Friday");
			break;
		case 106:
			System.out.println("Sunday, and than, here we go again");
			break;
		}
		//we use enums for defining sets of predefined related constants
	
	}

}
