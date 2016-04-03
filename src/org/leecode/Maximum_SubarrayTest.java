package org.leecode;

import org.junit.Before;
import org.junit.Test;

public class Maximum_SubarrayTest {
	Maximum_Subarray ms = new Maximum_Subarray();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMaxSubArray() {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		ms.maxSubArray(nums);
	}

}
