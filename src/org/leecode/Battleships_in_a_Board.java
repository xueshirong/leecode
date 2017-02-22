package org.leecode;

public class Battleships_in_a_Board {
	public int countBattleships(char[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0))
            return 0;
        int row = board.length, col = board[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
            	char c = board[i][j];
                if (c == 'X'){
                    count++;
                    changeAdjacent(board, i, j);
                }
            }
        }
        return count;
    }
    private void changeAdjacent(char[][] board, int i, int j){
        int row = board.length, col = board[0].length;
        for (int k = j; k < col; k++){
        	char c = board[i][k];
            if (c == 'X')
                board[i][k] = '.';
            else
                break;
        }
        for (int k = i; k < row; k++){
        	char c = board[k][j];
            if (c == 'X')
                board[k][j] = '.';
            else
                break;
        }
    }
    
  //思路2：计算“岛屿头”，即左边和上边都不是‘X’的cell，就是‘头’
    public int countBattleships1(char[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0))
            return 0;
        int row = board.length, col = board[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 && j == 0 && board[0][0] == 'X'){
                    count++;
                }else if (board[i][j] == 'X' && isHead(board, i, j)){//除了[0][0],都需要用isHead判断是否为头
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isHead(char[][] board, int i, int j){
        if (i - 1 > -1 && board[i - 1][j] == 'X')//check 上一个cell
            return false;
        if (j - 1 > -1 && board[i][j - 1] == 'X')//check 左边一个cell
            return false;
        return true;
    }
}
