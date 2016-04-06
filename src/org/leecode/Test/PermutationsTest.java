package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Permutations;

public class PermutationsTest {
	Permutations p = new Permutations();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPermute() {
		int[] nums = new int[]{1,2,3};
		p.permute(nums);
	}
	
	@Test
	public void testPermute2() {
		int[] nums = new int[]{1,2,3};
		p.permute2(nums);
	}

}
