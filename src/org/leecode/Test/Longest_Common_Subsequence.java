package org.leecode.Test;

public class Longest_Common_Subsequence {
	//Given two strings, find the longest common subsequence (LCS).
	//Your code should return the length of LCS.
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
	public int longestCommonSubsequence(String A, String B) {
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
                path[i][j] =  Math.max(path[i][j-1], path[i-1][j]);//key point
                if (A.charAt(i - 1) == B.charAt(j-1))
                    path[i][j] = path[i - 1][j-1] + 1;
            }
        }
        
        return path[m][n];
    }
	
	/**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence2(String A, String B) {
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
                if (A.charAt(i - 1) == B.charAt(j-1)){
                    path[i][j] = Math.max(path[i - 1][j-1] + 1, path[i - 1][j]);
                    path[i][j] = Math.max(path[i][j], path[i][j-1]);
                }
                else{
                    path[i][j] = Math.max(path[i - 1][j-1], path[i - 1][j]);
                    path[i][j] = Math.max(path[i][j], path[i][j-1]);
                }
            }
        }
        
        return path[m][n];
    }
}
