package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens {
	/**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    public ArrayList<ArrayList<String>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        //corner case
        if (n <= 0)
            return res;
        
        List<Integer> path = new ArrayList<Integer>();
        helper(res, path, n);
        return res;
    }
    private void helper(ArrayList<ArrayList<String>> res, List<Integer> path, int n){
        if (path.size() == n){
            ArrayList<String> board = getboard(path);
            res.add(board);
            return;
        }
        for (int i = 0; i< n; i++){
            if (!isValid(path, i)){
                continue;
            }
            path.add(i);
            helper(res, path, n);
            path.remove(path.size() - 1);
        }
    }
    private boolean isValid(List<Integer> path, int col){
        int row = path.size();
        for (int i = 0; i < path.size(); i++){
            if (path.get(i) == col)
                return false;
            if (i + path.get(i) == row + col)
                return false;
            if (i - path.get(i) == row - col)
                return false;
        }
        return true;
    }

    private ArrayList<String> getboard(List<Integer> path){
        ArrayList<String> board = new ArrayList<String>();
        for (int i = 0; i < path.size(); i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < path.size(); j++){
                if(j == path.get(i))//note: compare with get(i)
                    sb.append("Q");
                else
                    sb.append(".");
            }
            board.add(sb.toString());
        }
        return board;
    }
}
