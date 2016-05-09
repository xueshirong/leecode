package org.leecode;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
	public class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        PriorityQueue<Integer> pq =new PriorityQueue<Integer>();
	        for (int i = 0; i < nums.length; i++){
	            pq.add(nums[i]);
	            if (pq.size() > k){
	                pq.poll();
	            }
	        }
	        Integer res = pq.poll();
	        return res;
	    }
	}
}
