package com.wuzp.thread.arrayio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;

public class ArrayServer extends Thread {

	public static final int ARRAYPROT = 6999;
	protected ServerSocket listen;

	public ArrayServer() {
		try {
			listen = new ServerSocket(ARRAYPROT);
			System.out.println("server start......");
		} catch (IOException e) {
			System.out.println("init start server errror......");
			e.printStackTrace();
		}
		this.start();
	}

	@SuppressWarnings("unused")
	@Override
	public void run() {
		try {
			while (true) {
				Socket client = listen.accept();
				ArrayConnects cc = new ArrayConnects(client);
				System.out.println("server run......");
			}
		} catch (IOException e) {
			System.out.println("server run error......");
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ArrayServer();
	}

}
