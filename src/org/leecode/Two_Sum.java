package org.leecode;

import java.util.HashMap;
import java.util.Map;

public class Two_Sum {
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] ==  target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
	public int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
	
	public int[] twoSum3(int[] nums, int target) {
        if (nums.length < 2) return null;
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            if (map.get(temp) == null)
                map.put(nums[i], i);
            else{
                res[0] = i;
                res[1] = map.get(temp);
                return res;
            }
        }
        return null;
    }
	
}
