package org.leecode.bloomberg;

import org.junit.Test;

public class tiny_urlTest {
	tiny_url p = new tiny_url();
	@Test
	public void testLongToShort() {
		String sh = p.longToShort("www.google.com");
		System.out.println(sh);
		
		String lo = p.shortToLong(sh);
		System.out.print(lo);
	}

	@Test
	public void testShortToLong() {
		String s = p.shortToLong("http://tiny.url/000001");
		System.out.print(s);
	}

}
