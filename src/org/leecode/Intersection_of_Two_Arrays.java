package org.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
	//---------------------------------
	/**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        //corner case
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];
        //Arrays.sort(nums1);//this 2 sort methods will cause "Time Limit Exceeded" error
        //Arrays.sort(nums2);
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(int val : nums1){
            if (set1.contains(val))
                continue;
            set1.add(val);
        }
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int val : nums2){
            if (set1.contains(val) && !set2.contains(val))
                set2.add(val);
        }
        
        int[] res = new int[set2.size()];
        int index = 0;
        for (int val : set2){
            res[index] = val;
            index++;
        }
        return res;
    }
}