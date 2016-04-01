package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {
	public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (numRows <= 0)
            return result;
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(1);//the first row
        result.add(pre);
        for(int i = 1; i < numRows; i++){//begin loop from row 2
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(1);//the first num is 1 of every row
            for(int j = 0; j < pre.size()-1; j++){//calculat value of current row
                cur.add(pre.get(j) + pre.get(j+1));//**important properties**
            }
            cur.add(1);//the last num is 1 of every row
            result.add(cur);//add current row to result list
            pre = cur;//record pre row value
        }
        return result;
    }
}
