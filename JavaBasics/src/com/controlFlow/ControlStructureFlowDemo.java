package com.controlFlow;

public class ControlStructureFlowDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=2;
		System.out.println("==========if-else-if==========");
		if(a==1) 
			System.out.println("Bonjour");
		else if(a==2)
			System.out.println("Bonne apres midi");
		else
			System.out.println("Bonsoir");
		
		System.out.println("==============switch-case===========");
		
		switch(a) {
			case 1:{
				System.out.println("Bonjour");
				break;
			}
			case 2:{
				System.out.println("Bonne apres midi");
				break;
			}
			case 3:{
				System.out.println("Bonsoir");
				break;
			}
			default:{
				System.out.println("Bonne nuit");
				break;
			}
		}
		
		System.out.println("==============loops==============");
		System.out.println("============while================");
		int i=1;
		while(i<5) {
			System.out.println(i);
			i++;
		}
		
		System.out.println("=============do-while============");
		i=1;
		do {
			System.out.println(i);
			i++;
		}while(i<5);
		
		System.out.println("=============for=================");
		
		for(int k=0;k<5;k++){
			if(k==2) break;
			System.out.println(k);
		}
		
		System.out.println("=============nested-loop==========");
		for(i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(j==2) break;
				System.out.println(i+" "+j);
			}
			
		}
		
		System.out.println("====================================");
		int arr[]= new int[4];
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
		arr[3]=40;
		int arr2[]= {10,20,30,40};
		for(i=0;i<4;i++) 
			System.out.println(arr[i]);
		
		
		System.out.println("=============enhanced-for-loop==========");
		for(int x:arr)
			System.out.println(x);
		
		
	}

}
