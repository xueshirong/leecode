package org.leecode.Test;

import org.junit.Test;
import org.leecode.Set_Matrix_Zeroes;

public class Set_Matrix_ZeroesTest {
	Set_Matrix_Zeroes p = new Set_Matrix_Zeroes();
	@Test
	public void testSetZeroes() {
		int[][] matrix = new int[][]{{0,1}};
		p.setZeroes(matrix);
	}

}
