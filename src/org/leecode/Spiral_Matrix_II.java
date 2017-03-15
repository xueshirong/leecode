package org.leecode;

public class Spiral_Matrix_II {
	public int[][] generateMatrix(int n) {
        //corner case
        int[][] res = new int[n][n];
        int val = 1;
        int layer = 0;
        while (val < Math.pow(n,2) + 1){
            for (int j = layer; j < n - layer; j++){
                res[layer][j] = val;
                val++;
            }
            for (int i = layer + 1; i < n - layer; i++){
                res[i][n - layer - 1] = val;
                val++;
            }
            if (n - 2 * layer == 1) break;
            for (int j = n - layer - 2; j >= layer; j--){
                res[n - layer - 1][j] = val;
                val++;
            }
            for (int i = n - layer - 2; i > layer; i--){
                res[i][layer] = val;
                val++;
            }
            layer++;
        }
        return res;
    }
}
