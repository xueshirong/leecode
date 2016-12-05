package org.leecode;

import java.util.Arrays;
import java.util.Comparator;
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
	
	//----------------------------------------------two pointer
	class pair{
        int val;
        int index;
        public pair(int v, int i){
            val = v;
            index = i;
        }
    }
    public int[] twoSum4(int[] numbers, int target) {
        int[] res = new int[2];
        //corner case
        if (numbers == null || numbers.length < 2)
            return res;
        pair[] p = new pair[numbers.length];
        for (int i = 0; i < numbers.length; i++){
            p[i] =  new pair(numbers[i], i + 1);
        }
        Arrays.sort(p, new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.val - b.val;
            }
        });
        int l = 0, r = numbers.length - 1;
        while (l < r){
            int sum = p[l].val + p[r].val;
            if (sum == target){
            	res[0] = Math.min(p[l].index, p[r].index);
                res[1] = Math.max(p[l].index, p[r].index);
                return res;
            }else if(sum < target){
                l++;
            }else{
                r--;
            }
        }
        return res;
    }
	
}
