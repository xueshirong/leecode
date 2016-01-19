package org.leecode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Excel_Sheet_Column_NumberTest {
	Excel_Sheet_Column_Number escn = new Excel_Sheet_Column_Number();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTitleToNumber() {
		assertEquals(escn.titleToNumber("AB"), 52);
	}

}
