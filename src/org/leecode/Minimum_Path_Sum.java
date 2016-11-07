package org.leecode;

public class Minimum_Path_Sum {
	//Given a m x n grid filled with non-negative numbers, 
	//find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	/**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0 || n == 0)
            return 0;
        int[][] path = new int[m][n];
        //init 1st column
        for (int i = 0; i < m; i++){
            if (i == 0)
                 path[i][0] = grid[i][0];
            else
                path[i][0] = path[i - 1][0] + grid[i][0];
        }
        //init 1st row
        for (int j = 0; j < n; j++){
            if (j == 0)
                path[0][j] = grid[0][j];
            else
                path[0][j] = path[0][j - 1] + grid[0][j];
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                path[i][j] =  Math.min(path[i - 1][j], path[i][j-1]) + grid[i][j];
            }
        }
        return path[m - 1][n - 1];
    }
}