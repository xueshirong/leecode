package org.leecode;

public class House_Robber {
	//Time O(n), Space O(1)
	public int rob1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int lastMax = nums[0];
        int curMax = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++){
            int temp = curMax;
            curMax = Math.max(lastMax + nums[i], curMax);
            lastMax = temp;
        }
        return curMax;
    }
	//from jiu zhang dp[i] = max(dp[i-2] + nums[i], dp[i-1])
	//Time O(n), Space O(n)
	public long rob(int[] A) {
        // write your code here
        int n = A.length;
        if(n == 0)
            return 0;
        long []res = new long[n+1];
        
        
        res[0] = 0;
        res[1] = A[0];
        for(int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
}
