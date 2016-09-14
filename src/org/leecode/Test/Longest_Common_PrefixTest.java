package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Longest_Common_Prefix;

public class Longest_Common_PrefixTest {
	Longest_Common_Prefix lcp = new Longest_Common_Prefix();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLongestCommonPrefix() {
		String[] strs = new String[]{"abc","abd", "abm"};
		lcp.longestCommonPrefix2(strs);
	}

}
