package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Square_Array {
	public static void main(String[] args){
        List<Integer> res = sorts(new int[]{-3,-1,2,4});
        System.out.print(res);
    }
    private static List<Integer> sorts(int[] nums){
        int i = 0, j = nums.length - 1;
        List<Integer> list = new ArrayList<Integer>();
        while(i <= j){
            if (nums[i] * nums[i] > nums[j] * nums[j]){
                list.add(0, nums[i] * nums[i]);
                i++;
            }else{
                list.add(0, nums[j] * nums[j]);
                j--;
            }
        }
        //res = list.toArray(new int[0]);
        return list;
    }
}
