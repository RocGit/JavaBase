package com.wuzp.thread.arrayio;

public class ArrayMath {

	public ArrayMath() {
	}

	public int[] addArray(int[] a, int[] b, int length) {
		int[] result = new int[length];
		for (int i = 0; i < result.length; i++) {
			result[i] = a[i] + b[i];
		}
		return result;
	}
}
