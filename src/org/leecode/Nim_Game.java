package org.leecode;

import java.util.HashSet;

public class Nim_Game {
	public boolean canWinNim(int n) {
		if (n % 4 != 0)
			return true;
		else
			return false;
    }
}
