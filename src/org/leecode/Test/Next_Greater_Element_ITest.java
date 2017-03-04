package org.leecode.Test;

import org.junit.Test;
import org.leecode.Next_Greater_Element_I;

public class Next_Greater_Element_ITest {
	Next_Greater_Element_I p = new Next_Greater_Element_I();
	@Test
	public void testNextGreaterElement() {
		int[] findNums = new int[]{1,3,5,2,4};
		int[] nums = new int[]{6,5,4,3,2,1,7};
		p.nextGreaterElement(findNums, nums);
	}

}
