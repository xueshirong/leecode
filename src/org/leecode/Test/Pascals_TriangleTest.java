package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Pascals_Triangle;

public class Pascals_TriangleTest {
	Pascals_Triangle pt = new Pascals_Triangle();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGenerate() {
		pt.generate(5);
	}

}
