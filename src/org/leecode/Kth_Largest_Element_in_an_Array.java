package org.leecode;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
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
	    
	    //...........
	    public int findKthLargest2(int[] nums, int k) {
	        //corner case
	        if (nums == null || nums.length == 0 || k < 0)
	            return 0;
	        return helper(nums, 0, nums.length - 1, k - 1);
	    }
	    private int helper(int[] arr, int left, int right, int k){
	        int pivot = arr[(left + right) / 2];
	        int orgL = left, orgR = right;
	        while(left <= right){
	            // 从右向左找到第一个小于枢纽值的数
	            while(arr[left] > pivot){
	                left ++;
	            }
	            // 从左向右找到第一个大于枢纽值的数
	            while(arr[right] < pivot){
	                right --;
	            }
	            // 将两个数互换
	            if(left <= right){
	                swap(arr, left, right);
	                left ++;
	                right --;
	            }
	        }
	        // 最后退出的情况应该是右指针在左指针左边一格
	        // 这时如果右指针还大于等于k，说明kth在左半边
	        if(orgL < right && k <= right) return helper(arr, k, orgL, right);
	        // 这时如果左指针还小于等于k，说明kth在右半边
	        if(left < orgR && k >= left) return helper(arr, k, left, orgR);
	        return arr[k];
	    }
	    private void swap(int[] arr, int idx1, int idx2){
	        int tmp = arr[idx1] + arr[idx2];
	        arr[idx1] = tmp - arr[idx1];
	        arr[idx2] = tmp - arr[idx2];
	    
	    }
}
