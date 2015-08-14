package com.wuzp.thread.arrayio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;

public class ArrayIO {

	public ArrayIO() {
	}

	public void writeArray(DataOutputStream os, int arr[]){
		for (int i = 0; i < arr.length; i++) {
			try {
				os.write(arr[i]);
			} catch (IOException e) {
				System.out.println("writeArray error......" + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	public int[] readArray(BufferedReader is, int length) {
		int[] temp = new int[length];
		for (int i = 0; i < length; i++) {
			try {
				temp[i] = (int)is.read();
			} catch (IOException e) {
				System.out.println("readArray error......" + e.getMessage());
				e.printStackTrace();
			}
		}
		return temp;
	}
}
