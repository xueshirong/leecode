package org.leecode.Test;

import org.junit.Test;
import org.leecode.Next_Permutation;

public class Next_PermutationTest {
	Next_Permutation p = new Next_Permutation();
	@Test
	public void testNextPermutation() {
		int[] arr = new int[]{1,2,4,6,5,1};
		p.nextPermutation(arr);
	}

}
