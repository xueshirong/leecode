package org.leecode.Test;

import org.junit.Test;
import org.leecode.Combination_Sum;

public class Combination_SumTest {
	Combination_Sum p = new Combination_Sum();
	@Test
	public void testCombinationSum() {
		int[] candidates =  new int[]{2,3,6,7};
		p.combinationSum2(candidates, 7);
	}

}
