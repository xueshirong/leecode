package org.leecode;

import java.util.Arrays;
import java.util.Comparator;

public class Largest_Number {
	//例如字符串str1和str2，拼接字符串cmp1 = str1 + str2，cmp2 = str2 + str1。按照字典排序，如果cmp1 > cmp2，则str1 > str2。反之，则str1 < str2。 
	//注意：这里可以使用Java提供的Comparator接口，然后实现字典逆序。
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
            return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++){//save ele to string array
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>(){//sort string array
            public int compare(String a, String b){
                String ab = a + b;
                String ba = b + a;
                return ba.compareTo(ab);
              //return Integer.parseInt(ab) - Integer.parseInt(ba); case overflow
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : strs){
            sb.append(s);
        }
        return sb.toString();
    }
	
	public String largestNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if (strs[strs.length-1].charAt(0) == '0') return "0";
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res = strs[i]+res;
        }
        return res;
    }
}
