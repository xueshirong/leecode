package org.leecode;

import java.util.*;

public class Spiral_Matrix {
	//peel the outter loop
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0)
            return res;
        int count = 0, row = matrix.length, col = matrix[0].length;
        while (count * 2 < row && count * 2 < col){//key point
            for (int i = count; i < col - count; i++){//upper row
                res.add(matrix[count][i]);
            }
            for (int i = count + 1; i < row - count; i++){//right col
                res.add(matrix[i][col - count - 1]);
            }
            if (row - 2 * count == 1 || col - 2 * count == 1)//corner case: 1 row || 1 col
                break;
            for (int i = col - count - 2; i >= count; i--){//botom row
                res.add(matrix[row - count - 1][i]);
            }
            for (int i = row - count -2; i > count; i--){//left col
                res.add(matrix[i][count]);
            }
            count++;
        }
        return res;
    } 
    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        //corner case
        if (matrix == null || matrix.length == 0) return res;
        int layer = 0, m = matrix.length, n = matrix[0].length;
        while (2 * layer < m && 2 * layer < n){
            //upper row (the whole row)
            for (int j = layer; j < n - layer; j++){
                res.add(matrix[layer][j]);
            }
            //right col (except the 1st ele)
            for (int i = layer + 1; i < m - layer; i++){
                res.add(matrix[i][n - layer - 1]);
            }
            if (m - 2 * layer == 1 || n - 2 * layer == 1)
                break;
            //bottom row (except the last ele)
            for (int j = n - layer -2; j >= layer; j--){
                res.add(matrix[m - layer - 1][j]);
            }
            //left col (except the 1st ele)
            for (int i = m - layer - 2; i > layer; i--){
                res.add(matrix[i][layer]);
            }
            layer++;
        }
        return res;
    }
}
