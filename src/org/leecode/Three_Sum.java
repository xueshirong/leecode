package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Three_Sum {
	//From Jiu Zhang
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1])//remove duplicate nums
                continue;
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if (nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    if (set.add(temp))//use hashset to remove duplicate array
                        res.add(temp);
                    right--;
                    left++;
                }else if (nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return res;
    }
}
