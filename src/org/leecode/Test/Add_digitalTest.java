package org.leecode.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Add_digital;

public class Add_digitalTest {
	Add_digital ad = new Add_digital();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddDigits() {
		assertEquals(ad.addDigits(65536), 7);
		assertEquals(ad.addDigits(11), 2);
	}

}
