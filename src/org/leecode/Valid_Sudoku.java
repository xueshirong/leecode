package org.leecode;

import java.util.HashSet;
import java.util.Set;

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

	public boolean isValidSudoku2(char[][] board) {
        if (checkRows(board) && checkCols(board) && checkBoxs(board))
            return true;
        return false;
    }
    private boolean checkBoxs(char[][] board){
        for (int i= 0; i < 9; i+=3){
            for (int j= 0; j < 9; j+=3){
                Set<Character> set = new HashSet<Character>();
                for(int k = 0; k < 9; k++){//key point
                    if (board[i+k/3][j+k%3] != '.' && !set.add(board[i+k/3][j+k%3]))
                    return false;
                }
            }
        }
        return true;
    }
    private boolean checkRows(char[][] board){
        for(int i = 0; i < board.length; i++){
            Set<Character> set = new HashSet<Character>();
            for(int j = 0; j < board[i].length; j++){
                if (board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
    private boolean checkCols(char[][] board){
        for(int j = 0; j < board[0].length; j++){
            Set<Character> set = new HashSet<Character>();
            for(int i = 0; i < board.length; i++){
                if (board[i][j] != '.' && !set.add(board[i][j]))
                    return false;
            }
        }
        return true;
    }
}
