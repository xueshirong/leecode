package org.leecode.Test;

import org.junit.Test;
import org.leecode.Three_Sum_Closest;

public class Three_Sum_ClosestTest {
	Three_Sum_Closest p = new Three_Sum_Closest();
	@Test
	public void testThreeSumClosest() {
		int[] nums = new int[]{-3,-2,-5,3,-4};
		p.threeSumClosest(nums, -1);
	}

}
