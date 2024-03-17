package com.wileyEdge.IO;
import java.io.*;

public class DeserializationDemo {

	public static void main(String[] args) {
		FileInputStream fis = null;
		BufferedInputStream bis=null;
		ObjectInputStream ois=null;
		try {
			fis = new FileInputStream("C:\\C376\\student.ser");
			bis=new BufferedInputStream(fis);
			ois=new ObjectInputStream(bis);
			Object obj=ois.readObject();
			if(obj instanceof Student) {
				Student s=(Student)obj;
				System.out.println(s);
			}
//			System.out.println(obj);
		}
		 catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	private static FileInputStream FileInputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
