package org.leecode.Test;

import org.junit.Test;
import org.leecode.Range_Sum_Query_Immutable;

public class Range_Sum_Query_ImmutableTest {

	int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
	Range_Sum_Query_Immutable p = new Range_Sum_Query_Immutable(nums);
	
	@Test
	public void testSumRange() {
		p.sumRange(2, 5);
	}
}
