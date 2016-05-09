package org.leecode.Test;

import org.junit.Test;
import org.leecode.Word_Pattern;

public class Word_PatternTest {
	Word_Pattern wp = new Word_Pattern();
	@Test
	public void testWordPattern() {
		String pattern = "aab";
		String str = "dog dog cat";
		wp.wordPattern(pattern, str);
	}

}
