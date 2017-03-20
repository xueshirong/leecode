package org.leecode.Test;

import org.junit.Test;
import org.leecode.Frog_Jump;

public class Frog_JumpTest {
	Frog_Jump p = new Frog_Jump();
	@Test
	public void testCanCross() {
		p.canCross2(new int[]{0,1,3,4,5,7,9,10,12});
	}

}
