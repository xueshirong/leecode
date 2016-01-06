package org.leecode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Move_Zeroes_Test {
	Move_Zeroes mz = new Move_Zeroes();
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
