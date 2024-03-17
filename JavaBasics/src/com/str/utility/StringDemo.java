package com.str.utility;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="hello";
		String s2=new String("hello");
		if(s1==s2)
			System.out.println("both pointing to same memory location");
		else
			System.out.println("both pointing to different memory location");
		
		if(s1.equals(s2))
			System.out.println("both have same values");
		else
			System.out.println("both have different values");
		
		String s3=s1.concat(" World");
		System.out.println(s3);
		System.out.println(s3.substring(0,3));
		System.out.println(s3.indexOf("l"));
		System.out.println(s3.lastIndexOf("l"));
		System.out.println(s3.indexOf("ll"));
		System.out.println(s3.replace("l","p"));
		String strr[]=s3.split("ll");
		for(String x:strr)System.out.println(x);
		System.out.println();
		System.out.println(s3.startsWith("hell"));
		System.out.println(s3.toUpperCase());
		System.out.println(s3.toLowerCase());
		
		System.out.println("=======================");
		String inp="computer";
		System.out.println(revDash(inp));
		System.out.println("=======================");
		String inp2="abcxXXcxerxxXXwer";
		System.out.println(remX(inp2));
		String inp3="Hello World";
		System.out.println(replaceLF(inp3));
		System.out.println("=======================");
		String inp4="Hi How are you";
		String inp4_2="This is java String program ";
		System.out.println(maxLSubstring(inp4));
		System.out.println(maxLSubstring(inp4_2));
		System.out.println("=======================");
		String inp5="Softra Services Limited";
		System.out.println(minimize(inp5));
		System.out.println("=======================");
		String inp6="Softra Services Limited";
		System.out.println(minimizeSeq(inp6));
		System.out.println("=======================");
		
	}
	public static String revDash(String s) {
		int n=s.length();
		String ans="";
		for(int i=n-1;i>=1;i--)
			ans+=s.charAt(i)+"-";
		ans+=s.charAt(0);
		return ans;
	}
	public static String remX(String s) {
		String ans="";
		String Xs="";
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='x')
				Xs+="x";
			else
				ans+=s.charAt(i);
		}
		ans+=Xs;
		return ans;
	}
	public static String replaceLF(String s) {
		char f=s.charAt(0);
		char l=s.charAt(s.length()-1);
		String ans=l+s.substring(1,s.length()-1)+f;
		return ans;
	}
	public static String maxLSubstring(String s) {
		String sp[]=s.split(" ");
		int max=0;
		String ans="";
		for(String x:sp) {
			if(x.length()>max) {
				max=x.length();
				ans=x;
			}
		}
		return ans;
	}
	public static String minimize(String s) {
		String sp[]=s.split(" ");
		String ans="";
		for(String x:sp)
			ans+=x.charAt(0);
		
		return ans;
	}
	public static String minimizeSeq(String s) {
		String sp[]=s.split(" ");
		String ans="";
		int i=0;
		for(String x:sp) {
			if(i>=s.length())ans+=s.charAt(x.length()-1);
			else ans+=x.charAt(i++);
		}
			
		
		return ans.toUpperCase();
	}

}
