package org.leecode;

public class Maximum_Subarray {
	public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (sum > 0){
                sum = sum + nums[i];
            }else{
                total = Math.max(total, sum);
                sum = nums[i];
            }
        }
        total = Math.max(total,sum);
        return total;
    }
	
	//-------------------
	//Given an array of integers, find a contiguous subarray which has the largest sum.
	/**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray3(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int minsum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum - minsum);
            minsum = Math.min(minsum, sum);
        }
        return max;
    }
    
        //DP dp[i] = dp[i-1]<=0 ? dp[i] : dp[i-1]+A[i]  O(n)
        public int maxSubArray4(int[] nums) {
            int max = nums[0], cur = nums[0];
            for (int i = 1; i < nums.length; i++){
                if (cur <= 0)
                    cur = nums[i];
                else
                    cur += nums[i];
                max = Math.max(max, cur);
            }
            return max;
        }
        
        //greedy O(n)
        public int maxSubArray1(int[] nums) {
            //corner case
            if (nums == null || nums.length == 0)
                return 0;
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int minsum = 0;
            for (int i = 0; i < nums.length; i++){
                sum += nums[i];
                max = Math.max(max, sum - minsum);
                minsum = Math.min(minsum, sum);
            }
            return max;
        }
        
        //...binary search  O(Logn)
        /*但是题目中要求，不要用这个O(n)解法，而是采用Divide & Conquer。这就暗示了，解法必然是二分。分析如下：

        假设数组A[left, right]存在最大值区间[i, j](i>=left & j<=right)，以mid = (left + right)/2 分界，无非以下三种情况：

        subarray A[i,..j] is
        (1) Entirely in A[low,mid-1]
        (2) Entirely in A[mid+1,high]
        (3) Across mid
        对于(1) and (2)，直接递归求解即可，对于(3)，则需要以min为中心，向左及向右扫描求最大值，意味着在A[left, Mid]区间中找出A[i..mid], 而在A[mid+1, right]中找出A[mid+1..j]，两者加和即为(3)的解。*/
        public int maxSubArray2(int[] nums) {
            // Start typing your Java solution below
            // DO NOT write main() function
            int max = Integer.MIN_VALUE;
            return maxArray(nums, 0, nums.length - 1, max);
        }
        
        int maxArray(int[] A, int left, int right, int max){
            if(left > right){
                return Integer.MIN_VALUE;
            }
            
            int mid = (left + right) / 2;
            int leftMax = maxArray(A, left, mid - 1, max);
            int rightMax = maxArray(A, mid + 1, right, max);
            
            max = Math.max(max, leftMax);
            max = Math.max(max, rightMax);
            
            int sum = 0, mlmax = 0;
            for(int i = mid - 1; i >= left; i--){
                sum += A[i];
                if(sum > mlmax){
                    mlmax = sum;
                }
            }
            sum = 0; int mrmax = 0;
            for(int i = mid + 1; i <= right; i++){
                sum += A[i];
                if(sum > mrmax){
                    mrmax = sum;
                }
            }
            max = Math.max(max, A[mid] + mlmax + mrmax);
            return max;
        }
    }

