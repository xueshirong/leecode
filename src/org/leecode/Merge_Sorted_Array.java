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
	//From Jiu Zhang
	public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1, j = n - 1;
        while(i > -1 && j > -1){//from back to front, compare 2 values
            if (nums1[i] > nums2[j]){//set bigger one to the end of nums1
                nums1[index] =  nums1[i];
                i--;
            }else{
                nums1[index] =  nums2[j];
                j--;
            }
            index--;
        }
        while(i > -1){
            nums1[index] =  nums1[i];
            i--;
            index--;
        }
         while(j > -1){
            nums1[index] =  nums2[j];
            j--;
            index--;
        }
    }
}
