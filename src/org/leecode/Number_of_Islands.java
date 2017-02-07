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
}
