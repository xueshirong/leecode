package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.leecode.Min_Stack;

public class Min_StackTest {
	Min_Stack p = new Min_Stack();
	@Test
	public void testMin_Stack() {
		p.push(512);
		p.push(-1024);
		p.push(-1024);
		p.push(512);
		p.pop();
		assertEquals(p.getMin(), -1024);
		p.pop();
		assertEquals(p.getMin(), -1024);
		p.pop();
		assertEquals(p.getMin(), 512);
	}
	@Test
	public void testPush() {
		fail("Not yet implemented");
	}

	@Test
	public void testPop() {
		fail("Not yet implemented");
	}

	@Test
	public void testTop() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMin() {
		fail("Not yet implemented");
	}

}
