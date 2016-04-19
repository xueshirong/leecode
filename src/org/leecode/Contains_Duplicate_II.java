package org.leecode;

import java.util.HashSet;

public class Contains_Duplicate_II {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashSet<Integer> hs = new  HashSet<Integer>();
        for (int i = 0; i < nums.length; i++){
            if (i > k)//slides window
                hs.remove(nums[i - k -1]);
                
            if (!hs.add(nums[i]))//judge whether has the duplicate value
                return true;
        }
        return false;
    }
}
