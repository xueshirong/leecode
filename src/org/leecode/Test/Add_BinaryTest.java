package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Add_Binary;

public class Add_BinaryTest {
	Add_Binary p = new Add_Binary();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddBinary() {
		p.addBinary("1010", "1011");
	}

}
