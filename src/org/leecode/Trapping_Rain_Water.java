package org.leecode;

public class Trapping_Rain_Water {
	/*
	 * 思路2：two pointers解法
		对任意位置i，在i上的积水，由左右两边最高的bar：A[left] = max{A[j], j<i}, A[right] = max{A[j], j>i}决定。
		定义Hmin = min(A[left], A[right])，则积水量Si为：
		Hmin <= A[i]时，Si = 0
		Hmin > A[i]时，Si = Hmin - A[i]
	 */
	public int trap(int[] A) {  
        // special case  
        if (A == null || A.length == 0) {  
            return 0;  
        }           
        int i, max, volume, left[] = new int[A.length], right[] = new int[A.length];  
        // from left to right  
        for (left[0] = A[0], i = 1, max = A[0]; i < A.length; i++) {  
            if (A[i] < max) {  
                left[i] = max;  
            } else {  
                left[i] = A[i];  
                max = A[i];  
            }  
        }   
        // from right to left  
        for (right[A.length - 1] = A[A.length - 1], i = A.length - 2, max = A[A.length - 1]; i >= 0; i--) {  
            if (A[i] < max) {  
                right[i] = max;  
            } else {  
                right[i] = A[i];  
                max = A[i];  
            }  
        }  
        // trapped water  
        for (volume = 0, i = 1; i <= A.length - 2; i++) {  
            int tmp = Math.min(left[i], right[i]) - A[i];  
            if (tmp > 0) {  
                volume += tmp;  
            }  
        }  
  
        return volume;  
    }  
	//solution 2
	public int trap2(int[] height) {
        //corner case
        if (height == null || height.length == 0)
            return 0;
        //from left to right, set height[i]'s max left value
        int[] left = new int[height.length];
        left[0] = height[0];
        int max = height[0];
        for (int i = 1; i < height.length; i++){
            if (height[i] > max)
                max = height[i];
            left[i] = max;
        }
        
        //from right to left, set height[i]'s max right value
        int[] right = new int[height.length];
        max = height[height.length - 1];;
        right[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i > -1; i--){
            if (height[i] > max)
                max = height[i];
            right[i] = max;
        }
        
        //cal volume
        int volume = 0;
        for(int i = 1; i < height.length - 1; i++){
            int temp = Math.min(left[i], right[i]) - height[i];
            if (temp > 0)
                volume += temp;
        }
        return volume;
    }
}
