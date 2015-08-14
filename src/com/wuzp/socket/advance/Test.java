package com.wuzp.socket.advance;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6802122862325832751L;

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		FileOutputStream fos = new FileOutputStream(new File("D:\\JavaProjectHall\\test.txt"));
		FileOutputStream fos2 = new FileOutputStream("D:\\JavaProjectHall\\test.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos2);
//		oos.writeObject("helllllllllllllllllllllllllllllo");
		oos.writeObject(new Test());
		
		FileInputStream fis = new FileInputStream("D:\\JavaProjectHall\\test.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object o = ois.readObject();
		System.out.println("" + o.getClass().getName());
	}

}
