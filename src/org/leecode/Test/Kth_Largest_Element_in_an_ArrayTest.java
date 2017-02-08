package org.leecode.Test;

import org.junit.Test;
import org.leecode.Kth_Largest_Element_in_an_Array;

public class Kth_Largest_Element_in_an_ArrayTest {
	Kth_Largest_Element_in_an_Array p = new Kth_Largest_Element_in_an_Array();
	@Test
	public void testFindKthLargest2() {
		int[] nums = new int[]{-1, 0,2};
		p.findKthLargest2(nums, 3);
	}

}
