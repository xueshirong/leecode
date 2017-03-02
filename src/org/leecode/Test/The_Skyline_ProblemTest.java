package org.leecode.Test;

import org.junit.Test;
import org.leecode.The_Skyline_Problem;

public class The_Skyline_ProblemTest {
	The_Skyline_Problem p = new The_Skyline_Problem();
	@Test
	public void testGetSkyline() {

		p.getSkyline(new int[][]{{2,9,10}, {3,7,15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
	}

}
