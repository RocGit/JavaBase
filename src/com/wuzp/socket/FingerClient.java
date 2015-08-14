package com.wuzp.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FingerClient {
	public static final int FINGERPROT = 79;
	public static String host = null;
	public static String user = null;
	
	static String vitrulStr = "wuzp@hyron-js.com";
	
	/**
	 * @param args
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException {
		
		startFingerClient(vitrulStr);
	}
	/**
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public static String getLocalHost() throws UnknownHostException {
		InetAddress host = null;
		host = InetAddress.getLocalHost();
		return host.getHostName();
		
	}
	/**
	 * 
	 * @param str
	 * @throws UnknownHostException
	 */
	public static void parse(String str) throws UnknownHostException {
		int position = 0;
		while (position != -1) {
			position = str.indexOf("@", position);
			
			if(position != -1){
				host = str.substring(position + 1);
				host.trim();
				user = str.substring(0, position);
				user.trim();
				position++;
			}else {
				user = str;
				host = getLocalHost();
			}
		}
	}
	
	public static void startFingerClient(String str) throws UnknownHostException {
		Socket fingerSocket = null;
		DataOutputStream os = null;
		BufferedReader is = null;
		
		if(str.length() == 1){
			parse(str);
		}else {
			host = getLocalHost();
			user = "@" + host;
		}
		
		// 
		try {
			fingerSocket = new Socket(host, FINGERPROT);
			os = new DataOutputStream(fingerSocket.getOutputStream());
			is = new BufferedReader(new InputStreamReader(fingerSocket.getInputStream()));
			
			if(fingerSocket != null && os != null && is != null){
				os.writeBytes(user);
				os.writeBytes("\n");
				
				String responseLine;
				while ((responseLine = is.readLine()) != null) {
					System.out.println("the server responsed-->\t" + responseLine);
				}
			}
			
			//
			os.close();
			is.close();
			fingerSocket.close();
		} catch (IOException e) {
			System.out.println("finger socket starting error......" + e.getMessage());
			e.printStackTrace();
		}
	}

}
