package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Plus_One {
	public int[] plusOne(int[] digits) {
        Integer tem = 0;
        for (int i = digits.length-1; i > -1; i--){//loop from back to front
            tem = (digits[i] + 1)/10;
            digits[i] = (digits[i] + 1)%10;
            if (tem == 0)
                return digits;//After plus one, the value less than 10, then stop. no need continue to loop.
        }
        int[] results = new int[digits.length + 1];//If the (first digit + 1) > 10, then use new array to set 1000...
        Arrays.fill(results, 0);
        results[0] = 1;
        return results;
    }
	
	//lower efficiency
	public int[] plusOne1(int[] digits) {
        List<Integer> res = new ArrayList<Integer>();
        int carry = 0;
        int len = digits.length - 1;
        while(len > -1 || carry != 0){
            if (len == digits.length - 1){
                carry += digits[len] + 1;
            }else if (len > -1){
                carry += digits[len];
            }
            res.add(0, carry % 10);
            carry = carry / 10;
            len--;
        }
        
        int[] ret = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
        	ret[i] = (res.get(i));
        }
        return ret;
    }
}
