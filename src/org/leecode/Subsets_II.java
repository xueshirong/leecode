package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subsets_II {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if (i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            list.add(nums[i]);
            subsetHelper(result, list, nums, i + 1);
            list.remove(list.size() -1);
        }
    }
    //From Jiu Zhang
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper2(res, list, nums, 0);
        return res;
    }
    private void helper2(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i -1])//if duplicates val, go to next one
                continue;
            list.add(nums[i]);
            helper2(res,list, nums, i+1);
            list.remove(list.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup3(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);//key point is to sort the array
        ArrayList<Integer> set = new ArrayList<Integer>();
        helper3(res, set, nums, 0);
        return res;
    }
    private void helper3(List<List<Integer>> res, List<Integer> list, int[] nums, int pos){
        res.add(new ArrayList<Integer>(list));
        
        for(int i = pos; i < nums.length; i++){
            if (i != pos && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            helper3(res, list, nums, i+1);
            list.remove(list.size() - 1);
        }
    }
    
    //solution 4 
    public ArrayList<ArrayList<Integer>> subsetsWithDup4(int[] nums) {
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<Integer>();
        helper(res,list,nums,0);
        return res;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> rst, List<Integer> list,
    int[] nums, int pos) {
        if (!rst.contains(list))
            rst.add( new ArrayList(list));
        for ( int i = pos; i < nums.length; i++){
            /*if ( i != pos && S.get(i) == S.get(i-1)){
                continue;
            }*/
  
            list.add(nums[i]);
            helper(rst,list,nums,i+1);
            list.remove(list.size()-1);
        }
    }
}
