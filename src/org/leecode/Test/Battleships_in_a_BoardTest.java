package org.leecode.Test;

import org.junit.Test;
import org.leecode.Battleships_in_a_Board;

public class Battleships_in_a_BoardTest {
	Battleships_in_a_Board p = new Battleships_in_a_Board();
	@Test
	public void testCountBattleships() {
		 char[][] board = {{'X','.','.','X'}, {'.','.','.','X'}, {'.','.','.','X'}};
		p.countBattleships1(board);
	}
}
