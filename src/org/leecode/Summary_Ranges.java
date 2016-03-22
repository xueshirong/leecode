package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>(); 
        if (nums.length == 0)
            return result;
        
        for(int i = 0; i < nums.length; i++){
            temp.add(nums[i]);
            if (i != nums.length - 1 && nums[i] + 1 == nums[i + 1])
                temp.add(nums[i + 1]);
            else{
                String str = String.valueOf(temp.get(0));
                if(temp.size() > 1) 
                    str = String.valueOf(temp.get(0)) + "->" + String.valueOf(temp.get(temp.size() - 1));
                result.add(str);
                temp.clear();
            }
        }
        return result;
    }
}
