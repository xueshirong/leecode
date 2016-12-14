package org.leecode;

public class Largest_Rectangle_in_Histogram {
	/**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
    	//corner case
        if (height == null || height.length == 0)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        for (int i = 0; i < height.length; i++){
            int r = i;
            while (r < height.length && height[r] >= height[i]){
                r++;
            }
            right[i] = r - 1;
        }
        
        for (int i = height.length - 1; i > -1; i--){
            int l = i;
            while (l > -1 && height[i] <= height[l]){
                l--;
            }
            left[i] = l + 1;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++){
            int temp = (right[i] - left[i] + 1) * height[i];
            res = Math.max(res, temp);
        }
        return res;
    }
    
    public int largestRectangleArea2(int[] height) {
    	//corner case
        if (height == null || height.length == 0)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        
        right[height.length - 1] =  height.length - 1;
        for (int i = height.length - 2; i > -1; i--){
            int r = i + 1;
            while (r < height.length && height[i] <= height[r]){
                r = right[r] + 1;//reuse previous index's val, no need loop all previous val
            }
            right[i] = r - 1;
        }
        
        left[0] = 0;
        for (int i = 1; i < height.length; i++){
            int l = i - 1;
            while (l > -1 && height[i] <= height[l]){
                l = left[l] - 1;
            }
            left[i] = l + 1;
        }
        int res = 0;
        for (int i = 0; i < height.length; i++){
            res = Math.max(res,  (right[i] - left[i] + 1) * height[i]);
        }
        return res;
    }
}
