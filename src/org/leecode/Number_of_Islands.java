package org.leecode;

public class Number_of_Islands {
	//我们遍历矩阵的每一个点，对每个点都尝试进行一次深度优先搜索，如果搜索到1，就继续向它的四周搜索。
	//同时我们每找到一个1，就将其标为0，这样就能把整个岛屿变成0。我们只要记录对矩阵遍历时能进入多少次搜索，就代表有多少个岛屿。
	public int numIslands(char[][] grid) {
        //corner case
        if (grid == null || grid.length ==0 || grid[0].length == 0)
            return 0;
        int m = grid.length, n = grid[0].length, res = 0;
        for (int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (grid[i][j] == '1'){//find an island 1, then change all adjacent island to water(0)
                    res++;
                    helper(grid, i, j);
                }
            }
        }
        return res;
    }
    private void helper(char[][] grid, int i, int j){
        grid[i][j] = 0;
        //search upper col
        if (j > 0 && grid[i][j - 1] == '1')   helper(grid, i, j - 1);
        //search lower col
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1')   helper(grid, i, j + 1);
        //search left row
        if (i > 0 && grid[i -1][j] == '1')   helper(grid, i - 1, j);
        //search right col
        if (i + 1 < grid.length && grid[i + 1][j] == '1')   helper(grid, i + 1, j);
    }
    
    //....思路2， 同419，数“岛屿头”的数目，而不去修改任何值
    //结论：此法不通。因为无法判断‘岛屿头’
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length ==0 || grid[0].length == 0)
            return 0;
        int row = grid.length, col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (i == 0 && j == 0 && grid[0][0] == '1'){
                    count++;
                }else if (grid[i][j] == 'X' && isHead(grid, i, j)){//除了[0][0],都需要用isHead判断是否为头
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isHead(char[][] board, int i, int j){
        if (i - 1 > -1 && board[i - 1][j] == '1')//check 上一个cell
            return false;
        if (j - 1 > -1 && board[i][j - 1] == '1')//check 左边一个cell
            return false;
        return true;
    }
}
