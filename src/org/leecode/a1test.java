package org.leecode;

import java.util.Stack;

public class a1test {
	public static void main(String[] args){
        int[] res = find(new int[]{3, 9, 11, 1,2});
        for (int i : res)
            System.out.print(i + " ");
    }
	//数组， 输出是右边第一个比他大的数字
    private static int[] find(int[] nums){
        //corncer case
        if (nums == null || nums.length == 0)
            return nums;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i > -1; i--){
            if (stack.isEmpty()){
                stack.add(-1);
            }else {
                if (nums[i] < nums[i+1])
                    stack.add(nums[i+1]);
                else if (nums[i] < stack.peek()){
                    stack.add(stack.peek());
                }else{
                    stack.add(-1);
                }
            }
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            res[i] = stack.pop();
        return res;
    }
}
