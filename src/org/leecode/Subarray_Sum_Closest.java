package org.leecode;

import java.util.Arrays;
import java.util.Comparator;

public class Subarray_Sum_Closest {
	//Given an integer array, find a subarray with sum closest to zero. 
	//Return the indexes of the first number and last number.
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class pair{
        int sum = 0;
        int index = 0;
        public pair(int s, int i){
            sum = s;
            index = i;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        //corner case
        if (nums == null || nums.length == 0)
            return res;
        if (nums.length == 1){
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        
        
        pair[] p = new pair[nums.length];
        int sum = 0;
        //get pre sum for each i
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                res[0] = i;
                res[1] = i;
                return res;
            }
            sum += nums[i];
            if (sum == 0){
                res[0] = 0;
                res[1] = i;
                return res;
            }
            p[i] = new pair(sum, i);
        }
        //sort sums
        Arrays.sort(p, new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.sum - b.sum;
            }
        });
        int min = Integer.MAX_VALUE;
        //compare and get the dif between sums is closest to zero
        for (int i = 1; i < nums.length; i++){
            int dif = Math.abs(p[i].sum - p[i - 1].sum);
            if (dif < min){
                min = dif;
                
                res[0] = Math.min(p[i - 1].index, p[i].index) + 1;
                res[1] = Math.max(p[i - 1].index, p[i].index);
            }
            
        }
        return res;
    }
}
