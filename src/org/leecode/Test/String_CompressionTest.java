package org.leecode.Test;

import org.junit.Test;
import org.leecode.String_Compression;

public class String_CompressionTest {
	String_Compression p = new String_Compression();
	@Test
	public void testCompress() {
		String ss = p.compress("abcaaabbb");
		System.out.println(ss);
	}

}
