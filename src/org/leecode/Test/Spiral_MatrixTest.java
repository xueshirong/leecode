package org.leecode.Test;

import org.junit.Test;
import org.leecode.Spiral_Matrix;

public class Spiral_MatrixTest {
	Spiral_Matrix p = new Spiral_Matrix();
	@Test
	public void testSpiralOrder() {
		p.spiralOrder1(new int[][]{{2,5,8}, {4,0,-1}});
	}

}
