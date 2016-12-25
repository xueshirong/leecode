package org.leecode;

public class K_Closest_Numbers_In_Sorted_Array {
	/**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        //corner case
        if (A == null || A.length == 0 || k > A.length)
            return A;
        
        int[] res = new int[k];
        int index = findfirst(A, target);
        
        int start = index - 1;
        int end = index;
        //find k
        for (int i = 0; i < k; i ++){
            if (start < 0){
                res[i] = A[end];
                end++;
            }else if (end >= A.length){
                res[i] = A[start];
                start--;
            }else{
                if (target - A[start] <= A[end] - target){//key point
                    res[i] = A[start];
                    start--;
                }else{
                    res[i] = A[end];
                    end++;
                }
            }
        } 
        
        return res;
    }
    private int findfirst(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start)/2;
            if (nums[mid] >= target)
                end = mid;
            else if (nums[mid] < target)
                start = mid;
        }
        if (nums[start] >= target)
            return start;
        if (nums[end] >= target)
            return end;
        
        return nums.length;
    }
}
