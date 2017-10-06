package org.leecode;

public class Search_a_2D_Matrix {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		searchMatrix1(matrix, 7);
		
	}
	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
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

    // Binary Search Once
    public static boolean searchMatrix1(int[][] matrix, int target) {
    	if (matrix == null || matrix.length == 0)
            return false;
        if (matrix[0] == null || matrix[0].length == 0)
            return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        int s = 0, e = row * col - 1;
        while (s + 1 < e){
            int mid = s + (e - s)/2;
            int num = matrix[mid/col][mid%col];
            if (num == target){
                return true;
            }else if (num < target){
                s = mid;
            }else{
                e = mid;
            }
        }
        
        if (matrix[s/col][s%col] == target){
            return true;
        }else if (matrix[e/col][e%col] == target){
            return true;
        }
        return false;
    }
}
