package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
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
}
