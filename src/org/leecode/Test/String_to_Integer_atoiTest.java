package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.String_to_Integer_atoi;

public class String_to_Integer_atoiTest {
	String_to_Integer_atoi p = new String_to_Integer_atoi();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMyAtoi() {
		p.myAtoi2("9223372036854775809");
	}

}
