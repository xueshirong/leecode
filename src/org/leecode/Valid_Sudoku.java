package org.leecode;

import java.util.HashSet;

public class Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < board.length; i++){//check rows
        	set = new HashSet<Character>();
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == '.'){
                    continue;
                }
                if (!set.add(board[i][j])){
                    return false;
                }
            }
        }
        set = new HashSet<Character>();
        for (int i = 0; i < board.length; i++){//check cols
        	set = new HashSet<Character>();
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == '.'){
                    continue;
                }
                if (!set.add(board[j][i])){
                    return false;
                }
            }
        }
        
        for (int i = 0; i < 3; i++){//check small Sudoku
            for (int j = 0; j < 3; j++){
                set = new HashSet<Character>();
                for (int m = 3*i; m < 3*i + 3; m++){
                    for (int n = 3*j; n < 3*j + 3;n++){
                        if (board[m][n] == '.'){
                            continue;
                        }
                        if (!set.add(board[m][n])){
                            return false;
                        }
                    }
                }
            }
            
        }
        return true;
    }
}
