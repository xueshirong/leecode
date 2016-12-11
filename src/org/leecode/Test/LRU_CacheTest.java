package org.leecode.Test;

import org.junit.Test;
import org.leecode.LRU_Cache;

public class LRU_CacheTest {

	@Test
	public void testLRU_Cache() {
		LRU_Cache p = new LRU_Cache(2);
		//[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]
		/*p.set(2, 1);
		p.set(1, 1);
		System.out.println(p.get(2));
		p.set(4, 1);
		System.out.println(p.get(1));
		System.out.println(p.get(2));*/
		
	}

}
