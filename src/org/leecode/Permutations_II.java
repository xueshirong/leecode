package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II {
	public static void main(String[] args){
		permuteUnique3(new int[]{1,1,2});
	}
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
    //..............
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);// key point to sort the array first
        List<Integer> path = new ArrayList<Integer>();
        boolean[] vis = new boolean[nums.length];
        helper1(nums, path, vis, res);
        return res;
    }
    private static void helper1(int[] nums, List<Integer> path, boolean[] vis, List<List<Integer>> res){
        if (path.size() == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (vis[i])
                continue;
            else if (i != 0 && nums[i] == nums[i - 1])
                continue;
            vis[i]= true;
            path.add(nums[i]);
            helper1(nums, path, vis, res);
            path.remove(path.size() - 1);
            vis[i] = false;
        }
        
    }
    
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);// key point to sort the array first
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        for ( int i = 0; i < visited.length; i++){
            visited[i] = false;
        }
        helper2(visited, res, list, nums);
        return res;
    }
    private void helper2(boolean[] visited, List<List<Integer>> res, ArrayList<Integer> list, int[] nums){
        if (list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }        
        for (int i = 0; i < nums.length; i++){
            if (visited[i] == true || (i != 0 && nums[i] == nums[i-1] && visited[i-1] == false))
                continue;
           
            visited[i] = true;
            list.add(nums[i]);
            helper2(visited, res, list, nums);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
        
    }

    //-------------------
    public static List<List<Integer>> permuteUnique3(int[] nums){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        //corner case
        if (nums == null)
            return res;
        if (nums.length == 0){
            res.add(new ArrayList<Integer>());
            return res;
        }
        Arrays.sort(nums);// key point to sort the array first
        List<Integer> path = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++)
            visited[i] = false;
        helper3(nums, path, res, visited);
        return res;
    }
    private static void helper3(int[] nums, 
                        List<Integer> path, 
                        List<List<Integer>> res, 
                        boolean[] visited){
        if (path.size() == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++){
            if (visited[i])
                continue;
            else if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;
            
            visited[i] = true;
            path.add(nums[i]);
            helper3(nums, path, res, visited);
            path.remove(path.size() - 1);
            visited[i] = false;
        }
    }
}
