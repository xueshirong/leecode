package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Happy_Number;

public class Happy_NumberTest {
	Happy_Number hn = new Happy_Number();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsHappy() {
		assertTrue(hn.isHappy(19));
	}

}
