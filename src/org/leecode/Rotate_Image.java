package org.leecode;

public class Rotate_Image {
	//[解题思路]
    //首先对角线翻转一次，然后按y轴中线翻转一次。
	public void rotate(int[][] matrix) {
        for (int i =0; i < matrix.length; i++){//reverse left and right
            for (int j = i + 1; j < matrix.length; j++){//reverse by diagonal   j=i+1
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
            reverseRow(matrix, i);
        }
    }
    private void reverseRow(int[][] matrix, int rowNum){
        int l = 0;
        int r = matrix[rowNum].length - 1;
        while(l < r){
            int temp = matrix[rowNum][l];
            matrix[rowNum][l] = matrix[rowNum][r];
            matrix[rowNum][r] = temp;
            r--;
            l++;
        }
    }
}
