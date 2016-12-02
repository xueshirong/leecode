package org.leecode.Test;

import org.junit.Test;
import org.leecode.Subarray_Sum;

public class Subarray_SumTest {
	Subarray_Sum p = new Subarray_Sum();
	@Test
	public void testSubarraySum() {
		int[] nums = new int[]{-3, 1, 2, -3, 4};
		p.subarraySum2(nums);
	}

}
