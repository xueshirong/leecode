package org.leecode;

public class Set_Matrix_Zeroes {
	//O(mn). use extra matrix
    public void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] nums = new int[row][col];
        //copy
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                nums[i][j] = matrix[i][j];
            }
        }
        //change 0
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] == 0){
                    change(nums, i, j);
                }
            }
        }
        matrix = nums;
    }
    void change(int[][] nums, int i, int j){
        int row = nums.length;
        int col = nums[0].length;
        for (int k = 0; k < row; k++){
            nums[k][j] = 0;
        }
        for (int k = 0; k < col; k++){
            nums[i][k] = 0;
        }
    }
    
    //...O(m+n). use extra int[]
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] m = new boolean[row];
        boolean[] n = new boolean[col];
        for (int i = 0; i < row; i++){//record 0' position to m and n
            for (int j = 0; j < col; j++){
                if (matrix[i][j] != 0)
                    continue;
                m[i] = true;
                n[j] = true;
            }
        }
        for (int i = 0; i < row; i++){//change all row
            if (m[i]){
                for (int j = 0; j < col; j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < col; j++){//change all col
            if (n[j]){
                for (int i = 0; i < row; i++){
                    matrix[i][j] = 0;
                }
            }
        }
    }
    
  //...O(1)把有0的元素映射到首行和首列
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean isrow = false, iscol = false;
        for (int i = 0; i< row; i++){//check 1st col
            if (matrix[i][0] == 0){
                iscol = true;
                break;
            }
        }
        for (int i = 0; i< col; i++){//check 1st row
            if (matrix[0][i] == 0){
                isrow = true;
                break;
            }
        }
        for (int i = 1; i< row; i++){//set 1st col and row
            for (int j = 1; j< col; j++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
                
            }
        }
        for (int i = 1; i< row; i++){//set all cells except 1
            for (int j = 1; j< col; j++){
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }
        if (iscol){//set 1st col
            for (int i = 0; i< row; i++){//set 1st col
                matrix[i][0] = 0;
            }
        }
        if (isrow){//set 1st row
            for (int i = 0; i< col; i++){//set 1st row
                matrix[0][i] = 0;
            }
        }
    }
}
