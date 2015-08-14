package com.wuzp.thread;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	public void run() {
		for (int i = 0; i < 3; i++) {
			System.out.println(getName() + ":" + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread t1 = new MyThread("Tread1111111111");
		MyThread t2 = new MyThread("Tread222222222222");

		t1.start();
		t2.start();

	}

}
