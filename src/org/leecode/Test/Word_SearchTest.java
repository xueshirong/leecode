package org.leecode.Test;

import org.junit.Test;
import org.leecode.Word_Search;

public class Word_SearchTest {
	Word_Search p = new Word_Search();
	@Test
	public void testExist() {
		p.exist(new char[][]{{'a'},{'b'}}, "ab");
	}

}
