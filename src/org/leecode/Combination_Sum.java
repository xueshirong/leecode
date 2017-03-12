package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {
	/**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
	int tar = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        tar = target;
        List<Integer> path = new ArrayList<Integer>();
        helper(candidates, 0, path, res);
        return res;
    }
    private void helper(int[] nums, int pos, List<Integer> path, List<List<Integer>> res){
        if (sumval(path) > tar)
            return;
        
        if (sumval(path) == tar){
            if (!res.contains(path))//remove duplicated array
                res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for (int i = pos; i < nums.length; i++){
            if (nums[i] > tar)
                break;
            path.add(nums[i]);
            helper(nums, i, path, res);
            path.remove(path.size() - 1);
        }
    }
    
    private int sumval(List<Integer> path){
        int res = 0;
        for (int i : path){
            res += i;
        }
        return res;
    }
    
    //solution 2: deduct nums[i] to be as new target. more efficient
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (candidates == null || candidates.length == 0)
            return res;
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
            helper(nums, i, target - nums[i], path, res);//每个ele允许重复使用，因此传入i,而不是i+1
            path.remove(path.size() - 1);
        }
    }
}
