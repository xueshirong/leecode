package org.leecode;

public class Unique_Paths_II {
	//Follow up for "Unique Paths":
	//Now consider if some obstacles are added to the grids. 
	//How many unique paths would there be?
	//An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	/**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        if (m == 0 || n == 0)
            return 0;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 0)
                path[i][0] = 1;
            else
                break;
        }
        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 0)
                path[0][i] = 1;
            else
                break;
        }
        for(int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] == 1)
                    path[i][j] = 0;
                else
                    path[i][j] = path[i][j - 1] + path[i - 1][j];
            }
        }
        return path[m - 1][n - 1];
    }
}
