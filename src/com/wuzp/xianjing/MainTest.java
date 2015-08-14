package com.wuzp.xianjing;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

public class MainTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {

		System.out.println(isOdd(1)); //
		System.out.println(isOdd(2));
		System.out.println(isOdd(3));

		doubleMinus(2.0, 1.1); // 0.8999999999999999

		final long A = 24 * 60 * 60 * 1000 * 1000;
		final long B = 24 * 60 * 60 * 1000;
		longDivison(A, B); // 5 not 1000

		swap(1984, 2001); // x = 0; y = 1984

		charAndString();

		char[] chs = { '1', '2', '3' };
		charArray("ABC", chs);

		unicodeTest();

		className();

		radomTest();

		forTest();

		// whileTest();

		clockTest();

		System.out.println(returnValue());

//		goodBye();
		
		try {
			copyTest();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
	}

	// 找奇数
	public static boolean isOdd(int i) {
		return i % 2 == 1;
	}

	// 浮点数相减
	public static void doubleMinus(double a, double b) {
		System.out.println(a - b);
	}

	// 长整除
	public static void longDivison(long a, long b) {
		System.out.println(a / b);
	}

	// 互换内容
	public static void swap(int x, int y) {
		x ^= y ^= x ^= y;
		System.out.println("x = " + x + ";\t y = " + y);
	}

	// 字符串和字符
	public static void charAndString() {
		System.out.println("H" + "a");
		System.out.println('H' + 'a');
	}

	// 字符数组
	public static void charArray(String str, char[] chs) {
		System.out.println(str + "---" + chs);
	}

	// 转义字符 \u0022双引号的转义字符
	public static void unicodeTest() {
		System.out.println("a\u0022.length() + \u0022b".length());
	}

	// 打印输出类名
	public static void className() {
		System.out.println(MainTest.class.getName().replaceAll(".", "/")
				+ ".class");
	}

	// 随机数的问题
	private static Random rdm = new Random();

	public static void radomTest() {
		StringBuffer sb = null;
		switch (rdm.nextInt(5)) {
		case 1:
			sb = new StringBuffer("P");
		case 2:
			sb = new StringBuffer("G");
		default:
			sb = new StringBuffer("M");
		}
		sb.append("a");
		sb.append("i");
		sb.append("n");
		System.out.println(sb);
	}

	// 无情的增量
	public static void forTest() {
		int j = 0;
		for (int i = 0; i < 100; i++) {
			j = j++;
		}
		System.out.println(j);
	}

	// 整数边界问题
	public static final int END = Integer.MAX_VALUE;
	public static final int START = END - 100;

	public static void whileTest() {
		int count = 0;
		for (int i = START; i <= END; i++) {
			count++;
		}
		System.out.println(count + "--------");
	}

	// 计数器问题
	public static void clockTest() {
		int mi = 0;
		for (int i = 0; i < 60 * 60 * 1000; i++) {
			if (i % 60 * 1000 == 0) {
				mi++;
			}
		}
		System.out.println(mi);
	}

	// 优柔寡断的返回值
	public static boolean returnValue() {
		try {
			return true;
		} finally {
			return false;
		}
	}

	// 你好 再见
	public static void goodBye() {
		try {
			System.out.println("hello");
			System.exit(0);
		} finally {
			System.out.println("goodbye");
		}
	}

	// 到底关闭了吗
	public static void copyTest() throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream("input");
			out = new FileOutputStream("dest");
			byte[] buf = new byte[1024];
			int n;
			while ((n = in.read(buf)) > 0) {
				out.write(buf, 0, n);
				System.out.println(buf + "copytest");
			}
		} finally {
			if (in != null) {
				in.close();
				System.out.println("in.close()");
			}
			if (out != null) {
				out.close();
				System.out.println("out.close()");
			}
		}
	}
}
