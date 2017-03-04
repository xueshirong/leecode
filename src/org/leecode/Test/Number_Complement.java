package org.leecode.Test;

public class Number_Complement {
	public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        String ss = "";
        for (int i = 0; i < s.length(); i++)
            ss += "1";
        int sum = Integer.parseInt(ss, 2);
        return sum - num;
    }
}
