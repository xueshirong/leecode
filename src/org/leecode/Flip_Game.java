package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Flip_Game {
	public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+'){
                res.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return res;
    }
}
