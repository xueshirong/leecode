package org.leecode.Test;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.leecode.Longest_Common_Substring;

public class Longest_Common_SubstringTest {
	Longest_Common_Substring p = new Longest_Common_Substring();
	@Test
	public void testLongestCommonSubstring() {
		p.longestCommonSubstring("ABCD", "CBCE");
	}

}
