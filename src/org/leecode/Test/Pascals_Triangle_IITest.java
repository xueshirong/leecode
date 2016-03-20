package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Pascals_Triangle_II;

public class Pascals_Triangle_IITest {
	Pascals_Triangle_II pt = new Pascals_Triangle_II();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetRow() {
		pt.getRow(3);
	}

}
