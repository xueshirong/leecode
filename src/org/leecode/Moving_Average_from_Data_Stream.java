package org.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Moving_Average_from_Data_Stream {
	Queue<Integer> q;
    int size;
    double sum = 0;
    /** Initialize your data structure here. */
    public Moving_Average_from_Data_Stream(int size) {
        this.size = size;
        q = new LinkedList<Integer>();
    }
    
    public double next(int val) {
        if (q.size() >= size){
            int temp = q.poll();
            sum -= temp;
        }
        q.add(val);
        sum += val;
        return sum / q.size();
    }
}
