package org.leecode.Test;

import org.junit.Test;
import org.leecode.Flip_Game;

public class Flip_GameTest {
	Flip_Game p = new Flip_Game();
	@Test
	public void testGeneratePossibleNextMoves() {
		p.generatePossibleNextMoves("++++");
	}

}
