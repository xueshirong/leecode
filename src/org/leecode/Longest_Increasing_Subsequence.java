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
	
	//Given a sequence of integers, find the longest increasing subsequence (LIS).
	//You code should return the length of the LIS.
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
	//From Jiu Zhang
    public int longestIncreasingSubsequence(int[] nums) {
    	if (nums == null || nums.length == 0)
            return 0;
        //state
        int[] path = new int[nums.length];
        int max = 0;
        //initial
        path[0] = 1;
        for (int i = 1; i < path.length; i++){
            path[i] = 1;
        }
        
        //function
        for(int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    if (path[i] < path[j] + 1)
                        path[i] = path[j] + 1;
                }
            }
            if (path[i] > max)//last element of path is not nessary the biggest
                max = path[i];
        }
        
        //answer
        return max;
    }
}
