package org.leecode;

import java.util.Arrays;

public class Add_Binary {
	public String addBinary(String a, String b) {//this is not a good solution, need to improve
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        String res = "";
        int pre = 0;
        for(int i = maxLen - 1; i > -1; i--){
            int aValue = (aLen > 0) ? Character.getNumericValue(a.charAt(aLen - 1)) : 0;
            int bValue = (bLen > 0) ? Character.getNumericValue(b.charAt(bLen - 1)) : 0;
            
            if ((pre + aValue + bValue) < 2){
                res = String.valueOf(pre + aValue + bValue) + res;
                pre = 0;
            }else if ((pre + aValue + bValue) == 2){
                res = "0" + res; //easy to make mistake. should be "0" + res
                pre = 1;
            }else if ((pre + aValue + bValue) == 3){
                res = "1" + res;//easy to make mistake. should be "1" + res
                pre = 1;
            }
            aLen--;
            bLen--;
        }
        if (pre > 0)
            return String.valueOf(pre) + res;
        else
            return res;
    }
	
	public String addBinary2(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int pre = 0;
        Integer[] res = new Integer[len];
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(len > -1){
            if (i < 0 || j < 0)
                break;
            int tempSum = Integer.parseInt("" + a.charAt(i)) + Integer.parseInt("" + b.charAt(j)) + pre;
            if (tempSum > 1){
                pre = 1;
                res[len - 1] = 0; 
            }else{
                pre = 0;
                res[len - 1] = tempSum;
            }
            len--;
            i--;
            j--;
        }
        while(i > -1){
            int tempSum = Integer.parseInt("" + a.charAt(i)) +  pre;
            if (tempSum > 1){
                pre = 1;
                res[i] = 0; 
            }else{
                pre = 0;
                res[i] = tempSum;
            }
            i--;
        }
         while(j > -1){
            int tempSum = Integer.parseInt("" + b.charAt(j)) +  pre;
            if (tempSum > 1){
                pre = 1;
                res[j] = 0; 
            }else{
                pre = 0;
                res[j] = tempSum;
            }
            j--;
        }
        String aa = String.valueOf(pre) + Arrays.toString(res);
        return aa;
    }
}
