package org.leecode;

import java.util.Arrays;
import java.util.Comparator;

import org.leecode.Merge_Intervals.Interval;

public class Meeting_Rooms {
	public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return true;
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        for (int i = 0; i < intervals.length; i++){
            if (i != 0 && intervals[i].start < intervals[i-1].end)
                return false;
        }
        return true;
    }
}
