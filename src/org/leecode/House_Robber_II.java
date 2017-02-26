package org.leecode;

public class House_Robber_II {
	//[思路]House Robber I的升级版. 因为第一个element 和最后一个element不能同时出现. 则分两次call House Robber I. 
    //case 1: 不包括最后一个element. case 2: 不包括第一个element.两者的最大值即为全局最大值
    public int rob(int[] nums) {
        //corner case
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int m = robsub(nums, 0, nums.length - 2);
        int n = robsub(nums, 1, nums.length - 1);
        return Math.max(m, n);
    }
    //res[i] =  Math.max(res[i -2] + nums[i], res[i - 1])
    private int robsub1(int[] nums, int s, int e){
        int n = e - s + 1;
        int[] res = new int[n];
        res[0] = nums[s];
        res[1] = Math.max(nums[s], nums[s + 1]);//key point [s + 1]
        for (int i = 2; i < n; i++){
            res[i] = Math.max(res[i - 2] + nums[s + i], res[i - 1]);
        }
        return res[n - 1];
    }
    //res[i] =  Math.max(res[i -2] + nums[i - 1], res[i - 1])
    private int robsub(int[] nums, int s, int e){
        int n = e - s + 1;
        int[] res = new int[n + 1];
        res[0] = 0;
        res[1] = nums[s];
        for (int i = 2; i <= n; i++){
            res[i] = Math.max(res[i - 2] + nums[s + i - 1], res[i - 1]);
        }
        return res[n];
    }
}
