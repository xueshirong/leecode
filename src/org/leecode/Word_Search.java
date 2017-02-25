package org.leecode;

public class Word_Search {
	//思路：以board上的每个cell为出发点，利用depth first search向上下左右四个方向搜索匹配word。
    //搜索的时候要考虑board的边界，cell是否已经在DFS的路径上被用过，以及cell上的值是否与word的当前字符匹配。
    //为了跟踪DFS的路径避免同一个cell被访问多次，使用一个visited矩阵来代表board上任意的cell(i, j)是否已经被访问过。
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word.equals(""))
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                boolean res = helper(board, word, visited, i, j, 0);
                if (res)
                    return true;
            }
        }
        return false;
    }
    private boolean helper(char[][] board, String word, boolean[][] visited, int i, int j, int index){
        if (index == word.length())
            return true;
        //(1) 当前坐标是否在board内
        //(2) 当前cell是否已经在本次DFS路径上已经被访问
        //(3) 当前cell是否匹配当前word中的字符。
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(index))
            return false;
            
        visited[i][j] = true;
        if (helper(board, word, visited, i - 1, j, index + 1))
            return true;
        if (helper(board, word, visited, i + 1, j, index + 1))
            return true;
        if (helper(board, word, visited, i, j - 1, index + 1))
            return true;
        if (helper(board, word, visited, i, j + 1, index + 1))
            return true;
        visited[i][j] = false;
        return false;
    }
    
    //without using extra space 'visited'.
    public boolean exist1(char[][] board, String word) {
    	boolean res = false;
    	if (board == null || board.length == 0 || word.equals(""))
    		return res;
    	
    	for (int i = 0; i < board.length; i++){
    		for (int j = 0; j < board[0].length; j++){
    			res = helper1(board, word, i, j, 0);
    			if (res)
    				return res;
    		}
    	}    	
    	return res;
    }
    private boolean helper1(char[][] board, String word, int i, int j, int index){
    	if (index == word.length())	return true;
    	if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] != word.charAt(index))
    		return false;
    	board[i][j] = '#';//key point. in place to record the visited cell
    	if (helper1(board, word, i - 1, j, index + 1) ||
    			helper1(board, word, i + 1, j, index + 1) ||
    			helper1(board, word, i, j - 1, index + 1) ||
    			helper1(board, word, i, j + 1, index + 1)
    		)
    		return true;
    	board[i][j] = word.charAt(index);
    	return false;
    }
}
