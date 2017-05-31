package AM;

import java.util.*;

public class MinStep_Maze {
	public static void main(String[] args) {
		int[][] arr = new int[][]{
			{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
            {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
            {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
            {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }
        };
		int min = findMinSteps(arr, 9, 10, 3, 4);
		System.out.println(min);
	}

	private static int findMinSteps(int[][] maze, int rows, int cols, int er, int ec) {
		if (rows < 1 || cols < 1 || er < 0 || ec < 0 || er >= rows || ec >= cols || maze[0][0] == 0)
			return -1;
		
		int[][] arr = new int[rows][cols];
		for (int i = 0; i < rows; i++) { 
			for (int j = 0; j < cols; j++) 
				arr[i][j] = maze[i][j];
		}
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0,0,0));
		while (!q.isEmpty()){
			Node cur = q.poll();
			if (cur.row == er && cur.col == ec)
				return cur.distance;
			findNext(arr, rows, cols, cur, q);
		}		
		return -1;
	}

	private static void findNext(int[][] maze, int rows, int cols, Node node, Queue<Node> q) {
		int x = node.row;
		int y = node.col;
		int dis = node.distance;
		maze[x][y] = 0;
		if (x - 1 >= 0 && maze[x - 1][y] == 1)
			q.add(new Node(x - 1, y, dis + 1));
		if (x + 1 < rows && maze[x + 1][y] == 1)
			q.add(new Node(x + 1, y, dis + 1));
		if (y - 1 >= 0 && maze[x][y - 1] == 1)
			q.add(new Node(x, y - 1, dis + 1));
		if (y + 1 < cols && maze[x][y + 1] == 1)
			q.add(new Node(x, y + 1, dis + 1));
	}
}

class Node{
	int row;
	int col;
	int distance;
	Node(int x, int y, int distance){
		this.row = x;
		this.col = y;
		this.distance = distance;
	}
}
