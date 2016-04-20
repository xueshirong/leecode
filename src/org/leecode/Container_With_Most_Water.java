package org.leecode;

public class Container_With_Most_Water {
	public int maxArea(int[] height) {
        int v = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i; j < height.length; j++){
                int h = Math.min(height[j], height[i]);
                int l = Math.abs(height[i] - height[j]);
                v = Math.max(v, h * l);
            }
        }
        return v;
    }
	
	public int maxArea2(int[] height) {
		int v = 0;
        int end = height.length - 1;
        int start = 0;
        while (start < end){
            v = Math.max(Math.min(height[start], height[end]) * (end - start), v);
            if (height[start] < height[end]){
                start++;
            }else{
                end++;   
            }
        }
        return v;
    }
}
