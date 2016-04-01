package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Merge_Sorted_Array;

public class Merge_Sorted_ArrayTest {
	Merge_Sorted_Array msa = new Merge_Sorted_Array();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMerge() {
		int[] nums1 = new int[]{4,5,6,0,0,0};
		int[] nums2 = new int[]{1,2,3};
		msa.merge(nums1, 3, nums2, 3);
	}

}
