package org.leecode.Test;

import org.junit.Test;
import org.leecode.Simplify_Path;

public class Simplify_PathTest {
	Simplify_Path p = new Simplify_Path();
	@Test
	public void testSimplifyPath() {
		p.simplifyPath("/home/foo/.ssh/../.ssh2/authorized_keys/");
	}

}
