package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III {
	//the solution is same with combinationSum2 and 1, use pos to represent 1-9.
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(1, res, path, n, k);
        return res;
    }
    void helper(int pos, List<List<Integer>> res, List<Integer> path, int n, int k){
        if (n == 0 && path.size() == k){
            if (!res.contains(path)){
                res.add(new ArrayList<Integer>(path));
                return;
            }
        }
        for (int i = pos; i <= 9; i++){
            if (i > n)
                break;
            path.add(i);
            helper(i + 1, res, path, n - i, k);
            path.remove(path.size() - 1);
        }
    }
}
