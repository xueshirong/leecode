package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Find_All_Numbers_Disappeared_in_an_Array {
	public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= nums.length; i++)
            set.add(i);
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            if (set.add(nums[i]) == false)
                set.remove(nums[i]);
        }
        res = new ArrayList<Integer>(set);
        return res;
    }
	//solution 2
    //遍历一遍该数组，将遍历过的数字 
    //对应的位置的数字置为负数，然后看哪个位置的数字为正的，那么该位的数字就是没有出现过的
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0)
            return res;
        
        for (int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;//key point. Math.abs
            if (nums[index] > 0)
                nums[index] = -1 * nums[index];
        }
        
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0)
                res.add(i + 1);
        }
        
        return res;
    }
}
