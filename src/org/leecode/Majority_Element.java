package org.leecode;

import java.util.HashMap;
import java.util.Iterator;

public class Majority_Element {
	public int majorityElement(int[] nums) {
		if (nums.length == 1) return nums[0];
        int result = 0;
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i <nums.length; i++){
            if (hmap.containsKey(nums[i])){
            	int count = hmap.get(nums[i]) + 1;
            	if (count > nums.length/2){
            		result = nums[i];  
            		break;
            	}
            	hmap.put(nums[i], hmap.get(nums[i]) + 1);            	
            }
            else
            	hmap.put(nums[i], 1);           
            
        }
        return result;
    }
	 public int majorityElement1(int[] nums) {
	        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
	        for (int i = 0; i <nums.length; i++){
	            Integer valInt = hmap.get(nums[i]);
	            
	            if (valInt == null){
	                hmap.put(nums[i], 1);
	            }
	            else{                
	                hmap.put(nums[i], valInt + 1);
	            }
	        }
	        
	        Iterator<Integer> it = hmap.keySet().iterator();
	        int count = 0;
	        int tmpNum = 0;
	        
	        while (it.hasNext()){
	            Integer key = it.next();
	            Integer val = hmap.get(key);
	            if (val > count){
	                count = val;
	                tmpNum = key;
	            }
	        }
	        return tmpNum;
	    }
}
