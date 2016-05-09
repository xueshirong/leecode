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
		int[] nums = new int[]{4,5,6,7,0,1,2};
		fm.findMin(nums);
	}

}
