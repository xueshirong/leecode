package org.leecode.Test;

import org.junit.Test;
import org.leecode.Search_a_2D_Matrix;

public class Search_a_2D_MatrixTest {
	Search_a_2D_Matrix p = new Search_a_2D_Matrix();
	@Test
	public void testSearchMatrix() {
		int[][] matrix = new int[][]{
			{1,5,10,11,16,23,24,26,29,34,41,48,49,56,63,67,71,74,75},
			{97,118,131,150,160,182,202,226,251,273,289,310,326,349,368,390,401,412,428},
			{445,455,466,483,501,519,538,560,581,606,631,643,653,678,702,726,748,766,781},
			{792,817,837,858,872,884,901,920,936,957,972,982,1001,1024,1044,1063,1086,1098,1111},
			{1129,1151,1172,1194,1213,1224,1234,1250,1267,1279,1289,1310,1327,1348,1371,1393,1414,1436,1452},
			{1467,1477,1494,1510,1526,1550,1568,1585,1599,1615,1625,1649,1663,1674,1693,1710,1735,1750,1769}
			};
		p.searchMatrix(matrix, 1086);
	}

}
