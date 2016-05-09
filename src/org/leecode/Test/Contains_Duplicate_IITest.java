package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Contains_Duplicate_II;

public class Contains_Duplicate_IITest {
	Contains_Duplicate_II cdii = new Contains_Duplicate_II();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testContainsNearbyDuplicate() {
		int[] nums = new int[]{4,1,2,3,1,5};
		cdii.containsNearbyDuplicate(nums, 3);
		
	}

}
