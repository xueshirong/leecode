package org.leecode;

import java.util.Arrays;

public class Multiply_Strings {
	//from Jiu Zhang. Do not understand
	public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        
        int len1 = num1.length(), len2 = num2.length();
        int len3 = len1 + len2;
        int i, j, product, carry;

        int[] num3 = new int[len3];
        for (i = len1 - 1; i >= 0; i--) {
            carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + num3[i + j + 1] +
                    Character.getNumericValue(num1.charAt(i)) *
                    Character.getNumericValue(num2.charAt(j));
                num3[i + j + 1] = product % 10;
                carry = product / 10;
            }
            num3[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();
        i = 0;

        while (i < len3 - 1 && num3[i] == 0) {
            i++;
        }

        while (i < len3) {
            sb.append(num3[i++]);
        }

        return sb.toString();
    }
	//From Internet. Do not understand
	public static String multiply2(String num1, String num2) {  
        // 先把string翻转  
        String n1 = new StringBuilder(num1).reverse().toString();  
        String n2 = new StringBuilder(num2).reverse().toString();  
          
        int[] d = new int[n1.length()+n2.length()];     // 构建数组存放乘积  
        for(int i=0; i<n1.length(); i++){  
            for(int j=0; j<n2.length(); j++){  
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');      // 在正确位置累加乘积  
            }  
        }  
          
        StringBuilder sb = new StringBuilder();  
        for(int i=0; i<d.length; i++){  
            int digit = d[i]%10;        // 当前位  
            int carry = d[i]/10;        // 进位  
            if(i+1<d.length){  
                d[i+1] += carry;  
            }  
            sb.insert(0, digit);        // prepend  
        }  
          
        // 移除前导零  
        while(sb.charAt(0)=='0' && sb.length()>1){  
            sb.deleteCharAt(0);  
        }  
        return sb.toString();  
    } 
	// From Leetcode discuss
	public String multiply3(String num1, String num2) {
	    int m = num1.length(), n = num2.length();
	    int[] pos = new int[m + n];
	   
	    for(int i = m - 1; i >= 0; i--) {
	        for(int j = n - 1; j >= 0; j--) {
	            int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); 
	            int p1 = i + j, p2 = i + j + 1;
	            int sum = mul + pos[p2];

	            pos[p1] += sum / 10;
	            pos[p2] = (sum) % 10;
	        }
	    }  
	    
	    StringBuilder sb = new StringBuilder();
	    for(int p : pos) if(!(sb.length() == 0 && p == 0)) sb.append(p);
	    return sb.length() == 0 ? "0" : sb.toString();
	}
	// self base on leetcode discuss
	public String multiply4(String num1, String num2) {
        if(num1 == null || num2 == null)
            return "";
            
        int l1 = num1.length();
        int l2 = num2.length();
        int[] res = new int[l1 + l2];
        for (int i = l2 -1; i > -1; i--){
            for (int j = l1 -1; j > -1; j--){
                int p = (num2.charAt(i) - '0') * (num1.charAt(j) - '0');                
                int sum = p + res[i + j + 1];
                
                res[i + j + 1] = sum % 10;//加上前一次的值
                res[i + j] += sum / 10;//同理，进一步求进位值  
            }
        }
        String re = "";
        int k = 0;
        while (k < res.length && res[k] == 0){
            k++;
        }
        for (;k < res.length; k++){
        		re += String.valueOf(res[k]);
        }
        if (re.equals(""))
        	return "0";
        return re;
    }
}
