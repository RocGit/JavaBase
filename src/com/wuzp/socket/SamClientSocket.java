package com.wuzp.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SamClientSocket {

	public static final int CLIENTPORT = 5000;

	public static void main(String[] args) {
		Socket cl1 = null;
		BufferedReader is = null;
		DataOutputStream os = null;
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		String userInput = null;
		String outPut = null;
		
		// Client1
		try {
//			cl1 = new Socket("S2D-WUZP-PC.hyron-js.com", CLIENTPORT);
			cl1 = new Socket(InetAddress.getLocalHost(), CLIENTPORT);
			System.out.println("InetAddress.getLocalHost()--->[" + InetAddress.getLocalHost() + "]"); 
			is = new BufferedReader(new InputStreamReader(cl1.getInputStream()));
			os = new DataOutputStream(cl1.getOutputStream());
			System.out.println("Client1 is started......");
		} catch (UnknownHostException e) {
			System.out.println("Unknow host...." + e.getLocalizedMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error io...." + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		// input
		try {
			System.out.println("Please input keywords");
			userInput = stdin.readLine();
			os.writeBytes(userInput + "\n");
		} catch (IOException e) {
			System.out.println("Error io...." + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		// server reply
		try {
			outPut = is.readLine();
			System.out.println("Got from server..." + outPut);
		} catch (IOException e) {
			System.out.println("Error waiting for server ...." + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		// Close All
		try {
			os.close();
			is.close();
			cl1.close();
			System.out.println("Client All closed...");
		} catch (IOException e) {
			System.out.println("Error Close All ...." + e.getLocalizedMessage());
			e.printStackTrace();
		}
		
	}
}
