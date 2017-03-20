package org.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Frog_Jump {
	HashMap<Integer, HashSet<Integer> > dp = new HashMap<Integer, HashSet<Integer> >();  
    public boolean canCross(int[] stones) {  
        int n = stones.length;  
        for(int i=0; i<n; i++) {  
            dp.put(stones[i], new HashSet<Integer>());  
        }  
        dp.get(0).add(0);  
        for(int i=0; i<n; i++) {  
            for(int step: dp.get(stones[i])) {  
                if(step > 0) {  
                    if(step > 1) {  
                        HashSet<Integer> set = dp.get(stones[i] + step - 1);  
                        if(set != null) {  
                            set.add(step - 1);  
                        }  
                    }  
                    HashSet<Integer> set = dp.get(stones[i] + step);  
                    if(set != null) {  
                        set.add(step);  
                    }  
                }  
                HashSet<Integer> set = dp.get(stones[i] + step + 1);  
                if(set != null) {  
                    set.add(step + 1);  
                }  
            }  
        }  
        return dp.get(stones[n-1]).size() > 0;  
    } 
    
    public boolean canCross1(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        Map<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
        for (int i : stones){
            map.put(i, new HashSet<Integer>());
        }
        map.get(0).add(0);
        for (int i = 0; i < stones.length; i++){
            int pos = stones[i];
            for (int step : map.get(stones[i])){
                for (int s = step - 1; s <= step + 1; s++){
                    if (s < 1)  continue;
                    int nextPos = pos + s;
                   /* if (nextPos >= stones[stones.length - 1])
                        return true;*/
                    HashSet set = map.get(nextPos);
                    if (set != null)
                        set.add(s);
                }
            }
        }
        if (map.get(stones[stones.length - 1]).size() > 0)
            return true;
        return false;
    }
    
    //DFS (超时)
    public boolean canCross2(int[] stones) {
        if (stones == null || stones.length == 0)
            return true;
        return helper(stones, 1, 1);
    }
    boolean helper(int[] nums, int index, int step){
        if (index == nums.length - 1)
            return true;
        boolean pass = false;
        for (int j = index + 1; j < nums.length; j++){
            if (nums[j] >= nums[index] + step - 1 && nums[j] <= nums[index] + step + 1){
                pass = pass || helper(nums, j, nums[j] - nums[index]);
            }
        }
        return pass;
    }
}
