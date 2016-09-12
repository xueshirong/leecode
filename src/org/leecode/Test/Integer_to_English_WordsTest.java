package org.leecode.Test;

import org.junit.Test;
import org.leecode.Integer_to_English_Words;

public class Integer_to_English_WordsTest {
	Integer_to_English_Words p = new Integer_to_English_Words();
	@Test
	public void testNumberToWords() {
		p.numberToWords(1000000);
	}

}
