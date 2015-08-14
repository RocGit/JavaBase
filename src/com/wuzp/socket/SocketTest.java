package com.wuzp.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {
	public static final int SMPTPOTR = 25;
	public static final int FINGERPROT = 79;
	public static final int ECHO_PROT = 7;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SocketTest.serverStart(SMPTPOTR, null);
//		SocketTest.serverStart(FINGERPROT, null);
		SocketTest.serverStart(ECHO_PROT, null);
	}

	public static void serverStart(int prot, String msg) {
		ServerSocket serviceSocket = null;
		String line;
		BufferedReader is = null;
		DataOutputStream os = null;

		Socket clientSocket = null;
		try {
			// Server
			serviceSocket = new ServerSocket(prot);
			System.out.println("Server started........");

			clientSocket = serviceSocket.accept();
			is = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));
			os = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("Accept Client......");

			// received
			line = is.readLine();
			System.out.println("We are received......" + line);

			// Close All
			os.close();
			is.close();
			clientSocket.close();
			System.out.println("Server All closed...");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
