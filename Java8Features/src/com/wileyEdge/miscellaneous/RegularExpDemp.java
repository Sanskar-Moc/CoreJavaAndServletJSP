package com.wileyEdge.miscellaneous;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpDemp {

	public static void main(String[] args) {
		//first way
		Pattern p=Pattern.compile("..i.");
		Matcher m=p.matcher("amit");
		System.out.println(m.matches());
		
		// second way
		boolean mat=Pattern.compile(".s").matcher("ms").matches();
		System.out.println(mat);
		
		// fourth way
		System.out.println("hello".matches("[h,e,o]+"));
		
		//third way
		boolean b=Pattern.matches("^y[a-zA-z]","yellow" );
		System.out.println(b);
		System.out.println(Pattern.matches("[amt]", "t"));
		System.out.println(Pattern.matches("\\d+", "123"));
		System.out.println(Pattern.matches("[a-zA-Z0-9]{7}", "amit41"));
		
		String s="sansak";
		if(!s.matches("\\d+") && !s.matches("\\[A-Za-z ]+") && s.length()>6)
			System.out.println("yosup");
	}

}
