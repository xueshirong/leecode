package org.leecode;

public class Paint_House {
	//思路：直到房子i，其最小的涂色开销是直到房子i-1的最小涂色开销，加上房子i本身的涂色开销。
	//但是房子i的涂色方式需要根据房子i-1的涂色方式来确定，所以我们对房子i-1要记录涂三种颜色分别不同的开销，
	//这样房子i在涂色的时候，我们就知道三种颜色各自的最小开销是多少了。
	//我们在原数组上修改，可以做到不用空间。
	public int minCost(int[][] costs) {
		if (costs == null || costs.length == 0)
			return 0;
		int len = costs.length;
		for (int i = 1; i < len; i++){
			costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i -1][2]);
			costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i -1][2]);
			costs[i][2] = costs[i][2] + Math.min(costs[i - 1][0], costs[i -1][1]);
		}	
		return Math.min(costs[len - 1][0],Math.min(costs[len - 1][1], costs[len - 1][2]));
	}
}
