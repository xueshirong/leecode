package org.leecode.Test;

import org.junit.Test;
import org.leecode.Maximum_Subarray;

public class Maximum_SubarrayTest {
	Maximum_Subarray p = new Maximum_Subarray();
	@Test
	public void testMaxSubArray2() {
		int[] A = new int[]{-2,2,-3,4,-1,2,1,-5,3};
		p.maxSubArray(A);
	}

}
