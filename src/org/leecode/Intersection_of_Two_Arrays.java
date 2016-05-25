package org.leecode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Intersection_of_Two_Arrays {
	public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++){
            if (ht.containsValue(nums1[i])){
                continue;
            }
            ht.put(i, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            if (ht.containsValue(nums2[i]) && !list.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}