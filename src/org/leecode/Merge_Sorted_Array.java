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
	//-------------------
	//Thought: from end of A and B, compare element, put larger one to the end of A.
	//Given two sorted integer arrays A and B, merge B into A as one sorted array.
	// Notice
	//You may assume that A has enough space (size that is greater or equal to m + n) to 
	//hold additional elements from B. The number of elements initialized in A and B are m and n 
	//respectively.
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        //corner case
        if (B == null || n == 0)
            return;
        while (m > 0 && n > 0){
            if (A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
        if (n > 0){
            for(int i = 0; i < n; i++){
                A[i] = B[i];
            }
        }
    }
}
