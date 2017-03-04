package org.leecode.Test;

public class Max_Consecutive_Ones {
	//用curmax记录当前有多少个1，并实时更新全局最大值。
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int curmax = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 1){
                curmax += nums[i];
            }else{
                curmax = 0;
            }
            max = Math.max(max, curmax);
        }
        
        return max;
    }
}
