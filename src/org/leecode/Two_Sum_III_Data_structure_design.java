package org.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Two_Sum_III_Data_structure_design {
	/*Design and implement a TwoSum class. It should support the following operations: add and find.

	add - Add the number to an internal data structure.
	find - Find if there exists any pair of numbers which sum is equal to the value.

	For example,
	add(1); add(3); add(5);
	find(4) -> true
	find(7) -> false
	解题思路：
	关键点在于对重复数字的处理，用hashmap存储值，然后判断value-num == num的情况下，count是否>=2.
	*/
}
//solution 1: find is less and add is more
class TwoSum {
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number)+1);
        }else {
            map.put(number, 1);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
		for (Integer i : map.keySet()) {
			int x = value - i;
			if (x == i && map.get(i) >= 2) {
				return true;
			} 
			if (x != i && map.containsKey(x)) {
				return true;
			}
		}
        return false;
    }
}
//more find and less add
class TwoSum2 {
    Set<Integer> sum;
    Set<Integer> num;
    
    TwoSum2(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(num.contains(number)){
	        sum.add(number * 2);
	    }else{
	        Iterator<Integer> iter = num.iterator();
	        while(iter.hasNext()){
	            sum.add(iter.next() + number);
	        }
	        num.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    return sum.contains(value);
	}
}
