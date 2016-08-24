package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Four_Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3)
            return res;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int k = 0; k < nums.length; k++){
            if (k != 0 && nums[k] == nums[k - 1])
                    continue;
            for (int i = k + 1; i < nums.length; i++){
                if (i != k +1 && nums[i] == nums[i - 1])
                    continue;
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    if (nums[k] + nums[i] + nums[left] + nums[right] == target){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[k]);
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        if (set.add(temp))
                            res.add(temp);
                        right--;
                        left++;
                    }else if (nums[k] + nums[i] + nums[left] + nums[right] > target){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return res;
    }
}
