package com.wuzp.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SamServerSocket {

	public static final int SERVERPORT = 5000;

	public static void main(String[] args) {
		ServerSocket serviceSocket = null;
		String line;
		BufferedReader is = null;
		DataOutputStream os = null;

		// Server
		Socket clientSocket = null;
		try {
			serviceSocket = new ServerSocket(SERVERPORT);
			System.out.println("Server started........");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		// Client
		try {
			clientSocket = serviceSocket.accept();
			is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			os = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("Accept Client......");
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// received
		try {
			line = is.readLine();
			System.out.println("We are received......" + line);
			
			if(line.compareTo("Greetings") == 0){
				os.writeBytes("...and salutations...");
			}else{
				System.out.println("Sorry you can't speak my protocol...");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		// Close All
		try {
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
