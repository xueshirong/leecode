package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	//From Jiu Zhang
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);// key point to sort the array first
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        helper(visited,res, list, nums);
        return res;
    }
	
    private void helper(boolean[] visited, List<List<Integer>> res, ArrayList<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if (visited[i])
                continue;
            if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
            {//if (i-1) = i and (i-1) is not visited, then should return to visit i first
                continue;
            }
            /*
            	上面的判断主要是为了去除重复元素影响。
            	比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            	我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            	当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            	不应该让后面的2使用。
            */
            visited[i] = true;
            list.add(nums[i]);
            helper(visited, res, list, nums);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
