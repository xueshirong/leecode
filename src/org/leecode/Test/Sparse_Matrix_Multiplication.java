package org.leecode.Test;

public class Sparse_Matrix_Multiplication {
	//From Jiu Zhang
    //矩阵相乘就是所有的k，A(i,k) * B(k,j) = C(i,j) ，稀疏矩阵就是 有很多0，
    //为了提高速度也就是如果 A(i,k) 或者B(k,j), k 从0到length，如果有0，那么这个计算就不进行了
    public int[][] multiply(int[][] A, int[][] B) {
        //corner case
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[A.length][B[0].length];
        int aRow = A.length, aCol = A[0].length, bCol = B[0].length;
        int[][] res = new int[aRow][bCol];
        for (int i = 0; i < aRow; i++){//i
            for (int k = 0; k < aCol; k++){//k
                if (A[i][k] != 0){//key point: if 
                    for (int j = 0; j < bCol; j++){//j
                        res[i][j] += A[i][k] * B[k][j];//key point
                    }
                }
            }
        }
        return res;
    }
    
    //超时的常规做法
    public int[][] multiply1(int[][] A, int[][] B) {
        //corner case
        if (A == null || A.length == 0 || B == null || B.length == 0)
            return new int[A.length][B[0].length];
        int aRow = A.length, aCol = A[0].length, bCol = B[0].length;
        int[][] res = new int[aRow][bCol];
        for (int i = 0; i < aRow; i++){
            for (int j = 0; j < bCol; j++){
                for (int k = 0; k < aCol; k++){
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
}
