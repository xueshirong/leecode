package org.leecode;

public class Total_Occurrence_of_Target {
	/*Given a target number and an integer array sorted in ascending order. 
	Find the total number of occurrences of target in the array.*/
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0)
            return 0;
        int s = 0, e = A.length - 1;
        int[] bound = new int[2];
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (A[mid] >= target)
                e = mid;
            else
                s = mid;
        }
        if(A[s] == target)
            bound[0] = s;
        else if (A[e] == target)
            bound[0] = e;
        else
            return 0;
        
        s = 0; e = A.length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (A[mid] <= target)
                s = mid;
            else
                e = mid;
        }
        if(A[e] == target)
            bound[1] = e;
        else
            bound[1] = s;
        return bound[1] - bound[0] + 1;
    }
}
