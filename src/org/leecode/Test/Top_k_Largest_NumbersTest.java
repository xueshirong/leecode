package org.leecode.Test;

import org.junit.Test;
import org.leecode.Top_k_Largest_Numbers;

public class Top_k_Largest_NumbersTest {
	Top_k_Largest_Numbers p = new Top_k_Largest_Numbers();
	@Test
	public void testTopk() {
		int[] nums = new int[]{3,10,1000,-99,4,100};
		p.topk(nums, 3);
	}

}
