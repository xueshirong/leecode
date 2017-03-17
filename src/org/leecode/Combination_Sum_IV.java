package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_IV {
	//dfs recursive will time out
    public int combinationSum41(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(nums);
        helper(nums, target, res, path);
        return res.size();
    }
    void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> path){
        if (target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > target)
                break;
            path.add(nums[i]);
            helper(nums, target - nums[i], res, path);
            path.remove(path.size() - 1);
        }
    }
    
    //solution 2 DP d[i] += d[i - num];
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int i = 0; i < target + 1; i++){
            for (int val : nums){
                if (val > i)
                    break;
                f[i] += f[i - val];
            }
        }
        return f[target];
    }
}
