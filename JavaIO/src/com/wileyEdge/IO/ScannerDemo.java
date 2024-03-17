package com.wileyEdge.IO;

import java.util.Scanner;

public class ScannerDemo {
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter name :");
			String input=sc.nextLine();
			if(input.isEmpty()){
				break;
			}
			else {
				System.out.println("Welcome "+input);
			}
		}
		sc.close();
		System.out.println("goodbye ");
	}
}
