package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Find_Minimum_in_Rotated_Sorted_Array;

public class Find_Minimum_in_Rotated_Sorted_ArrayTest {
	Find_Minimum_in_Rotated_Sorted_Array fm = new Find_Minimum_in_Rotated_Sorted_Array();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFindMin() {
		int[] nums = new int[]{6,1,2,3,4,5};
		fm.findMin3(nums);
	}

}
