package org.leecode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	 public List<List<Integer>> permute(int[] nums) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        if (nums == null || nums.length == 0){
	            return res;
	        }
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        helper(nums,list,res);
	        return res;
	    }
	    public void helper(int[] nums, ArrayList<Integer> list, List<List<Integer>> res){
	        if (list.size() == nums.length){
	            res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for (int i = 0; i < nums.length; i++){
	            if (list.contains(nums[i])){
	                continue;
	            }
	            list.add(nums[i]);
	            helper(nums, list, res);
	            list.remove(list.size() - 1);
	        }
	    }
	    public List<List<Integer>> permute2(int[] num) {
	        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
	        res.add(new ArrayList<Integer>());
	        for (int n : num) {
	            int size = res.size();
	            for (; size > 0; size--) {
	                List<Integer> r = res.pollFirst();
	                for (int i = 0; i <= r.size(); i++) {
	                    List<Integer> t = new ArrayList<Integer>(r);
	                    t.add(i, n);
	                    res.add(t);
	                }
	            }
	        }
	        return res;
	    }
}
