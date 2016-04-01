package org.leecode;

public class Merge_Sorted_Array {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        m = m -1;
        n = n -1;
        int index = length - 1;
        for(; index > -1; index--){
        	if (m < 0 || n < 0)
                break;
        	if (nums1[m] > nums2[n]){
                nums1[index] = nums1[m];
                m--;
            }else{
                nums1[index] = nums2[n];
                n--;
            }
        }
        if (n > -1){
        	for (int i = index; i > -1; i--){
        		nums1[index] = nums2[n];
        		n--;
        	}
        }
	}
}
