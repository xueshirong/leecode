package org.leecode;

public class Maximal_Square {
	public int maximalSquare(char[][] matrix) {
        //corner case
        if (matrix == null || matrix.length == 0)
            return 0;
        //define dp array
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        
        for (int i = 0; i < m; i++){//set 1st column
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < n; i++){//set 1st row
            dp[0][i] = matrix[0][i] - '0';
        }
        
        //dp[i][j] = min(dp[i -1][j], dp[i][j - 1], dp[i - 1][j -1]) + 1
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (matrix[i][j] - '0' == 1)
                    dp[i][j] = Math.min(Math.min(dp[i -1][j], dp[i][j - 1]), dp[i - 1][j -1]) + 1;
            }
        }
        //get the max count
        int count = 0;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                count = Math.max(dp[i][j], count);
            }
        }
        return count * count;
    }
}
