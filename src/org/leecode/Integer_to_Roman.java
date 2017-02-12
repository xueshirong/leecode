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
	 
	 //solution 2
	//1. list all possible numbers for roman (1,4,5,9...) and (I, IV, V IX...)
	    //2. calculate times between num and symbol[i], and append them
	    public String intToRoman1(int num) {
	        //corner case
	        if (num < 1 || num > 3999)
	            return "";
	        StringBuilder sb = new StringBuilder();
	        int[] nums = new int[]{1,4,5,9,10,40,50,90,100,400,500,900,1000};
	        String[] symbols = new String[]{"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
	        for (int i = nums.length - 1; i > -1; i--){
	            int times = num / nums[i];
	            for (int j = 0; j < times; j++){
	                sb.append(symbols[i]);
	            }
	            num = num - times * nums[i];
	        }
	        return sb.toString();
	    }
}
