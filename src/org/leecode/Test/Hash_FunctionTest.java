package org.leecode.Test;

import org.junit.Test;
import org.leecode.Hash_Function;

public class Hash_FunctionTest {
	Hash_Function p = new Hash_Function();
	@Test
	public void testHashCodeCharArrayInt() {
		char[] key = new char[]{'u','b','u','n','t','u'};
		p.hashCode2(key, 1007);
	}

}
