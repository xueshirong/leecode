package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Compare_Version_Number;

public class Compare_Version_NumberTest {
	Compare_Version_Number p = new Compare_Version_Number();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCompareVersion() {
		String version1 = "01";
		String version2 = "1";
		p.compareVersion(version1, version2);		
	}

}
