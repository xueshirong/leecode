package org.leecode.Test;

import org.junit.Test;
import org.leecode.Shortest_Word_Distance;

public class Shortest_Word_DistanceTest {
	Shortest_Word_Distance p = new Shortest_Word_Distance();
	@Test
	public void testShortestDistance2() {
		String[] words = new String[]{"a", "b"};
		p.shortestDistance2(words, "a", "b");
	}

}
