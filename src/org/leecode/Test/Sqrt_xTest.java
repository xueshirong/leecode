package org.leecode.Test;

import org.junit.Test;
import org.leecode.Sqrt_x;

public class Sqrt_xTest {
	Sqrt_x p = new Sqrt_x();
	@Test
	public void testSqrt() {
		int val = p.sqrt(2147483647);
		System.out.print(val);
	}

}
