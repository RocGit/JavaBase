package com.wuzp.thread.arrayio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ArraySocketClient {

	public static final int ARRAYPROT = 6999;
	static int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	static int[] b = { 5, 5, 5, 5, 5, 5, 5, 5, 5 };

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Socket arrayClient = null;
		BufferedReader is = null;
		DataOutputStream os = null;

		ArrayIO arrayIO = new ArrayIO();

		try {
			arrayClient = new Socket(InetAddress.getLocalHost(), ARRAYPROT);
			os = new DataOutputStream(arrayClient.getOutputStream());
			is = new BufferedReader(new InputStreamReader(
					arrayClient.getInputStream()));
		} catch (UnknownHostException e) {
			System.out.println("unknow the host......");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error for io......");
			e.printStackTrace();
		}

		arrayIO.writeArray(os, a);
		arrayIO.writeArray(os, b);
		int[] result = new int[10];
		result = arrayIO.readArray(is, result.length);
		System.out.println("------the sum of the two arrays-----\n");
		for (int i = 0; i < result.length; i++) {
			System.out.println("-->" + result[i]);
		}

		try {
			os.close();
			is.close();
			arrayClient.close();
		} catch (IOException e) {
			System.out.println("Close All error......");
			e.printStackTrace();
		}
	}

}
