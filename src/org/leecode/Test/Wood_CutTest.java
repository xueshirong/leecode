package org.leecode.Test;

import org.junit.Test;
import org.leecode.Wood_Cut;

public class Wood_CutTest {
	Wood_Cut p = new Wood_Cut();
	@Test
	public void testWoodCut() {
		int[] L = new int[]{232, 124, 456};
		p.woodCut(L, 7);
	}

}
