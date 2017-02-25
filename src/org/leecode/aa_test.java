package org.leecode;

import java.util.Hashtable;

public class aa_test {
	public static void main(String[] args){
		int res = Add(1, 3);
	    System.out.print(res);
	   
	   // (a ^ b).toString(2).replace(“0", "").length();
	    
	}
	 
	static int Add(int x, int y)
	{
	    // Iterate till there is no carry  
	    while (y != 0)
	    {
	        // carry now contains common set bits of x and y
	        int carry = x & y;  
	 
	        // Sum of bits of x and y where at least one of the bits is not set
	        x = x ^ y; 
	 
	        // Carry is shifted by one so that adding it to x gives the required sum
	        y = carry << 1;
	    }
	    return x;
	}
	
	public int[] twoSum(int[] nums, int target) {
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i ++){
            if (ht.containsValue(target - nums[i])){
                res[0] = i;
                //res[1] = ht.getKey(target - nums[i]);
            }
            ht.put(i, nums[i]);
        }
        return res;
    }
}
