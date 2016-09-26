package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Implement_strStr;

public class Implement_strStrTest {
	Implement_strStr is = new Implement_strStr();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStrStr() {
		String haystack = "abcdabcdefg";
		String needle = "bcd";
		is.strStr(haystack, needle);
	}

	@Test
	public void testStrStr2() {
		String haystack = "abc";
		String needle = "c";
		is.strStr4(haystack, needle);
	}
}
