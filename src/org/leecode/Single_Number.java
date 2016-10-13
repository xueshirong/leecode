package org.leecode;

import java.util.HashSet;
import java.util.Set;

public class Single_Number {
	public int singleNumber1(int[] nums) {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if (hs.contains(nums[i]))
                hs.remove(nums[i]);
            else
                hs.add(nums[i]);
        }
        return Integer.parseInt(hs.iterator().next().toString());
    }
	
	public int singleNumber(int[] nums) {
		//a^a^b^b^c = (a^a)^(b^b)^c=0^0^c=c
		int ini = 0;
        for (int num : nums){
        	ini = ini ^ num;
        }
        return ini;
    }
	//From Jiu Zhang
	public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++){
            res = res ^ nums[i];
        }
        return res;
    }
}
