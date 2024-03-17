package com.wileyEdge.IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class FileDemo {

	public static void main(String[] args) {
		System.out.println("Inside main");
		System.out.println("File copying starts...");
		long start=System.currentTimeMillis();
		//		Reader rd = null;
		//		Writer fr=null;
		InputStream fis=null;
		OutputStream fos=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try {
			//			rd=new FileReader("C:\\C376\\abc.txt");
			//			fr=new FileWriter("C:\\C376\\abcd.txt");
			File file=new File("C:\\C376\\img.jpg");
			System.out.println("is file? "+file.isFile());
			System.out.println("is directory? "+file.isDirectory());
			System.out.println("is writable? "+file.canWrite());
			System.out.println("is read? "+file.canRead());
			
			File file2=new File("C:\\C376\\yosup");
			System.out.println("for file 2 ");
			System.out.println("is directory? "+file2.isDirectory());
			System.out.println("is file? "+file2.isFile());
			file2.mkdir();
			file2.delete();
			
			fis=new FileInputStream(file);
			fos=new FileOutputStream("C:\\C376\\image.jpg");
			bis=new BufferedInputStream(fis);
			bos=new BufferedOutputStream(fos);
			int character;
			
			try {
				while ((character = bis.read()) != -1) {
					//System.out.print((char) character);
					bos.write(character);
				}//end of while
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}//end of try-catch
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				//				rd.close();
				//				fr.close();
				//				fis.close();
				//				fos.close();
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}//end of try-catch
		}//end of try-catch-finally
		long end=System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println("File copied successfully...");
		System.out.println("Exiting main");

	}

}
