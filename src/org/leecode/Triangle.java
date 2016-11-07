package org.leecode;

public class Triangle {
	//Given a triangle, find the minimum path sum from top to bottom. 
	//Each step you may move to adjacent numbers on the row below.
	/**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
    	// corner
        if (triangle == null || triangle.length == 0 || triangle[0].length == 0)
            return 0;
        
        int m = triangle.length, n = triangle.length;
        int[][] path = new int[m][n];
        path[0][0] = triangle[0][0];
        for(int i = 1; i < m; i++){//init path
            path[i][0] = path[i - 1][0] + triangle[i][0];
            path[i][i] = path[i - 1][i - 1] + triangle[i][i];
        }
        
        //function
        for (int i = 1; i < m; i++){
            for(int j = 1; j < m; j++){
                if (i <= j)
                    continue;
                path[i][j] = Math.min(path[i - 1][j - 1], path[i - 1][j]) + triangle[i][j];
            }
        }
        
        //find minimum value
        int min = path[m - 1][0];
        for (int i = 1; i < n; i++){
            min = Math.min(min, path[m - 1][i]);
        }
        return min;
    }
}
