package com.wuzp;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

	// /=============Heapb OverFlow=========================
	private static class HeapObject {

	}

	// /==============Stack OverFlow===============================
	private static class StackStruct {
		private int stackLength = 1;

		private void stackLeak() {
			stackLength++;
			stackLeak();
		}
	}

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {

		StackStruct stackStruct = new StackStruct();
		try {
			stackStruct.stackLeak();
		} catch (Throwable te) {
			System.out.println("stack length:" + stackStruct.stackLength);
			throw te;
		}

		List<HeapObject> heapList = new ArrayList<BaseTest.HeapObject>();
		while (true) {
			heapList.add(new HeapObject());
		}

	}

}
