package org.leecode.Test;

import org.junit.Test;
import org.leecode.Unique_Paths_II;

public class Unique_Paths_IITest {
	Unique_Paths_II p = new Unique_Paths_II();
	@Test
	public void testUniquePathsWithObstacles() {
		int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
		p.uniquePathsWithObstacles(obstacleGrid);
	}

}
