package org.leecode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
	//1. 优先队列:遍历数组时将数字加入优先队列（堆），一旦堆的大小大于k就将堆顶元素去除，确保堆的大小为k。遍历完后堆顶就是返回值。
    //时间 O(NlogK) 空间 O(K)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) p.poll();
        }
        return p.poll();
    }
    
    //2. 排序法:时间 O(NlogN) 空间 O(1).将数组排序后，返回第k个元素。
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    
    //3. 快速选择 Quick Select:时间 Avg O(N) Worst O(N^2) 空间 O(1)
    //跟快速排序一个思路。先取一个枢纽值，将数组中小于枢纽值的放在左边，大于枢纽值的放在右边，具体方法是用左右两个指针，
    //如果他们小于枢纽值则将他们换到对面，一轮过后记得将枢纽值赋回分界点。如果这个分界点是k，说明分界点的数就是第k个数。
    //否则，如果分界点大于k，则在左半边做同样的搜索。如果分界点小于k，则在右半边做同样的搜索。
    public int findKthLargest2(int[] nums, int k) {
        //corner case
        if (nums == null || nums.length == 0 || k < 0)
            return 0;
        return helper(nums, 0, nums.length - 1, k);
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
