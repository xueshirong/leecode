package org.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I {
	//brute force O(mn)
    public int[] nextGreaterElement1(int[] findNums, int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for (int val : findNums){
            int index = -1;
            for (int i = 0; i < nums.length; i++){
                if (nums[i] == val){
                    index = i;
                    break;
                }
            }
            if (index < 0){
                res.add(-1);
                continue;
            }
            boolean find = false;
            for (int i = index + 1; i < nums.length; i++){
                if (nums[i] > val){
                    res.add(nums[i]);
                    find = true;
                    break;
                }
            }
            if (!find)
                res.add(-1);
        }
        int [] n = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            n[i] = res.get(i);
        return n;
    }
    
  //brute force O(mn) use map to save val and index first. when loop findNums, it is easy to get index
    public int[] nextGreaterElement2(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++){
            int j = map.get(findNums[i]);
            for (j = j + 1; j < nums.length; j++){
                if (nums[j] > findNums[i])
                    break;
            }
            if (j < nums.length)
                res[i] = nums[j];
            else
                res[i] = -1;
        }
        return res;
    }
    //O(n) use map stack to save paire val to map. In the map, save val and next bigger val together.
    //我们可以用栈来维护一个递减的序列，里面存储的数组左边未找到NGE的元素，初始时只包含第一个元素。
    //我们可以假定栈顶就是最小的元素，因此可以用从栈顶top开始和后面的元素next比较。
    //如果top<next则说明，找到了top的NGE，可以弹出栈。然后继续比较栈顶元素top和next，直到栈为空或 next <= top。
    //然后把next加入栈，以便查找next的NGE。由于只有一次遍历，时间复杂度为O(n)。
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int val : nums){//循环nums中每个val,存入stack。如果下一个val大于peek，说明找到一对值。如[1=3]
            while (!stack.isEmpty() && stack.peek() < val){//key point: 用while循环stack中所有的值
                map.put(stack.pop(), val);
            }
            stack.add(val);
        }
        int[] res = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++){
            int val = findNums[i];
            if (map.containsKey(val))
                res[i] = map.get(val);
            else
                res[i] = -1;
        }
        return res;
    }
}
