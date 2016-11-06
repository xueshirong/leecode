package org.leecode;

public class Unique_Paths {
	//A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	//The robot can only move either down or right at any point in time. 
	//The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	//How many possible unique paths are there?
	/**
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++){
            path[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++){
            path[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++){//index is from 1
            for (int j = 1; j < n; j++){//index is from 1
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m - 1][n  -1];
    }
}
