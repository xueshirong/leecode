package org.leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals {
	/**
	 * Definition for an interval.
	 */
	 public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	 }
	 
	//思路：题意很明确，首先对各区间按开始来排序，最后遍历，如果前面和后面的区间有重合，合并。
    class newcompare implements Comparator<Interval>{
        public int compare(Interval il, Interval i2){
            return il.start - i2.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        //corner case
        if (intervals == null || intervals.size() == 0)
            return res;
        Collections.sort(intervals, new newcompare());
        Interval pre = intervals.get(0);
        res.add(pre);
        for (int i = 1; i < intervals.size(); i++){//from i = 1
            Interval cur = intervals.get(i);
            if (cur.start <= pre.end){// <=
                pre.end = Math.max(cur.end, pre.end);
            }else{
                res.add(cur);
                pre = cur;
            }
        }
        return res;
    }
}
