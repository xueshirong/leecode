package org.leecode;

public class Search_a_2D_Matrix {
	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
    	// write your code here
    	if(matrix == null || matrix.length == 0)
            return false;
        int s = 0;
        int e = matrix.length -1;
        int row = 0;
        int col = matrix[0].length - 1;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (matrix[mid][0] == target){
                return true;
            }else if (matrix[mid][0] > target){
                e = mid;
            }else{
                s = mid;
            }
        }
        if (matrix[e][0] <= target)
            row = e;
        else if (matrix[s][0] <= target)
            row = s;
        else
            return false;
        
        s = 0;
        e = col;
        while(s + 1 < e){
            int mid = s + (e - s)/2;
            if (matrix[row][mid] == target)
                return true;
            else if (matrix[row][mid] > target)
                e = mid;
            else
                s = mid;
        }
        if(matrix[row][s] == target)
            return true;
        else if (matrix[row][e] == target)
            return true;
        return false;
    }
}
