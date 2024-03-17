package com.wileyEdge.optional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate today=LocalDate.now();
		System.out.println(today);
		LocalDateTime date2=LocalDateTime.now();
		System.out.println(date2);
		LocalDate bday=LocalDate.of(2000, Month.JULY, 18);
		System.out.println(bday);
//		LocalDate dateOfBirth = LocalDate.of(1979, Month.July, 25);
		Period age=Period.between(bday, today);
		System.out.println("My age is "+age.getYears() +" "+"years "+age.getMonths()+" months "+ age.getDays()+ " days.");	
		System.out.println("Date After 10 days: "+today.plusDays(10));
		System.out.println("Date Before 10 days: "+today.minusDays(10));
		System.out.println("Date After 3 weeks: "+today.plusWeeks(3));
		System.out.println("Date Before 3 weeks: "+today.minusWeeks(3));
		System.out.println("Date After 20 months: "+today.plusMonths(20));
		System.out.println("Date Before 20 months: "+today.minusMonths(20));
		System.out.println("Date After 2 Years: "+today.plusYears(2));
		System.out.println("Date Before 2 Years: "+today.minusYears(2));
		ZoneId australia= ZoneId.of("Australia/Sydney");
		System.out.println(LocalDateTime.now(australia));
	

	
	
	
	}
}