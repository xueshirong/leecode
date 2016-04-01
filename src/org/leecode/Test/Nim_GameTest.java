package org.leecode.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Nim_Game;

public class Nim_GameTest {
	Nim_Game ng = new Nim_Game();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCanWinNim() {
		assertTrue(ng.canWinNim(47));
		assertFalse(ng.canWinNim(56));
	}

}
