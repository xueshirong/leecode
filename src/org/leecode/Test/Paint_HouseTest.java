package org.leecode.Test;

import org.junit.Test;
import org.leecode.Paint_House;

public class Paint_HouseTest {
	Paint_House p = new Paint_House();
	@Test
	public void testMinCost2() {
		int[][] costs = new int[][]{{20,18,4},{9,9,10}};
		p.minCost2(costs);
	}

}
