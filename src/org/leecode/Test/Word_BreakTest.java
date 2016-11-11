package org.leecode.Test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.leecode.Word_Break;

public class Word_BreakTest {
	Word_Break p = new Word_Break();
	@Test
	public void testWordBreak() {
		Set<String> dict = new HashSet<String>();
		dict.add("b");
		dict.add("a");
		p.wordBreak("ab", dict);
	}
}
