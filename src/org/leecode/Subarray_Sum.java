package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;

public class Subarray_Sum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
       
        int len = nums.length;
       
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       
        map.put(0, -1);
       
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
           
            if (map.containsKey(sum)) {
                ans.add(map.get(sum) + 1);
                ans.add(i);
                return ans;
            }
            
            map.put(sum, i);
        }
       
        return ans;
    }
    
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum2(int[] nums) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){//check element == 0 ?
                res.add(i);
                res.add(i);
                return res;
            }
            sum += nums[i];
            if (sum == 0){//check sum == 0 ?
                res.add(0);
                res.add(i);
                return res;
            }
            
            if (map.containsKey(sum)){//check segment sum == 0 ?
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }else
                map.put(sum, i);
        }
        return res;
    }
}
