package org.leecode.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Move_Zeroes2;

public class Move_Zeroes_Test {
	Move_Zeroes2 mz = new Move_Zeroes2();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMoveZeroes() {
		int[] nums = new int[]{0,1,0,3,12};
		int[] nums1 = new int[]{1,3,12,0,0};
		nums = mz.moveZeroes(nums);
		assertEquals(nums,nums1);
	}
}
