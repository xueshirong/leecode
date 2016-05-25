package org.leecode;

import java.util.Hashtable;
import java.util.List;

public class Top_K_Frequent_Elements {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            if (ht.containsKey(nums[i])){
                ht.put(nums[i], ht.get(nums[i] + 1));
            }else{
                ht.put(nums[i], 1);
            }
        }
        return null;
    }
}
