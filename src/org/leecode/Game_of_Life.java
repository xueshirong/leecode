package org.leecode;

public class Game_of_Life {
	//use extra array to save old data
    public void gameOfLife1(int[][] board) {
        //corner case
        if (board == null)  return;
        int m = board.length, n = board[0].length;
        int[][] oldboard = new int[m][n];
        //copy data to array
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                oldboard[i][j] = board[i][j];
            }
        }
        //begin to change cell
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                int count = countLiveCell(oldboard, i, j);
                changeCell(board, i, j, count);
            }
        }
    }
    private int countLiveCell(int[][] oldboard, int i, int j){
        int count = 0;
        int m = oldboard.length, n = oldboard[0].length;
        if (j - 1 >= 0 && oldboard[i][j - 1] == 1) count++;
        if (j + 1 < n && oldboard[i][j + 1] == 1) count++;
        if (i - 1 >= 0 && oldboard[i - 1][j] == 1) count++;
        if (i + 1 < m && oldboard[i + 1][j] == 1) count++;
        if (i - 1 >= 0 && j - 1 >= 0 && oldboard[i - 1][j - 1] == 1) count++;
        if (i - 1 >= 0 && j + 1 < n && oldboard[i - 1][j + 1] == 1) count++;
        if (i + 1 < m && j - 1 >= 0 && oldboard[i + 1][j - 1] == 1) count++;
        if (i + 1 < m && j + 1 < n && oldboard[i + 1][j + 1] == 1) count++;
        return count;
    }
    
    private void changeCell(int[][] board, int i, int j, int count){
        if (board[i][j] == 1){
            if (count < 2 || count > 3){
                board[i][j] = 0;
            }else{
                board[i][j] = 1;
            }
        }else if (count == 3){
            board[i][j] = 1;
        }
    }
    
    //....solution 2 ...in place
    //00:dead - dead; 11:live - live; 10:live - dead; 01:dead - live
    public void gameOfLife(int[][] board) {
        if (board == null)  return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++){//将所有值变为0,1,2,3表示
            for (int j = 0; j < n; j++){
                int count = countLiveCell2(board, i, j);
                changeCell2(board, i, j, count);
            }
        }
        for (int i = 0; i < m; i++){//将0,1,2,3变回0,1
            for (int j = 0; j < n; j++){
                board[i][j] = board[i][j] % 2;
            }
        }            
    }
    private int countLiveCell2(int[][] board, int i, int j){
        int count = 0;
        int m = board.length, n = board[0].length;
        if (j - 1 >= 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 2)) count++;
        if (j + 1 < n && (board[i][j + 1] == 1 || board[i][j + 1] == 2)) count++;
        if (i - 1 >= 0 && (board[i - 1][j] == 1 || board[i - 1][j] == 2)) count++;
        if (i + 1 < m && (board[i + 1][j] == 1 || board[i + 1][j] == 2)) count++;
        if (i - 1 >= 0 && j - 1 >= 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2)) count++;
        if (i - 1 >= 0 && j + 1 < n && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2)) count++;
        if (i + 1 < m && j - 1 >= 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2)) count++;
        if (i + 1 < m && j + 1 < n && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2)) count++;
        return count;
    }
    private void changeCell2(int[][] board, int i, int j, int count){
        if (board[i][j] == 1){
            if (count < 2 || count > 3){
                board[i][j] = 2;
            }else{
                board[i][j] = 1;
            }
        }else if (count == 3){
            board[i][j] = 3;
        }
    }
}
