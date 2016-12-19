package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_II {
	/**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        //corner case
        if (n <= 0)
            return 0;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        helper(res, path, n);
        return res.size();
    }
    private void helper(List<List<Integer>> res, List<Integer> path, int n){
        if (path.size() == n){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = 0; i < n; i++){
            if (!isValid(path, i))
                continue;
            path.add(i);
            helper(res, path, n);
            path.remove(path.size() - 1);
        }
    }
    private boolean isValid(List<Integer> path, int col){
        int row = path.size();
        for (int rowIndex = 0; rowIndex < path.size(); rowIndex++){
            if (path.get(rowIndex) ==  col)
                return false;
            if (rowIndex - path.get(rowIndex) == row - col)
                return false;
            if (rowIndex + path.get(rowIndex) == row + col)
                return false;
        }
        return true;
    }
}
