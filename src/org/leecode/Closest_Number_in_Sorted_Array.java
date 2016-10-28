package org.leecode;

public class Closest_Number_in_Sorted_Array {
	/**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int closestNumber(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0)
            return -1;
        int s = 0, e = A.length - 1;
        int dif = Integer.MAX_VALUE;
        int index = -1;
        while(s + 1 <  e){
            int mid = s + (e - s)/2;
            int temp = A[mid] - target;
            if (temp == 0){
                return mid;
            }else if (temp > 0)
                e = mid;
            else
                s = mid;
            
            if (Math.abs(temp) < dif){
                index = mid;
                dif = Math.abs(temp);
            }
        }
        if (Math.abs(A[s]-target) < dif)
            index =s;
        else if (Math.abs(A[e]-target) < dif)
            index = e;
            
        return index;
    }
}
