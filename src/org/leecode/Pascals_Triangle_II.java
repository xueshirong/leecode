package org.leecode;

import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle_II {
	public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        if (rowIndex < 0)
            return row;
        row.add(1);
        for(int i = 1; i < rowIndex + 1; i++){//loop rows
            for (int j = i-1; j > 0; j--)//from bach to front to set value
                row.set(j, row.get(j) + row.get(j-1));
                
            row.add(1);
        }
                
        return row;
    }
}
