package org.leecode.Test;

import org.junit.Test;
import org.leecode.Minimum_Path_Sum;

public class Minimum_Path_SumTest {
	Minimum_Path_Sum p = new Minimum_Path_Sum();
	@Test
	public void testMinPathSum() {
		int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
		p.minPathSum(grid);
	}
}
