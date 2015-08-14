package com.wuzp.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SmtpClient {
	public static final int SMPTPORT = 25;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Socket smptSocket = null;
		DataOutputStream os = null;
		BufferedReader is = null;

		// 
		try {
			smptSocket = new Socket(InetAddress.getLocalHost(), SMPTPORT);
			os = new DataOutputStream(smptSocket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(smptSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.out.println("unknow the host......");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error for io......");
			e.printStackTrace();
		}
		
		// 
		if (smptSocket != null && os != null && is !=null){
			try {
				os.writeBytes("HELLO,Greetings\n");
//				os.writeBytes("MAIL From: wuzp@hyron-js.com Greetings\n");
//				os.writeBytes("RCPT To: wuzp@hyron-js.com Greetings\n");
//				os.writeBytes("DATA \n");
//				os.writeBytes("From: wuzp@hyron-js.com Greetings\n");
//				os.writeBytes("Subject: Smpt Test Greetings\n");
//				os.writeBytes("Body Greetings\n");
//				os.writeBytes(" \n.\n");
//				os.writeBytes("QUIT");
				
				String responseLine;
				while((responseLine = is.readLine()) != null){
					System.out.println("Server:" + responseLine);
					if (responseLine.indexOf("OK") != -1){
						break;
					}
				}
				
				// Close All
				os.close();
				is.close();
				smptSocket.close();
			} catch (IOException e) {
				System.out.println("os error......");
				e.printStackTrace();
			}
		}
	}

}
