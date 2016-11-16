package org.leecode;

public class Distinct_Subsequences {
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
}
