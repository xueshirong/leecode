package org.leecode;

public class Integer_to_English_Words {
	 private String[] less20 = {"", "One ", "Two ", "Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
	 private String[] tens = {"", "", "Twenty ", "Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
	 private String[] thous = {"", "Thousand ", "Million ", "Billion "};
	    
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String res = "";
        int i = 0;
        while(num > 0){
        	if (num % 1000 > 0)
        		res = helper(num % 1000) + thous[i] + res;
            i++;
            num = num / 1000;
        }
        return res;
    }
    private String helper(int num){
        if (num == 0)
            return "";
        else if (num < 20){
            return less20[num];
        }else if (num < 100){
            return tens[num/10] + helper(num%10);
        }else{
            return less20[num/100] + "hundred " + helper(num%100);
        }
    }
}
