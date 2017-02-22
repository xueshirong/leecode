package org.leecode.Test;

import org.junit.Test;
import org.leecode.Number_of_Islands;

public class Number_of_IslandsTest {
	Number_of_Islands p = new Number_of_Islands();
	@Test
	public void testNumIslands() {
		char[][] grid = new char[][]{{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
		p.numIslands1(grid);
	}

}
