package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Majority_Element;

public class Majority_ElementTest {
	Majority_Element me = new Majority_Element();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMajorityElement() {
		int[] nums = new int[]{1,1,3,4,4,4};
		me.majorityElement(nums);
	}

}
