package org.leecode.Test;

import org.junit.Test;
import org.leecode.Spiral_Matrix;

public class Spiral_MatrixTest {
	Spiral_Matrix p = new Spiral_Matrix();
	@Test
	public void testSpiralOrder() {
		p.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
	}

}
