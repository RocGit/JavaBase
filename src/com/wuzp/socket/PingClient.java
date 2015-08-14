package com.wuzp.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingClient {

	public static final int ECHO_PROT = 7;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		startPingClient("S2D-WUZP-PC.hyron-js.com");

	}

	public static void startPingClient(String str) {
//		if (str.length() != 1) {
//			System.out.println("Useage: java ping hostName......");
//			System.exit(0);
//		} 
		
		if (alive(str)) {
			System.out.println(str + " ...is alive");
		} else {
			System.out.println("no response from ");
		}
	}
	
	public static boolean alive(String host) {
		Socket pingSocket = null;
		//
		try {
			pingSocket = new Socket(host, ECHO_PROT);
			
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException......" + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException......" + e.getMessage());
			e.printStackTrace();
		}
		
		if (pingSocket != null) {
			try {
				pingSocket.close();
			} catch (IOException e) {
				System.out.println("close error......" + e.getMessage());
				e.printStackTrace();
			}
			return true;
		}else {
			return false;
		}
	}
}
