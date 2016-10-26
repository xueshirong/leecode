package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		int lis = 0;
        if (nums.length == 0)
            return lis;
        for (int i = 0; i < nums.length; i++){
            List<Integer> list = new ArrayList<Integer>();
            list.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] > list.get(list.size() -1)){
                    list.add(nums[j]); 
                }
            }
            if (lis < list.size())
                lis = list.size();
        }
        return lis;
    }
}
