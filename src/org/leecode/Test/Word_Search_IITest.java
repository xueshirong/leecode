package org.leecode.Test;

import org.junit.Test;
import org.leecode.Word_Search_II;

public class Word_Search_IITest {
	Word_Search_II p = new Word_Search_II();
	@Test
	public void testFindWords() {		
		p.findWords(new char[][]{{'a'}}, new String[]{"a"});
	}
}
