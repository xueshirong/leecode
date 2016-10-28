package org.leecode;

public class Search_in_Rotated_Sorted_Array_II {
	/*Follow up for Search in Rotated Sorted Array:
	  What if duplicates are allowed?
	  Would this affect the run-time complexity? How and why?
      Write a function to determine if a given target is in the array.*/
	/** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0)
            return false;
            
        int s = 0, e = A.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (A[mid] == target)
                return true;
                
            if (A[s] == A[mid] && A[mid] == A[e]){
                s++; e--;
            }
            else if (A[s] <= A[mid]){
                if (A[s] <= target && target <= A[mid])
                    e = mid;
                else
                    s = mid;
            }
            else{
                if (A[mid] <= target && target <= A[e])
                    s = mid;
                else
                    e = mid;
            }
        }
        
        if (A[s] == target || A[e] == target)
            return true;
        return false;
    }
}
