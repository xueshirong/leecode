package org.leecode.Test;

import org.junit.Before;
import org.junit.Test;
import org.leecode.Valid_Sudoku;

public class Valid_SudokuTest {
	Valid_Sudoku vs = new Valid_Sudoku();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsValidSudoku() {
		char[][] board = {
				{'.','.','4','.','.','.','6','3','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','9'},
				{'.','.','.','5','6','.','.','.','.'},
				{'4','.','3','.','.','.','.','.','1'},
				{'.','.','.','7','.','.','.','.','.'},
				{'.','.','.','5','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'},
				{'.','.','.','.','.','.','.','.','.'}
				};
		vs.isValidSudoku2(board);
	}

}
