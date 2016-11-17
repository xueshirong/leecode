package org.leecode;

public class Distinct_Subsequences {
	//Given a string S and a string T, count the number of distinct subsequences of T in S.

	//A subsequence of a string is a new string which is formed from the original string 
	//by deleting some (can be none) of the characters without disturbing the relative positions 
	//of the remaining characters. 
	//(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
	/**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        //state
        int m = S.length();
        int n = T.length();
        int[][] path = new int[m+1][n+1];
        //initial
        for (int i = 0; i < m + 1; i++){
            path[i][0] = 1;
        }
        //function
        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){    
            	path[i][j] = path[i -1][j]; 
                if (S.charAt(i - 1) == T.charAt(j - 1)){
                    path[i][j] += path[i - 1][j - 1];
                }
            }
        }
        return path[m][n];
    }
    
    public int numDistinct2(String S, String T) {
        // corner test
        if (S == null || S.equals("") || T == null)
            return 0;
        
        //state
        int m = S.length();
        int n = T.length();
        int[][] path = new int[m + 1][n + 1];
        
        //init
        for (int i = 0; i < m + 1; i++){
            path[i][0] = 1;
        }
        
        //function
        for (int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                path[i][j] = path[i - 1][j];
                if (S.charAt(i - 1) == T.charAt(j -1))
                    path[i][j] = path[i - 1][j] + path[i -1][j - 1];
            }
        }
        return path[m][n];
    }
}
