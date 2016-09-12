package org.leecode;

public class Integer_to_Roman {
	//from Jiu Zhang
	 public String intToRoman(int num) {
	        //it is important to know all the special numer 1,4, 5, 9
	        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
	        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	        
	        String res = "";
	        for (int i = 0; i < nums.length; i++){
	            int times = num/nums[i];//calclate how many times for each symbol
	            num -= times * nums[i];//get the new num
	            for (int j = 0; j < times; j++){
	                res += symbol[i];
	            }
	        }
	        return res;
	 }
}
