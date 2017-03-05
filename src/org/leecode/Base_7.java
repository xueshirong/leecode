package org.leecode;

public class Base_7 {
	public String convertToBase7(int num) {
		String res = "";
		int y = num;
		while (num != 0) {			
			y = num % 7;
			res = String.valueOf(y) + res;
			num = num / 7;
		}
		res = String.valueOf(y) + res;
		return res;
	}
}
