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
		char[][] board = {{'.','8','7','6','5','4','3','2','1'},
				{'2','.','.','.','.','.','.','.','.'},
				{'3','.','.','.','.','.','.','.','.'},
				{'4','.','.','.','.','.','.','.','.'},
				{'5','.','.','.','.','.','.','.','.'},
				{'6','.','.','.','.','.','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'8','.','.','.','.','.','.','.','.'},
				{'9','.','.','.','.','.','.','.','.'}
				};
		vs.isValidSudoku(board);
	}

}
