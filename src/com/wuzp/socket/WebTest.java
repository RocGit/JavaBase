package com.wuzp.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WebTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
//			Socket ss = new Socket("blog.csdn.net", 8080);
//			InputStream in = ss.getInputStream();
//			OutputStream ou = ss.getOutputStream();
//			System.out.println(in.toString());
			HttpURLConnection hc = new HttpURLConnection(new URL("http://blog.csdn.net")) {
				
				@Override
				public void connect() throws IOException {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public boolean usingProxy() {
					// TODO Auto-generated method stub
					return false;
				}
				
				@Override
				public void disconnect() {
					// TODO Auto-generated method stub
					
				}
			};
			hc.connect();
			int l = hc.getContentLength();
			Map<String, List<String>> mm = hc.getHeaderFields();
			Collection<List<String>> c = mm.values();
			Iterator<List<String>> it = c.iterator();
			for(;it.hasNext();) {
				for(int i = 0; i<it.next().size(); i++){
					System.out.println(it.next().get(i));
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
