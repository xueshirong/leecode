package org.leecode;

public class Longest_Common_Substring {
	public int longestCommonSubstring(String A, String B) {
		// write your code here
        int m = A.length();
        int n = B.length();
        if (A == null || m == 0 || B == null || n == 0)
            return 0;
        //state
        int[][] path = new int[m+1][n+1];
        //init
        
        //function
        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n+1; j++){
                if (A.charAt(i - 1) == B.charAt(j-1))
                    path[i][j] = path[i - 1][j-1] + 1;
            }
        }
        int max = 0;
        for (int i = 0; i < m + 1; i++){
            for (int j = 0; j < n+1; j++){
                max = Math.max(max, path[i][j]);
            }
        }
        return max;
    }
}
