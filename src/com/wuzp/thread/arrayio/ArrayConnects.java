package com.wuzp.thread.arrayio;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ArrayConnects extends Thread {
	Socket client;
	BufferedReader is;
	DataOutputStream os;
	ArrayIO aio = new ArrayIO();
	ArrayMath am = new ArrayMath();

	public ArrayConnects(Socket s) {
		client = s;
		try {
			os = new DataOutputStream(client.getOutputStream());
			is = new BufferedReader(new InputStreamReader(
					client.getInputStream()));
			System.out.println("client init ........");
		} catch (IOException e) {
			System.out.println("Connects init error......");
			e.printStackTrace();
			try {
				client.close();
			} catch (IOException e1) {
				System.out.println("Connects in client close error......");
				e1.printStackTrace();
			}
			return;
		}
		this.start();
	}

	@Override
	public void run() {
		int[] a1 = new int[10];
		int[] a2 = new int[10];
		a1 = aio.readArray(is, a1.length);
		a2 = aio.readArray(is, a2.length);

		int[] rs = new int[10];
		rs = am.addArray(a1, a2, 10);
		aio.writeArray(os, rs);
		System.out.println("client run......");
	}

}
