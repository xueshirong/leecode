package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Rotate_Array;

public class Rotate_ArrayTest {
	Rotate_Array ra = new Rotate_Array();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRotate() {
		int[] nums = new int[]{1,2,3};
		ra.rotate(nums, 1);
	}

}
