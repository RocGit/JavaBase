package com.wuzp.thread;

public class MyThreadRunnable implements Runnable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadRunnable mr1 = new MyThreadRunnable();
		MyThreadRunnable mr2 = new MyThreadRunnable();
		
		Thread t1 = new Thread(mr1, "mr1t1");
		Thread t2 = new Thread(mr2, "mr2t2");

		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 13; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("" + e.getMessage());
				e.printStackTrace();
			}
		}
		
	}

}
