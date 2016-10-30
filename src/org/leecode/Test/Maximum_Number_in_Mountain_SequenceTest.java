package org.leecode.Test;

import org.junit.Test;
import org.leecode.Maximum_Number_in_Mountain_Sequence;

public class Maximum_Number_in_Mountain_SequenceTest {
	Maximum_Number_in_Mountain_Sequence p = new Maximum_Number_in_Mountain_Sequence();
	@Test
	public void testMountainSequence() {
		int[] nums = new int[]{10, 9, 8, 7,6,5};
		p.mountainSequence(nums);
	}

}
