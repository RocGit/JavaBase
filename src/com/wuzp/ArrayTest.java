package com.wuzp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] strarr1 = { "gg", "ff", "ee", "dd", "cc", "bb", "aa" };
		String[] strarr2 = { "xx", "yy", "zz", "aa", "bb", "cc", "dd" };

//		List<String> list = getAllSameElement1(strarr1, strarr2);
		List<String> list = getAllSameElement2(strarr1, strarr2);
		
		if (list.isEmpty()) {
			System.out.println("the two arrays haven't have the same element");
		} else {
			for (String s : list) {
				System.out.println("The element is:--->\t" + s);
			}
		}
		
		int[] ia = new int[3];
		System.out.println("int[] init--->" + ia[0]);
		String[] sa = new String[3];
		System.out.println("String[] init--->" + sa[0]);
	}

	/**
	 * 
	 * @param strArr1
	 * @param strArr2
	 * @return
	 */
	@SuppressWarnings("unused")
	private static List<String> getAllSameElement1(String[] strArr1, String[] strArr2) {
		if (strArr1 == null || strArr2 == null) {
			return null;
		}
		List<String> strList1 = new ArrayList<String>(Arrays.asList(strArr1));
		List<String> strList2 = new ArrayList<String>(Arrays.asList(strArr2));

		strList1.retainAll(strList2);
		return strList1;
	}

	/**
	 * 
	 * @param strArr1
	 * @param strArr2
	 * @return
	 */
	public static List<String> getAllSameElement2(String[] strArr1,
			String[] strArr2) {
		if (strArr1 == null || strArr2 == null) {
			return null;
		}
		Arrays.sort(strArr1);
		Arrays.sort(strArr2);

		List<String> list = new ArrayList<String>();

		int k = 0;
		int j = 0;
		while (k < strArr1.length && j < strArr2.length) {
			if (strArr1[k].compareTo(strArr2[j]) == 0) {
				if (strArr1[k].equals(strArr2[j])) {
					list.add(strArr1[k]);
					k++;
					j++;
				}
				continue;
			} else if (strArr1[k].compareTo(strArr2[j]) < 0) {
				k++;
			} else {
				j++;
			}
		}
		return list;
	}
}
