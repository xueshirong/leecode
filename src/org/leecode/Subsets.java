package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int pos = 0;
        subsetHelper(result, list, nums, pos);
        return result;
    }
     public void subsetHelper(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int pos){
        result.add(new ArrayList<Integer>(list));
        
        for (int i = pos; i < nums.length; i++){
            list.add(nums[i]);
            subsetHelper(result, list, nums, i + 1);
            list.remove(list.size() -1);
        }
    }
    //From Jiu Zhang
    public List<List<Integer>> subsets2(int[] nums) {
         List<List<Integer>> res = new ArrayList<List<Integer>>();
         if (nums == null || nums.length == 0)
             return res;
         List<Integer> list = new ArrayList<Integer>();
         Arrays.sort(nums);
         helper2(res, list,nums, 0);
         return res;
    }    
     private void helper2(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
         res.add(new ArrayList<Integer>(list));
         for (int i = pos; i < nums.length; i++){
             list.add(nums[i]);
             helper2(res, list, nums, i + 1);//i + 1
             list.remove(list.size() - 1);
         }
     }
}
