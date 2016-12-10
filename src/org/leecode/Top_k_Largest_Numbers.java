package org.leecode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Top_k_Largest_Numbers {
	/*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
		//corner case
        if (nums == null || nums.length == 0 || k == 0 || nums.length < k)
            return new int[k];
        
        Comparator cmp = new Comparator<Integer>() {
        	public int compare(Integer n, Integer m){
        		return m - n;
        	}
        };        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, cmp);
        for (int i = 0; i < nums.length; i++){
            queue.add(nums[i]);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        
        return res;
    }
}
