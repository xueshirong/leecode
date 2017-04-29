package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Valid_Anagram;

public class Valid_AnagramTest {
	Valid_Anagram va = new Valid_Anagram();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsAnagram() {
		String s ="abc";
		String t ="bac";
		assertTrue(va.isAnagram(s, t));
	}

}
