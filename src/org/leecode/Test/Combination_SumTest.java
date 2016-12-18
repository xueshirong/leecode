package org.leecode.Test;

import org.junit.Test;
import org.leecode.Combination_Sum;

public class Combination_SumTest {
	Combination_Sum p = new Combination_Sum();
	@Test
	public void testCombinationSum() {
		int[] candidates =  new int[]{1,2,3,4,5,6,7};
		p.combinationSum(candidates, 7);
	}

}
