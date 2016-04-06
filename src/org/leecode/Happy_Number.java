package org.leecode;

import java.util.HashSet;

public class Happy_Number {
	HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        set.add(n);
        boolean res = isHappyHelper(n);
        return res;
    }
    
    public boolean isHappyHelper(int n){
        String strN = String.valueOf(n);
        int len = strN.length();
        int[] arrTemp = new int[len];
        for(int i = 0; i < len; i++){//loop to get every digit of n, save them to array
            arrTemp[i] = n%10;//get digit
            n = n/10;
        }
        int sum = 0;
        for(int i = 0; i < len; i++){// sum the square of n's digits
            sum = sum + arrTemp[i] * arrTemp[i];
        }
        
        if (sum == 1){//if n is happy, return true
            return true;
        }else if (!set.add(sum)){//if sum already exist in set, return false; or add sum to set as new n
            return false;
        }
        return isHappyHelper(sum);//check the new n is happy or not
    }
}
