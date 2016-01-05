package org.leecode;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Palindrome_PermutationTest {
	Palindrome_Permutation ng = new Palindrome_Permutation();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCanPermutePalindrome() {
		assertTrue(ng.canPermutePalindrome("aab"));
		assertFalse(ng.canPermutePalindrome("code"));
		assertTrue(ng.canPermutePalindrome("carerac"));
	}

}
