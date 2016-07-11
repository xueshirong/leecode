package org.leecode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.stream.IntStream;

public class Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
		Hashtable<Integer, Integer> hb = new Hashtable<Integer, Integer>();
        int[] result = new int[]{};
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++){
            int key = nums1[i];
            if (hb.containsKey(key)){
                hb.put(key,hb.get(key)+1);
            }else{
                hb.put(key,1);
            }
        }
        for (int j = 0; j < nums2.length; j++){
            int key = nums2[j];
            if (hb.containsKey(key)){
                res.add(key);
                if (hb.get(key) > 1){
                    hb.put(key, hb.get(key)-1);
                }else{
                    hb.remove(key);
                }
            }
        }
        result = new int[res.size()];
        for(int k = 0; k < res.size(); k++){
        	result[k] = Integer.parseInt(res.get(k).toString());
        }
        
        return result;
    }
}
