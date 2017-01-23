package org.leecode.Test;

import org.junit.Test;
import org.leecode.Find_All_Anagrams_in_a_String;

public class Find_All_Anagrams_in_a_StringTest {
	Find_All_Anagrams_in_a_String p = new Find_All_Anagrams_in_a_String();
	@Test
	public void testFindAnagrams() {
		p.findAnagrams("cbaebabacd", "abc");
	}

}
