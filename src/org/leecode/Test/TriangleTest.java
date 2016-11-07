package org.leecode.Test;

import org.junit.Test;
import org.leecode.Triangle;

public class TriangleTest {
	Triangle p = new Triangle();
	@Test
	public void testMinimumTotal() {
		int[][] triangle =  new int[][]{{2},{3,4},{6,5,7},{4,1,8,3}};
		p.minimumTotal(triangle);
	}

}
