package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II {
	//Given a collection of candidate numbers (C) and a target number (T), 
	//find all unique combinations in C where the candidate numbers sums to T.

	//Each number in C may only be used once in the combination
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<Integer>();
        helper(candidates, 0, target, path, res);
        return res;
    }
    private void helper(int[] nums, int pos, int target, List<Integer> path, List<List<Integer>> res){
        if (target == 0){
            if (!res.contains(path))
                res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = pos; i < nums.length; i++){
            if (nums[i] > target)
                break;
            path.add(nums[i]);
            helper(nums, i + 1, target - nums[i], path, res);//"i + 1" means each number in C may only be used once in the combination.
            path.remove(path.size() - 1);
        }
    }
}
