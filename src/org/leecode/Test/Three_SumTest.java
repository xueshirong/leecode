package org.leecode.Test;

import org.junit.Test;
import org.leecode.Three_Sum;

public class Three_SumTest {
	Three_Sum p = new Three_Sum();
	@Test
	public void testThreeSum() {
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		p.threeSum(nums);
	}

}
