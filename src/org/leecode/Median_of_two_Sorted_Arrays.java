package org.leecode;

import java.util.ArrayList;

public class Median_of_two_Sorted_Arrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
		//corner case 
        /*if (A == null && B == null)
            return 0.0;*/
        ArrayList<Integer> res = new ArrayList<Integer>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length){
            if (A[i] < B[j]){
                res.add(A[i]);
                i++;
            }
            else if (A[i] > B[j]){
                res.add(B[j]);
                j++;
            }
            else{
                res.add(A[i]);
                res.add(B[j]);
                i++;
                j++;
            }
        }
        if (i != A.length){
            for (int k = i; k < A.length; k++){
                res.add(A[k]);
            }
        }
        if (j != B.length){
            for (int k = j; k < B.length; k++){
                res.add(B[k]);
            }
        }
        if (res.size()%2 != 0)
            return res.get(res.size()/2);
        else
            return (res.get(res.size()/2 - 1) + res.get(res.size()/2))/2.0;
    }
}
