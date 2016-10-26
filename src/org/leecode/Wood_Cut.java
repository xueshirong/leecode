package org.leecode;

import java.util.Arrays;

public class Wood_Cut {
	/*Given n pieces of wood with length L[i] (integer array). 
	Cut them into small pieces to guarantee you could have equal or more than k pieces with the same length. 
	What is the longest length you can get from the n pieces of wood? Given L & k, 
			return the maximum length of the small pieces.*/
	
	/** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if (L == null || L.length == 0)
            return 0;
        Arrays.sort(L);
        int s = 1;
        int e = L[L.length - 1];
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            int num = count(L, mid);
            if (num == k)
                s = mid;
            else if (num > k)
                s = mid;
            else
                e = mid;
        }
        
        if (count(L, s) >= k)
            return s;
        else if (count(L, e) >= k)
            return e;
        return 0;
    }
    
    private int count(int[] nums, int len){
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i]/len;
        }
        return sum;
    }
}
