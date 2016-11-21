package org.leecode.Test;

import org.junit.Test;
import org.leecode.Interleaving_String;

public class Interleaving_StringTest {
	Interleaving_String p = new Interleaving_String();
	@Test
	public void testIsInterleave() {
		p.isInterleave("a", "", "a");
	}

}
